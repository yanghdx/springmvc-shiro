package cn.doit123.shirodemo.services.sysres;

import java.util.Set;

public interface SysResService {

	Set<String> findPermissions(int[] resIds);
	
	
}
