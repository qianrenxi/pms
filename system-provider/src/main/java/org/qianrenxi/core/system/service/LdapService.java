package org.qianrenxi.core.system.service;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.qianrenxi.core.system.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.ContainerCriteria;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class LdapService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private LdapTemplate ldapTemplate;

	public User authByLdap(String username, String password){
		try {
			ContainerCriteria containerCriteria = LdapQueryBuilder.query().where("cn").is(username);
			List<User> users = ldapTemplate.search(containerCriteria, new UserAttributesMapper());
			if (users != null && !users.isEmpty()) {
				ldapTemplate.authenticate(containerCriteria, password);
				
				// System.out.println(users.get(0));
				return users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}
		return null;
	}
	
	public void sync() {
		ContainerCriteria containerCriteria = LdapQueryBuilder.query().where("ou").is("user");
		List<User> users = ldapTemplate.search(containerCriteria, new UserAttributesMapper());
		
		if (users !=null && !users.isEmpty()) {
			for (User originUser : users) {
				User localUser = userService.findByUsername(originUser.getUsername());
				if (null != localUser) {
					localUser.setEmail(originUser.getEmail());
					localUser.setPhoneNumber(originUser.getPhoneNumber());
					localUser.setFirstName(originUser.getFirstName());
					localUser.setLastName(originUser.getLastName());
					localUser.setDisplayName(originUser.getDisplayName());
					userService.save(localUser);
				} else {
					userService.save(originUser);
				}
			}
		}
	} 
	
	public class UserAttributesMapper implements AttributesMapper<User> {
		@Override
		public User mapFromAttributes(Attributes attrs) throws NamingException {
			User user = new User();
			user.setUsername((String)attrs.get("cn").get());
			user.setEmail((String)attrs.get("mail").get());
			user.setPhoneNumber((String)attrs.get("mobile").get());
			user.setFirstName((String)attrs.get("givenName").get());
			user.setLastName((String)attrs.get("sn").get());
			user.setDisplayName((String)attrs.get("givenName").get() + (String)attrs.get("sn").get());
			return user;
		}
	}
}
