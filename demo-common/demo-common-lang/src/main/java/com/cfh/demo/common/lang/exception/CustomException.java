package com.cfh.demo.common.lang.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 11:50
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException{

	private int code;

	public CustomException(String msg) {
		super(msg);
	}

	public CustomException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public CustomException(Throwable ex) {
		super(ex);
	}

}
