package com.cfh.demo.common.lang.bo;

import lombok.Data;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 11:38
 * @description:
 */
@Data
public class RespBase<T> {

	private int code;

	private String msg;

	private T data;

	public RespBase(int code) {
		this.code = code;
	}

	public RespBase(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public RespBase(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public RespBase(T data) {
		this.data = data;
		this.code = 0;
		this.msg = "";
	}
}
