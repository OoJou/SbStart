package com.OoJou.mapper;

import java.util.List;

import com.OoJou.pojo.SysUser;

/**
 * 自定义的查询mapper
 * 需要新建对应的mapperCustom.xml
 * 一般命名自定义的后缀加Custom，另方法名对应xml的id
 * @author www34
 *
 */

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}