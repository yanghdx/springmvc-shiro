package cn.doit123.shirodemo.daos.sysres;

import java.util.List;

import cn.doit123.shirodemo.pojo.entity.SysRes;

public interface SysResDao {

	List<String> queryPermissions(int[] roleIds);
	
	
	SysRes queryById(int resId);
	
	List<SysRes> queryByIds(int[] resIds);
}
