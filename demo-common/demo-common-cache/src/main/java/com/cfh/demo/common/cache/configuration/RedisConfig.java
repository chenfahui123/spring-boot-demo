package com.cfh.demo.common.cache.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 11:10
 * @description:
 */

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate getRedisTemplate(){

	}
}
