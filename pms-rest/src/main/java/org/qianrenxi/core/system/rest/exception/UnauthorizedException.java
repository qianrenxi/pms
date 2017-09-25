package org.qianrenxi.core.system.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "UNAUTHORIZED")
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 3679670441021666217L;

}
