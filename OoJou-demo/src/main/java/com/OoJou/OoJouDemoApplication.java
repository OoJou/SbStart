package com.OoJou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

//想要成功使用自动注入等注解要扫描对应工具
@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.OoJou.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.OoJou", "org.n3r.idworker"})
//开启定时任务
//@EnableScheduling
//开启异步调用方法
//@EnableAsync
public class OoJouDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OoJouDemoApplication.class, args);
	}
}
