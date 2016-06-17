package cn.doit123.shirodemo.services.sysuser;

import java.util.Set;

import cn.doit123.shirodemo.pojo.entity.SysUser;

public interface SysUserService {

	void changePassword(int userId, String newPassword);
	
	SysUser findByUsername(String username);
	
	Set<String> findRoles(int userId);
	
	Set<String> findPermissions(int userId);
}
