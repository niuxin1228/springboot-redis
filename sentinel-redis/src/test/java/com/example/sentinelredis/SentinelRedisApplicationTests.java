package com.example.sentinelredis;

import com.uih.uplus.common.utils.basic.EnvUtil;
import com.uih.uplus.common.utils.cache.RedisLock;
import org.junit.Assert;
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
	public void RedissetSuccess() {
		redisUtil.set("first", "hello");
		String value = (String) this.redisUtil.get("first");
		Assert.assertEquals(value,"hello");
	}
	@Test
	public void RedissetcoverSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("first", "hi");
		String value = (String) this.redisUtil.get("first");
		Assert.assertEquals(value,"hi");
	}
	@Test
	public void RedissetnullError() {
		String value=null;
		try {
			redisUtil.set("first", null);
			value = (String) this.redisUtil.get("first");
		}catch (Exception e){
			Assert.assertEquals(value,null);
		}
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedissetmoreSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		String value = (String) this.redisUtil.get("second");
		Assert.assertEquals(value,"redisUtil");
	}
	@Test
	public void RedisremoveSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.remove("first");
		String value = (String) this.redisUtil.get("first");
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedisremovecoverSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("first", "hi");
		redisUtil.remove("first");
		String value = (String) this.redisUtil.get("first");
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedisremoveoneSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		redisUtil.remove("first");
		String value = (String) this.redisUtil.get("second");
		Assert.assertEquals(value,"redisUtil");
	}
	@Test
	public void RedisremovemoreSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		redisUtil.remove("first","second");
		String value = (String) this.redisUtil.get("second");
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedisremovePatternSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.removePattern("fi");
		String value = (String) this.redisUtil.get("first");
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedisremovePatterncoverSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("first", "hi");
		redisUtil.removePattern("fi");
		String value = (String) this.redisUtil.get("first");
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedisremovePatternoneSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		redisUtil.removePattern("fi");
		String valuea = (String) this.redisUtil.get("first");
		String valueb = (String) this.redisUtil.get("second");
		Assert.assertEquals(valuea,null);
		Assert.assertEquals(valueb,"redisUtil");
	}
	@Test
	public void RedisremovePatternmoreSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		redisUtil.removePattern("fi");
		redisUtil.removePattern("on");
		String valuea = (String) this.redisUtil.get("first");
		String valueb = (String) this.redisUtil.get("second");
		Assert.assertEquals(valuea,null);
		Assert.assertEquals(valueb,null);
	}
	@Test
	public void RedisexistsSuccess() {
		redisUtil.set("first", "hello");
		boolean first = redisUtil.exists("first");
		Assert.assertEquals(first,true);
	}
	@Test
	public void RedisexistsnullError() {
		boolean first=false;
		try {
			redisUtil.set("first", null);
			first = redisUtil.exists("first");
		}catch (Exception e){
			Assert.assertEquals(first,false);
		}
		Assert.assertEquals(first,false);
	}
	@Test
	public void RedisexistscoverSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("first", "hi");
		boolean first = redisUtil.exists("first");
		Assert.assertEquals(first,true);
	}
	@Test
	public void RedisexistsmoreSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		redisUtil.set("third", "world");
		boolean first = redisUtil.exists("first");
		boolean second = redisUtil.exists("second");
		boolean third = redisUtil.exists("third");
		Assert.assertEquals(first,true);
		Assert.assertEquals(second,true);
		Assert.assertEquals(third,true);
	}
	@Test
	public void RedisexistsonenullSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		redisUtil.set("third", "world");
		boolean first = redisUtil.exists("first");
		boolean second = redisUtil.exists("second");
		boolean forth = redisUtil.exists("forth");
		Assert.assertEquals(first,true);
		Assert.assertEquals(second,true);
		Assert.assertEquals(forth,false);
	}
	@Test
	public void RedisgetEmptySuccess() {
		redisUtil.set("first", "hello");
		String value = (String) this.redisUtil.get("eight");
		Assert.assertEquals(value,null);
	}
	@Test
	public void RedisgetkeyEmptySuccess() {
		redisUtil.set("first", "hello");
		Set<String> keys = redisUtil.getKeys("eight");
		Assert.assertEquals(keys.toString(),"[]");
	}
	@Test
	public void RedisgetkeySuccess() {
		redisUtil.set("first", "hello");
		Set<String> keys = redisUtil.getKeys("fi");
		Assert.assertEquals(keys.toString(),"[first]");
	}
	@Test
	public void RedisgetkeyendSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		Set<String> keys = redisUtil.getKeys("nd");
		Assert.assertEquals(keys.toString(),"[second]");
	}
	@Test
	public void RedisgetkeymoreSuccess() {
		redisUtil.set("first", "hello");
		redisUtil.set("second", "redisUtil");
		Set<String> keys = redisUtil.getKeys("seconds");
		Assert.assertEquals(keys.toString(),"[]");
	}
	@Test
	public void RedishmSetSuccess() {
		redisUtil.hmSet("hash1","name","nxx");
		String hashValue = (String) this.redisUtil.hmGet("hash1","name");
		Assert.assertEquals(hashValue,"nxx");
	}
	@Test
	public void RedishmSetmoreSuccess() {
		redisUtil.hmSet("hash1","name","nxx");
		redisUtil.hmSet("hash2","sex","male");
		String hashValue = (String) this.redisUtil.hmGet("hash2","sex");
		Assert.assertEquals(hashValue,"male");
	}
	@Test
	public void RedishmSetcoverSuccess() {
		redisUtil.hmSet("hash1","name","nxx");
		redisUtil.hmSet("hash1","name","nl");
		String hashValue = (String) this.redisUtil.hmGet("hash1","name");
		Assert.assertEquals(hashValue,"nl");
	}
	@Test
	public void RedishmSetvaluenullSuccess() {
		redisUtil.hmSet("hash1","name","");
		String hashValue = (String) this.redisUtil.hmGet("hash1","name");
		Assert.assertEquals(hashValue,"");
	}
	@Test
	public void RedislPushSuccess() {
		redisUtil.lPush("list1","nxx");
		redisUtil.lPush("list1","123");
		redisUtil.lPush("list1","aaa");
		List<Object> list = new ArrayList<Object>();
		list=redisUtil.lRange("list1",0,1);
		Assert.assertEquals(list.size(),2);
	}
	@Test
	public void RedislPushmoreSuccess() {
		redisUtil.lPush("list1","nxx");
		redisUtil.lPush("list1","123");
		redisUtil.lPush("list1","aaa");
		List<Object> list = new ArrayList<Object>();
		list=redisUtil.lRange("list1",0,5);
		Assert.assertEquals(list.size(),6);
	}
	@Test
	public void RedislPush0Success() {
		redisUtil.lPush("list1","nxx");
		redisUtil.lPush("list1","123");
		redisUtil.lPush("list1","aaa");
		List<Object> list = new ArrayList<Object>();
		list=redisUtil.lRange("list1",0,0);
		Assert.assertEquals(list.size(),1);
	}
	@Test
	public void RedislPushnegativeError() {
		redisUtil.lPush("list1","nxx");
		redisUtil.lPush("list1","123");
		redisUtil.lPush("list1","aaa");
		List<Object> list = new ArrayList<Object>();
		list=redisUtil.lRange("list1",0,-1);
		System.out.println(list);
		Assert.assertNotEquals(list.size(),2);
	}
	@Test
	public void RedisaddSuccess() {
		redisUtil.add("set1","a");
		redisUtil.add("set1","b");
		redisUtil.add("set1","c");
		Set<Object> set=redisUtil.setMembers("set1");
		Assert.assertEquals(set.size(),4);
	}
	@Test
	public void RedisaddemptySuccess() {
		redisUtil.add("set1","");
		Set<Object> set=redisUtil.setMembers("set1");
		System.out.println(set);
		Assert.assertEquals(set.size(),4);
	}
	@Test
	public void RedisaddemptycoverSuccess() {
		redisUtil.add("set1","a");
		Set<Object> set=redisUtil.setMembers("set1");
		System.out.println(set);
		Assert.assertEquals(set.size(),4);
	}
	@Test
	public void RediszAddSuccess() {
		redisUtil.zAdd("setSort","basketball",12);
		redisUtil.zAdd("setSort","football",2);
		redisUtil.zAdd("setSort","baseball",24);
		redisUtil.zAdd("setSort","pingPong",16);
		Set<Object> setZ=redisUtil.rangeByScore("setSort",0,30);
		Assert.assertEquals(setZ.size(),4);
	}
	@Test
	public void RediszAddscore0Success() {
		redisUtil.zAdd("setSort","basketball",12);
		redisUtil.zAdd("setSort","football",2);
		redisUtil.zAdd("setSort","baseball",24);
		redisUtil.zAdd("setSort","pingPong",16);
		Set<Object> setZ=redisUtil.rangeByScore("setSort",0,0);
		Assert.assertEquals(setZ.size(),0);
	}
	@Test
	public void RediszAddscorenegativeSuccess() {
		redisUtil.zAdd("setSort","basketball",12);
		redisUtil.zAdd("setSort","football",2);
		redisUtil.zAdd("setSort","baseball",24);
		redisUtil.zAdd("setSort","pingPong",16);
		Set<Object> setZ=redisUtil.rangeByScore("setSort",-5,1);
		Assert.assertEquals(setZ.size(),0);
	}
	@Test
	public void RediszAddscorebiggerSuccess() {
		redisUtil.zAdd("setSort","basketball",12);
		redisUtil.zAdd("setSort","football",2);
		redisUtil.zAdd("setSort","baseball",24);
		redisUtil.zAdd("setSort","pingPong",16);
		Set<Object> setZ=redisUtil.rangeByScore("setSort",5,1);
		System.out.println(setZ);
		Assert.assertEquals(setZ.size(),0);
	}
	@Test
	public void test() {
		/*redisTemplate.opsForValue().set("foo", "bar");
		String value = (String) redisTemplate.opsForValue().get("foo");*/
		//键值添加
		redisUtil.set("first", "hello");
		redisUtil.set("first", "hi");
		redisUtil.set("second", "redisUtil");
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


//		//Redis锁初始化：
//		RedisLock redisLock = new RedisLock("127.0.0.1", 6379, 2000, 100, "DisLock", "");
//		//获取锁：
//		while(!redisLock.lock("yourlockNo",1000*60, 5000)){
//			EnvUtil.sleep(1);
//		}
//		//释放锁：
//		while(!redisLock.unLock("yourlockNo")){
//			EnvUtil.sleep(1);
//		}
	}

}