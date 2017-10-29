package org.qianrenxi.core.system.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;
import org.qianrenxi.core.common.utils.ModelMapperUtils;
import org.qianrenxi.core.system.dto.UserDto;
import org.qianrenxi.core.system.enity.User;
import org.qianrenxi.core.system.service.LdapService;
import org.qianrenxi.core.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

	@Autowired
	UserService userService;
	
	@Autowired
	LdapService ldapService;

	@ModelAttribute
	public User getUser(@RequestParam(name = "id", required = false) Long id) {
		User user = null;
		if (id != null) {
			user = userService.findOne(id);
		}
		if (null == user) {
			user = new User();
		}
		return user;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<UserDto> getUsers(User user, Pageable pageable) {
		Page<User> users = userService.findAll(user, pageable);
		
		Type type = new TypeToken<List<UserDto>>() {}.getType();
		return ModelMapperUtils.map(users, type, pageable);
	}

	@ModelAttribute
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findOne(id);
		
		return ModelMapperUtils.map(user, UserDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public UserDto create(@RequestBody User user) {
		user = userService.save(user);
		
		return ModelMapperUtils.map(user, UserDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public UserDto update(User user) {
		user = userService.save(user);
		
		return ModelMapperUtils.map(user, UserDto.class);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void delete(@RequestParam("ids") Long[] ids) {
		this.userService.delete(ids);
	}
	
	@RequestMapping(value = "sync", method = RequestMethod.POST)
	public void sync() {
		ldapService.sync();
	} 
}
