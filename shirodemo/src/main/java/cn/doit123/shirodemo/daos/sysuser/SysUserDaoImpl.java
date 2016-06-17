package cn.doit123.shirodemo.daos.sysuser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.doit123.shirodemo.pojo.entity.SysUser;

@Repository("sysUserDao")
public class SysUserDaoImpl implements SysUserDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public SysUser queryByUsername(String username) {
		return jdbcTemplate.queryForObject("select * from sys_user where username=?", 
				new Object[]{username}, new BeanPropertyRowMapper<SysUser>());
		
	}

	@Override
	public List<SysUser> queryAll() {
		return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<SysUser>());
	}

	@Override
	public SysUser queryById(int id) {
		return jdbcTemplate.queryForObject("select * from sys_user where id=?", 
				new Object[]{id}, new BeanPropertyRowMapper<SysUser>());
	}

}
