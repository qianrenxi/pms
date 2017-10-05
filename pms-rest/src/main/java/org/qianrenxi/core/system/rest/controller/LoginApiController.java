package org.qianrenxi.core.system.rest.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.qianrenxi.core.system.constant.Constants;
import org.qianrenxi.core.system.rest.exception.UnauthorizedException;
import org.qianrenxi.core.system.security.UserToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginApiController {

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public void login(UsernamePasswordToken usernamePasswordToken, HttpSession session) {
		SecurityUtils.getSubject().login(usernamePasswordToken);
		session.setAttribute(Constants.SESSION_KEY, SecurityUtils.getSubject().getPrincipal());
	}

	@RequestMapping(value = "/api/logout", method = RequestMethod.GET)
	public void logout() {
		SecurityUtils.getSubject().logout();
	}

	@RequestMapping(value = "/api/stats", method = { RequestMethod.GET, RequestMethod.OPTIONS })
	public void stats() {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			throw new UnauthorizedException();
		}
	}

	@RequestMapping(value = "/api/loginfo", method = RequestMethod.GET)
	public UserToken loginfo() {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			throw new UnauthorizedException();
		}

		return (UserToken) SecurityUtils.getSubject().getPrincipal();
	}
}
