package cn.doit123.shirodemo.pojo.entity;

import java.io.Serializable;

public class SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -692207958874191305L;
	
	private int id;
	
	private String role;
	
	private String description;
	
	private String resIds;
	
	private boolean avaliable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResIds() {
		return resIds;
	}

	public void setResIds(String resIds) {
		this.resIds = resIds;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	
	

}
