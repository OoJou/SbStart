package com.OoJou.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OoJou.pojo.User;


@Controller
@RequestMapping("th")
public class ThymeleafController {

	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.addAttribute("name", "thymeleaf-imooc");
		return "thymeleaf/index";
	}
	
	@RequestMapping("/center")
	public String center() {
		return "thymeleaf/center";
	}
	
	@RequestMapping("test")
    public String test(ModelMap map) {
		
		User u = new User();
		u.setUsername("OoJou");
		u.setAge(10);
		u.setPassword("123465");
		u.setBirthday(new Date());
		
		map.addAttribute("user", u);
		
		User u1 = new User();
		u1.setAge(19);
		u1.setUsername("github");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setUsername("supreme");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(u);
		userList.add(u1);
		userList.add(u2);
		
		map.addAttribute("userList", userList);
		
        return "thymeleaf/test";
    }
	
	@PostMapping("postform")
    public String postform(User u) {
		
		//打印查看
		System.out.println("姓名：" + u.getUsername());
		System.out.println("年龄：" + u.getAge());
		
        return "redirect:/th/test";
    }
	
	@RequestMapping("showerror")
    public String showerror(User u) {
		
		int a = 1 / 0;
		
        return "redirect:/th/test";
    }
}
