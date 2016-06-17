package cn.doit123.shirodemo.daos.sysrole;

import java.util.List;

import cn.doit123.shirodemo.pojo.entity.SysRole;

public interface SysRoleDao {

	
	SysRole queryById(int roleId);
	
	List<SysRole> queryByIds(int[] roleIds);
}
