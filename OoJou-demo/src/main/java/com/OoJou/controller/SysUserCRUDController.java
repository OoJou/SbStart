package com.OoJou.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OoJou.pojo.IMoocJSONResult;
import com.OoJou.pojo.SysUser;
import com.OoJou.service.SysUserService;

@RestController
@RequestMapping("/mybatis")
public class SysUserCRUDController {

	@Autowired
	SysUserService sysUserService;
	
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public IMoocJSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("OoJou" + new Date());
		user.setNickname("OoJou" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		sysUserService.saveUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public IMoocJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		sysUserService.updateUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public IMoocJSONResult deleteUser(String userId) {
		
		sysUserService.deleteUser(userId);
		
		return IMoocJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public IMoocJSONResult queryUserById(String userId) {
		
		return IMoocJSONResult.ok(sysUserService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public IMoocJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("OoJou");
		user.setNickname("jj");
		
		List<SysUser> userList = sysUserService.queryUserList(user);
		
		return IMoocJSONResult.ok(userList);
	}
	
}
