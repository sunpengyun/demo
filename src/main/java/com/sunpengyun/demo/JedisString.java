package com.sunpengyun.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JedisString {
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	@Test
	public void typeTest() {
		//利用redis模板set一个String类型的数据
		redisTemplate.opsForValue().set("username", "aaa");
		redisTemplate.opsForValue().append("username", "aaa");
		//redisTemplate.opsForValue().append("username", "bbb");
		
		//获取数据
		String username = redisTemplate.opsForValue().get("username");
		//输出数据
		System.out.println(username);	
	}
	
	

}
