package com.OoJou.service;

import java.util.List;

import com.OoJou.pojo.SysUser;

public interface SysUserService {
	public void saveUser(SysUser user);

	public void updateUser(SysUser user);

	public void deleteUser(String userId);

	public SysUser queryUserById(String userId);

	public List<SysUser> queryUserList(SysUser user);

	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

	public SysUser queryUserByIdCustom(String userId);

	public void saveUserTransactional(SysUser user);
}
