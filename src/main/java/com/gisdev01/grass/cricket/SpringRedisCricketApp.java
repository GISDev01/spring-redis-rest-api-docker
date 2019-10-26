package com.gisdev01.grass.cricket;

import com.gisdev01.grass.cricket.model.Cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisCricketApp {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, Cricket> redisTemplate() {
		RedisTemplate<String, Cricket> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}


	public static void main(String[] args) {
		SpringApplication.run(SpringRedisCricketApp.class, args);
	}
}
