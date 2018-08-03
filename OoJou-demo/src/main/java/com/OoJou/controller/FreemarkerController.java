package com.OoJou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OoJou.pojo.User;

@Controller
@RequestMapping("ftl")
public class FreemarkerController {
	
	@Autowired
	private User user;
	
	//加'/'和不加'/'，没有区别。。
	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.addAttribute("resource", user);
		return "freemarker/index";
	}
	
	@RequestMapping("center")
	public String center() {
		return "freemarker/center";
	}
}
