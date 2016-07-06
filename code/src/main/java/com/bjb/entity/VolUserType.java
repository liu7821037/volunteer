package com.bjb.entity;

public class VolUserType extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * userTypeName
	 */
	private String userTypeName;
	
	/**
	 * Empty constructor
	 */
	public VolUserType() {
		super();
	}
	
	/**
	 * 获取 userTypeName
	 */
	public String getUserTypeName() {
		return userTypeName;
	}
	
	/**
	 * 设置 userTypeName
	 */
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
}
