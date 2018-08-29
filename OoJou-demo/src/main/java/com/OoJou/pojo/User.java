package com.OoJou.pojo;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="com.oojou.user")
@PropertySource(value="classpath:user.properties")
@Data
public class User {

	private String username;
//	在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
	@JsonIgnore
	private String password;
	private int age;
	private Date birthday;
	
}
