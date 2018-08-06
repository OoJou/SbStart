package com.OoJou.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OoJou.pojo.JSONResult;
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
	public JSONResult saveUser()  {
		//使用idworker生成随机id
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("OoJou" + new Date());
		user.setNickname("OoJou" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		sysUserService.saveUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public JSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		sysUserService.updateUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public JSONResult deleteUser(String userId) {
		
		sysUserService.deleteUser(userId);
		
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public JSONResult queryUserById(String userId) {
		
		return JSONResult.ok(sysUserService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public JSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("OoJou");
		user.setNickname("jj");
		
		List<SysUser> userList = sysUserService.queryUserList(user);
		
		return JSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public JSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 5;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
	
		List<SysUser> userList = sysUserService.queryUserListPaged(user, page, pageSize);
		
		return JSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	/**
	 * 使用自定义的查询mapper
	 * 
	 * localhost:8080/mybatis/queryUserByIdCustom?userId=1001
	 * 事实证明参数userIde不加@RequestParam,也能访问
	 * 或者使用这个访问：@RequestMapping("/toUpdate/{auctionid}")，参数@PathVariable int auctionid
	 * 
	 * @param userId
	 * @return
	 */
	public JSONResult queryUserByIdCustom(String userId) {
		
		return JSONResult.ok(sysUserService.queryUserByIdCustom(userId));
	}
	
}
