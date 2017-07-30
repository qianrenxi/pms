package org.qianrenxi.core.system.rest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApiController {

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public void login(UsernamePasswordToken usernamePasswordToken) {
		SecurityUtils.getSubject().login(usernamePasswordToken);
	}
	
	@RequestMapping(value = "/api/logout", method = RequestMethod.GET)
	public void logout() {
		SecurityUtils.getSubject().logout();
	}
}
