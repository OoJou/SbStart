package com.OoJou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.OoJou.mapper.SysUserMapper;
import com.OoJou.mapper.SysUserMapperCustom;
import com.OoJou.pojo.SysUser;
import com.OoJou.service.SysUserService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;

	@Autowired
	SysUserMapperCustom sysUserMapperCustom;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(SysUser user)  {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sysUserMapper.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub
		sysUserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		sysUserMapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserById(String userId) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sysUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserList(SysUser user) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
			// criteria.andEqualTo("username", user.getUsername());
			criteria.andLike("username", "%" + user.getUsername() + "%");
		}

		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}

		List<SysUser> userList = sysUserMapper.selectByExample(example);

		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		// 开始分页
		PageHelper.startPage(page, pageSize);

		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}
		example.orderBy("registTime").desc();
		// 使用了开始分页的方法，查询出来的就已经是分页好的了，返回json可以查看结果
		List<SysUser> userList = sysUserMapper.selectByExample(example);

		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserByIdCustom(String userId) {
		// TODO Auto-generated method stub

		List<SysUser> userList = sysUserMapperCustom.queryUserSimplyInfoById(userId);

		if (userList != null && !userList.isEmpty()) {
			return (SysUser) userList.get(0);
		}

		return null;
	}

	/**
	 * 实现事务回滚@Transactional(propagation = Propagation.REQUIRED)
	 * 回滚：当报错时，错误数据任然会保存进入数据库。设置回滚的方法就会回到错误点，不执行保存操作
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUserTransactional(SysUser user) {
		sysUserMapper.insert(user);
		
		int a = 1 / 0;
		
		user.setIsDelete(1);
		sysUserMapper.updateByPrimaryKeySelective(user);
	}

}
