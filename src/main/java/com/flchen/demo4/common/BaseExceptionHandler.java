package com.flchen.demo4.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author feilongchen
 * @create 2018-06-25 3:59 PM
 */
public abstract class BaseExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);

	/**
	 * 处理自定义异常类
	 * @param request
	 * @param response
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = {CustomeException.class})
	public ErrorResponseEntity customeExceptionHandler(HttpServletRequest request, HttpServletResponse response, final Exception e) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		CustomeException exception = (CustomeException) e;
		return new ErrorResponseEntity(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler(value = {RuntimeException.class})
	public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, final Exception e) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ErrorResponseEntity(500, e.getMessage());
	}


}
