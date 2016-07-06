package com.bjb.entity;

public class VolRoleUser extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 用户统一标识
	 */
	private String user_id;
	private int role_id;
	
	/**
	 * Empty constructor
	 */
	public VolRoleUser() {
		super();
	}
	
	/**
	 * 获取 用户统一标识
	 */
	public String getUserId() {
		return user_id;
	}
	
	/**
	 * 设置 用户统一标识
	 */
	public void setUserId(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
