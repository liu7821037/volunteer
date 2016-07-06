package com.bjb.entity;

public class VolOrganizationUserRelation extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 场馆id
	 */
	private Integer organizationId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	private String userName;
	/**
	 * 类型：1：志愿者，2：机构用户
	 */
	private Integer userType;
	private String userTypeName;
	
	/**
	 * Empty constructor
	 */
	public VolOrganizationUserRelation() {
		super();
	}
	
	/**
	 * 获取 场馆id
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	
	/**
	 * 设置 场馆id
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	/**
	 * 获取 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取 类型：1：志愿者，2：机构用户
	 */
	public Integer getUserType() {
		return userType;
	}
	
	/**
	 * 设置 类型：1：志愿者，2：机构用户
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
}
