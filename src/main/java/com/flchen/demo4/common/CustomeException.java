package com.flchen.demo4.common;

import lombok.Data;

/**
 * @author feilongchen
 * @create 2018-06-25 4:47 PM
 */
@Data
public class CustomeException extends RuntimeException{

	private int code;
	private String message;

	public CustomeException(int code) {
		this.code = code;
	}
	public CustomeException(String message) {
		this.message = message;
	}
	public CustomeException(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
