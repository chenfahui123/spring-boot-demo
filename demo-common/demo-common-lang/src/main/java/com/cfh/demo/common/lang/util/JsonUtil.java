package com.cfh.demo.common.lang.util;

import com.cfh.demo.common.lang.bo.JsonBase;
import com.cfh.demo.common.lang.exception.CustomException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 11:38
 * @description: 序列化及反序列化工具
 */
public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();

	private static Logger log = LoggerFactory.getLogger(JsonBase.class);

	static {
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	}

	public static String toString(Object object) {
		if (null == object) {
			return null;
		}
		if (object instanceof String) {
			return (String) object;
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error("序列化失败", e);
			throw new CustomException(e);
		}
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		T result;
		try {
			result = objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			log.error("反序列化失败", e);
			throw new CustomException(e);
		}
		return result;
	}

	public static <T> T toObject(String json, TypeReference<T> type) {
		if(StringUtils.isEmpty(json)) {
			return null;
		}
		T result;
		try {
			result = objectMapper.readValue(json.getBytes(), type);
		} catch (IOException e) {
			log.error("反序列化失败",e );
			throw new CustomException(e);
		}
		return result;
	}

	public static Object getCollectionFromJson(String json, Class<?> collectionClazz, Class<?>... elementClazz) {
		if(StringUtils.isEmpty(json)) {
			return null;
		}

		try {
			JavaType javaType =objectMapper.getTypeFactory().constructParametricType(collectionClazz, elementClazz);
			return objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			log.error("发序列化失败");
			throw new CustomException(e);
		}
	}

}
