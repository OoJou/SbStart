package com.OoJou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OoJou.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/getuser")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setUsername("李四11111");
		user.setPasswork("0000");
		user.setAge(18);
		return user;
	}
}
