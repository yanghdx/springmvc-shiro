package cn.doit123.shirodemo.services.sysrole;

import java.util.Set;

public interface SysRoleService {

	Set<String> findPermissions(int[] roleIds);
	
	Set<String> findRoles(int[] roleIds);
}
