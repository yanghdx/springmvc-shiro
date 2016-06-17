package cn.doit123.shirodemo.pojo.entity;

import java.io.Serializable;

public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133360434173266849L;
	
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String salt;
	
	private String roleIds;
	
	private boolean locked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	

}
