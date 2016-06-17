package cn.doit123.shirodemo.daos.sysuser;

import java.util.List;

import cn.doit123.shirodemo.pojo.entity.SysUser;

public interface SysUserDao {

	
	SysUser queryById(int id);
	
	SysUser queryByUsername(String username);
	
	List<SysUser> queryAll();
	
	
}
