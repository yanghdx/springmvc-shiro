package cn.doit123.shirodemo.services.sysrole;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.doit123.shirodemo.daos.sysres.SysResDao;
import cn.doit123.shirodemo.daos.sysrole.SysRoleDao;
import cn.doit123.shirodemo.pojo.entity.SysRes;
import cn.doit123.shirodemo.pojo.entity.SysRole;
import cn.doit123.shirodemo.utils.ArrayHelper;

@Service("sysRoleService")
public  class SysRoleServiceImpl implements SysRoleService {

	@Resource(name = "sysRoleDao")
	private SysRoleDao sysRoleDao;
	
	@Resource(name = "sysResDao")
	private SysResDao sysResDao;
	
	@Override
	public Set<String> findPermissions(int[] roleIds) {
		if (roleIds != null && roleIds.length != 0) {
			List<SysRole> roles = sysRoleDao.queryByIds(roleIds);
			Set<Integer> resIds = new HashSet<Integer>();
			for (SysRole role : roles) {
				String ids = role.getResIds();
				if (StringUtils.isEmpty(ids)) 
					continue;
				int[] idsArr = ArrayHelper.toIntArray(ids, ',');
				for (int id : idsArr) {
					resIds.add(id);
				}
			}
			Integer[] array = new Integer[resIds.size()];
			resIds.toArray(array);
			//query sys_res
			List<SysRes> ress = sysResDao.queryByIds(ArrayUtils.toPrimitive(array));
			Set<String> result = new HashSet<String>(roles.size());
			for (SysRes res : ress) {
				result.add(res.getPermission());
			}
			return result;
		} else {
			return Collections.<String>emptySet();
		}
		
	}

	@Override
	public Set<String> findRoles(int[] roleIds) {
		if (roleIds != null && roleIds.length != 0) {
			List<SysRole> roles = sysRoleDao.queryByIds(roleIds);
			
			Set<String> result = new HashSet<String>(roles.size());
			for (SysRole role : roles) {
				result.add(role.getRole());
			}
			return result;
		} else {
			return Collections.<String>emptySet();
		}
	}

}
