package cn.doit123.shirodemo.daos.sysrole;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.doit123.shirodemo.pojo.entity.SysRole;
import cn.doit123.shirodemo.utils.ArrayHelper;

@Repository("sysRoleDao")
public class SysRoleDaoImpl implements SysRoleDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public SysRole queryById(int roleId) {
		return jdbcTemplate.queryForObject("select * from sys_role where id=" + roleId, 
				SysRole.class);
	}

	@Override
	public List<SysRole> queryByIds(int[] roleIds) {
		if (!ArrayUtils.isEmpty(roleIds)) {
			String ids = ArrayHelper.join(ArrayUtils.toObject(roleIds), ',');
			return jdbcTemplate.queryForList("select * from sys_role where id in (" + ids + ")", 
					SysRole.class);
		} else {
			return Collections.<SysRole>emptyList();
		}
	}

}
