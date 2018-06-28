package com.flchen.demo4.common;

import lombok.Data;

/**
 * @author feilongchen
 * @create 2018-06-25 4:45 PM
 */
@Data
public class ErrorResponseEntity {

	private int code;

	private String message;

	public ErrorResponseEntity(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
