package cn.doit123.shirodemo.services.sysuser;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.doit123.shirodemo.daos.sysres.SysResDao;
import cn.doit123.shirodemo.daos.sysrole.SysRoleDao;
import cn.doit123.shirodemo.daos.sysuser.SysUserDao;
import cn.doit123.shirodemo.pojo.entity.SysRes;
import cn.doit123.shirodemo.pojo.entity.SysRole;
import cn.doit123.shirodemo.pojo.entity.SysUser;
import cn.doit123.shirodemo.utils.ArrayHelper;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Resource(name = "sysUserDao")
	private SysUserDao sysUserDao;
	
	@Resource(name = "sysRoleDao")
	private SysRoleDao sysRoleDao;
	
	@Resource(name = "sysResDao")
	private SysResDao sysResDao;
	
	@Override
	@Transactional
	public void changePassword(int userId, String newPassword) {
		// TODO 
		
	}

	@Override
	public SysUser findByUsername(String username) {
		return sysUserDao.queryByUsername(username);
	}

	@Override
	public Set<String> findRoles(int userId) {
		SysUser user = sysUserDao.queryById(userId);
		if (user != null && !StringUtils.isBlank(user.getRoleIds())) {
			List<SysRole> roles = sysRoleDao.queryByIds(ArrayHelper.toIntArray(user.getRoleIds(), ','));
			Set<String> result = new HashSet<String>(roles.size());
			for (SysRole role : roles) {
				result.add(role.getRole());
			}
			return result;
		} else {
			return Collections.<String>emptySet();
		}
	}

	@Override
	public Set<String> findPermissions(int userId) {
		SysUser user = sysUserDao.queryById(userId);
		if (user != null && !StringUtils.isBlank(user.getRoleIds())) {
			//query sys_role
			List<SysRole> roles = sysRoleDao.queryByIds(ArrayHelper.toIntArray(user.getRoleIds(), ','));
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

}
