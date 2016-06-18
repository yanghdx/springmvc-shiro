package cn.doit123.shirodemo.daos.sysuser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import cn.doit123.shirodemo.pojo.entity.SysUser;

@Repository("sysUserDao")
public class SysUserDaoImpl implements SysUserDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public SysUser queryByUsername(String username) {
		RowMapper<SysUser> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysUser.class);
		List<SysUser> users = jdbcTemplate.query("select * from sys_user where username=?", 
				new Object[]{username}, mapper);
		return CollectionUtils.isEmpty(users) ? null : users.get(0);
		
	}

	@Override
	public List<SysUser> queryAll() {
		RowMapper<SysUser> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysUser.class);
		return jdbcTemplate.query("select * from sys_user", mapper);
	}

	@Override
	public SysUser queryById(int id) {
		RowMapper<SysUser> mapper = ParameterizedBeanPropertyRowMapper.newInstance(SysUser.class);
		List<SysUser> users = jdbcTemplate.query("select * from sys_user where id=?", 
				new Object[]{id}, mapper);
		return CollectionUtils.isEmpty(users) ? null : users.get(0);
	}

}
