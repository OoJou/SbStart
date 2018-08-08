package com.OoJou.jedis;

import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo1 {

	@Test
	/**
	 * 普通的jedis连接
	 *
	 */
	public void demo1() {
		// 设置ip，端口号
		Jedis jedis = new Jedis("192.168.43.131", 6379);
		// 保存数据
		jedis.set("name", "test");
		// 获取数据
		String value = jedis.get("name");
		System.out.println("value=" + value);
		// 释放资源
		jedis.close();
	}

	@Test
	/**
	 * 使用连接池
	 */
	public void demo2() {
		// 获取连接池配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置最大连接数
		config.setMaxTotal(30);
		// 设置最大空闲连接数
		config.setMaxIdle(10);

		// 获得连接池
		JedisPool jedisPool = new JedisPool(config, "192.168.43.131", 6379);
		// 获得核心对象
		Jedis jedis = null;
		try {
			//通过连接池获得对象
			jedis = jedisPool.getResource();
			// 保存数据
			jedis.set("name1", "poollink");
			// 获取数据
			String value = jedis.get("name1");
			System.out.println("value=" + value);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(jedis!=null) {
				jedis.close();
			}
			if(jedisPool!=null) {
				jedisPool.close();
			}
		}
	}
}
