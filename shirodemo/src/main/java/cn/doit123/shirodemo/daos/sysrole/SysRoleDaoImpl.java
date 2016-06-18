package cn.doit123.shirodemo.daos.sysrole;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.doit123.shirodemo.pojo.entity.SysRole;
import cn.doit123.shirodemo.utils.ArrayHelper;

@Repository("sysRoleDao")
public class SysRoleDaoImpl implements SysRoleDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public SysRole queryById(int roleId) {
		RowMapper<SysRole> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysRole.class);
		
		List<SysRole> roles = jdbcTemplate.query("select * from sys_role where id=" + roleId, 
				mapper);
		return CollectionUtils.isEmpty(roles) ? null : roles.get(0);
	}

	@Override
	public List<SysRole> queryByIds(int[] roleIds) {
		if (!ArrayUtils.isEmpty(roleIds)) {
			RowMapper<SysRole> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysRole.class);
			
			String ids = ArrayHelper.join(ArrayUtils.toObject(roleIds), ',');
			return jdbcTemplate.query("select * from sys_role where id in (" + ids + ")",  mapper);
		} else {
			return Collections.<SysRole>emptyList();
		}
	}

}
