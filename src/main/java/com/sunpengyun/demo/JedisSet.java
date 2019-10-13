package com.sunpengyun.demo;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JedisSet {

	@Autowired
	RedisTemplate redisTemplate;
	@Test
	public void setTest() {
		
		Types types1 = new Types(1001, "张三","爱玩天天狼人杀");
		Types types2 = new Types(1002, "李四","爱玩英雄联盟");
		Types types3 = new Types(1003, "王五","爱玩绝地求生");
		
		redisTemplate.opsForSet().add("mySet", types1,types2,types3);
		Set mySet = redisTemplate.opsForSet().members("mySet");
	    for(Object o : mySet) {
	    	System.out.println(o);
	    }
		
	}
	
	
}
