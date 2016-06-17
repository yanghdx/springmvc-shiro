package cn.doit123.shirodemo.pojo.entity;

import java.io.Serializable;

public class SysOrg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6773489362763351134L;
	
	
	private int id;
	
	private String name;
	
	private int priority;
	
	private int parentId;
	
	private String parentIds;
	
	private boolean avaliable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	
	

}
