package org.qianrenxi.core.system.security;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.core.system.repository.jpa.UserRepository;
import org.qianrenxi.core.system.service.LdapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.ContainerCriteria;
import org.springframework.ldap.query.LdapQueryBuilder;

public class SimpleShiroRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleShiroRealm.class);

	@Autowired
	private UserRepository userRepository;
	// private UserService userService;
	@Autowired
	private LdapService ldapService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//String username = (String) getAvailablePrincipal(principalCollection);
		User user = (User) getAvailablePrincipal(principalCollection);
		logger.info(String.format("用户[%s]权限认证...", user.getUsername()));
		
		//User user = userRepository.findByUsername(username);
		if(user!=null){
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			authorizationInfo.addRole("admin");
			// TODO: 组织权限信息
			return authorizationInfo;
		}
		
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		logger.info(String.format("用户[%s]登录...", token.getUsername()));
		
		User user = userRepository.findByUsername(token.getUsername());
		if(user == null) {
			String password = new String(token.getPassword());
			user = ldapService.authByLdap(token.getUsername(), password);
			
			if (user == null) {
				throw new AuthenticationException("用户名不存在");
			}
			
			user.setPassword(password);
			userRepository.save(user);
		}
		
		// return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		UserToken userToken = new UserToken(user);
		userToken.setCurrentSite(user.getSite());
		return new SimpleAuthenticationInfo(userToken, user.getPassword(), getName());
	}

	@Override
	public void checkPermission(PrincipalCollection principal, Permission permission) throws AuthorizationException {
		// TODO Auto-generated method stub
		super.checkPermission(principal, permission);
	}
	
}
