package com.sunpengyun.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class RedisList2 {
	
	@Autowired
	RedisTemplate  redisTemplate;
	
    @Test
    public void redisTemplateTestForRdeilstoTheBegingIndexList() {
    	    //建一个list集合
    	    List<Types> list = new ArrayList<Types>();
    	    //建立对象
    	    Types types1 = new Types(1,"aa", "吃鸡");
    	    Types types2 = new Types(1,"bb", "狼人杀");
    	    Types types3 = new Types(1,"cc", "英雄联盟");
    	    //把对象加入集合
    	    list.add(types1);
    	    list.add(types2);
    	    list.add(types3);
    	    
    	    //使用模板对象存值
    	    //redisTemplate.opsForList().leftPush("mylist", list);
    	    //使用模板对象取值
    	    List<Types> list1 = redisTemplate.opsForList().range("mylist", 0, -1);
    	   
    	    for(Object o :list1) {
    	    	System.out.println(o);
    	    }
    	    
    	    
    	    
    }
    
    
    @Test
    public void hashTest() {
    	HashMap<String, Types> map = new HashMap<String, Types>();
    	Types types1 = new Types(1,"aa", "吃鸡");
	    Types types2 = new Types(2,"bb", "狼人杀");
	    Types types3 = new Types(3,"cc", "英雄联盟");
	    
	    map.put("1", types1);
	    map.put("2", types2);
	    map.put("3", types3);
	    
	    //使用redis模板增加hash数据结构
	    redisTemplate.opsForHash().putAll("myhash", map);
	    //从redis里面查询
	    Map myhash = redisTemplate.opsForHash().entries("myhash");
	    Set entrySet = myhash.entrySet();
	    for(Object o : entrySet) {
	    	System.out.println(o);
	    }
	    
    			
    }
    

}
