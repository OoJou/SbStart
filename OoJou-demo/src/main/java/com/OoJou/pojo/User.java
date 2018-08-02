package com.OoJou.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class User {

	private String username;
	@JsonIgnore
	private String passwork;
	private int age;
	
}
