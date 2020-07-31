package com.example.sentinelredis;

import com.uih.uplus.common.utils.basic.EnvUtil;
import com.uih.uplus.common.utils.cache.RedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
//哨兵
//redis是一个key-value存储系统
public class SentinelRedisApplicationTests {


	/*@Autowired
	private RedisTemplate redisTemplate;*/
	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void test() {
		/*redisTemplate.opsForValue().set("foo", "bar");
		String value = (String) redisTemplate.opsForValue().get("foo");*/
		//键值添加
		redisUtil.set("first", "hello ");
		redisUtil.set("first", "hi ");
		redisUtil.set("second", "redisUtil ");
		redisUtil.set("third", "world");
		//读取缓存(覆盖)
		String value = (String) this.redisUtil.get("first");
		System.out.println(value);
		//读取空的key缓存
		String valueNokey = (String) this.redisUtil.get("eight");
		System.out.println(valueNokey);

		//判断缓存中是否有对应的键
		redisUtil.exists("first");
		//删除对应的缓存
		redisUtil.remove("first");
		String value1 = (String) this.redisUtil.get("first");
		System.out.println(value1);
		boolean a=redisUtil.exists("first");
		boolean b=redisUtil.exists("second");
		System.out.println(a);
		System.out.println(b);

		//添加列表
		redisUtil.lPush("list1","nxx");
		redisUtil.lPush("list1","123");
		redisUtil.lPush("list1","aaa");
		//获取列表
		List<Object> list = new ArrayList<Object>();
		list=redisUtil.lRange("list1",0,-1);
		System.out.println(list);
		//读取与传入字符部分匹配的键集合(???)
		redisUtil.getKeys("lis");
		Set<String> setKey = new HashSet<String>();
		System.out.println(setKey);
		list.clear();
		System.out.println(list);


		//添加元素至集合
		redisUtil.add("set1","a");
		redisUtil.add("set1","b");
		redisUtil.add("set1","c");
		//获取集合
		Set<Object> set = new HashSet<Object>();
		set=redisUtil.setMembers("set1");
		System.out.println(set);

		//添加元素至有序集合，按照分值排序
		redisUtil.zAdd("setSort","basketball",12);
		redisUtil.zAdd("setSort","football",2);
		redisUtil.zAdd("setSort","baseball",24);
		redisUtil.zAdd("setSort","pingPong",16);
		//获取有序集合
		Set<Object> setZ = new HashSet<Object>();
		setZ=redisUtil.rangeByScore("setSort",0,30);
		System.out.println(setZ);

		//哈希 添加
		redisUtil.hmSet("hash1","name","nxx");
		redisUtil.hmSet("hash1","age","26");
		redisUtil.hmSet("hash1","job","it");
		redisUtil.hmSet("hash1","job","ut");
		//哈希 获取
		String hashValue = (String) this.redisUtil.hmGet("hash1","job");


		//Redis锁初始化：
		RedisLock redisLock = new RedisLock("127.0.0.1", 6379, 2000, 100, "DisLock", "123456");
		//获取锁：
		while(!redisLock.lock("yourlockNo",1000*60, 5000)){
			EnvUtil.sleep(1);
		}
		//释放锁：
		while(!redisLock.unLock("yourlockNo")){
			EnvUtil.sleep(1);
		}
	}

}