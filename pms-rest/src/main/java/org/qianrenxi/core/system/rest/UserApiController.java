package org.qianrenxi.core.system.rest;

import org.qianrenxi.core.system.enity.User;
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
	public Page<User> getUsers(User user, Pageable pageable) {
		return userService.findAll(user, pageable);
	}

	@ModelAttribute
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") Long id, Model model) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public User update(User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void delete(@RequestParam("ids") Long[] ids) {
		this.userService.delete(ids);
	}
}
