package cn.doit123.shirodemo.daos.sysres;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.doit123.shirodemo.pojo.entity.SysRes;
import cn.doit123.shirodemo.utils.ArrayHelper;

@Repository("sysResDao")
public class SysResDaoImpl implements SysResDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> queryPermissions(int[] resIds) {
		if (resIds != null && resIds.length > 0) {
			StringBuilder sql0 = new StringBuilder("select permission from sys_res r "
					+ " where r.id in ( ");
			for (int roleId : resIds) {
				sql0.append(roleId).append(",");
			}
			sql0.deleteCharAt(sql0.length() - 1).append(") ");
			return jdbcTemplate.queryForList(sql0.toString(), String.class);
		} else {
			return Collections.<String>emptyList();
		}
	}

	@Override
	public SysRes queryById(int roleId) {
		RowMapper<SysRes> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysRes.class);
		
		List<SysRes> ress = jdbcTemplate.query("select * from sys_res where id=" + roleId, 
				mapper);
		return CollectionUtils.isEmpty(ress) ? null : ress.get(0);
	}

	@Override
	public List<SysRes> queryByIds(int[] roleIds) {
		if (!ArrayUtils.isEmpty(roleIds)) {
			String ids = ArrayHelper.join(ArrayUtils.toObject(roleIds), ',');
			RowMapper<SysRes> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysRes.class);
			return jdbcTemplate.query("select * from sys_res where id in (" + ids + ")", 
					mapper);
		} else {
			return Collections.<SysRes>emptyList();
		}
	}

}
