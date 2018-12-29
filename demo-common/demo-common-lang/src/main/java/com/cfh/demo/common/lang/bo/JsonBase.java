package com.cfh.demo.common.lang.bo;

import com.cfh.demo.common.lang.util.JsonUtil;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 11:38
 * @description:
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class JsonBase {

	@Override
	public String toString() {
		return JsonUtil.toString(this);
	}
}
