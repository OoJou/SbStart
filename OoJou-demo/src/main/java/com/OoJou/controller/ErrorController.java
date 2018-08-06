package com.OoJou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OoJou.pojo.JSONResult;


@Controller
@RequestMapping("err")
public class ErrorController {

	@RequestMapping("/error")
	public String error() {
		
		int a = 1 / 0;
		
		return "thymeleaf/error";
	}
	
	/**
	 * 以下两个方法要使用AjaxExceptionHandler
	 * 当然，在ExceptionHandler里面也已经整合ajax的拦截
	 * @return
	 */
	//这个是间接访问/getAjaxerror的方法，可以看ajaxerror.js，这里在js里设置访问/getAjaxerror
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public JSONResult getAjaxerror() {
		
		int a = 1 / 0;
		
		return JSONResult.ok();
	}
}