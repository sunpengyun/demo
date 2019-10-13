package com.sunpengyun.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JedisList {
	@Autowired
	RedisTemplate redisTemplate;
	@Test
	public void listTest() {
		
		ArrayList<Types> list = new ArrayList<Types>();
		
		Types types1 = new Types(1001, "张三","爱玩天天狼人杀");
		Types types2 = new Types(1002, "李四","爱玩英雄联盟");
		Types types3 = new Types(1003, "王五","爱玩绝地求生");
		
		list.add(types1);
		list.add(types2);
		list.add(types3);
		for(Types ty : list) {
			System.out.println(ty);
		}
		//保存list数据到redis数据库
		redisTemplate.opsForList().leftPush("mylist", list);
		
		//从list中获取数据
		List<Types> list1 = (List<Types>) redisTemplate.opsForList().rightPop("mylist");
		
		for(Types types : list1) {
			System.out.println(types);
		}
	}
	
	@Test
	public void hashTest() {
	     HashMap<String, Types> map = new HashMap<String,Types>();
	    
	 	Types types1 = new Types(1001, "张三","爱玩天天狼人杀");
	 	Types types2 = new Types(1002, "李四","爱玩英雄联盟");
	 	Types types3 = new Types(1003, "王五","爱玩爱玩绝地求生");
	 	
	 	map.put("1", types1);
	 	map.put("2", types2);
	 	map.put("3", types3);
	 	
	 	redisTemplate.opsForHash().putAll("myhash", map);
	 	
	 	Map myhash = redisTemplate.opsForHash().entries("myhash");
	 	
	 	Set entrySet = myhash.entrySet();
	 	for(Object o : entrySet) {
	 		System.out.println(o);
	 	}
	 
	 
	     
	}
	
	
}
