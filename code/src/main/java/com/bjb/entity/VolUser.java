package com.bjb.entity;

public class VolUser extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 用户Code
	 */
	private String userCode;
	
	/**
	 * 用户密码
	 */
	private String userPwd;
	
	/**
	 * 手机号码
	 */
	private String userPhone;
	
	/**
	 * 用户类型ID:1:机构用户,2:志愿者用户,3:志愿团体用户
	 */
	private Integer userTypeId;
	
	/**
	 * 用户状态
	 */
	private Integer userStatus;
	
	/**
	 * Empty constructor
	 */
	public VolUser() {
		super();
	}
	
	/**
	 * 获取 用户Code
	 */
	public String getUserCode() {
		return userCode;
	}
	
	/**
	 * 设置 用户Code
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	/**
	 * 获取 用户密码
	 */
	public String getUserPwd() {
		return userPwd;
	}
	
	/**
	 * 设置 用户密码
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	/**
	 * 获取 手机号码
	 */
	public String getUserPhone() {
		return userPhone;
	}
	
	/**
	 * 设置 手机号码
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	/**
	 * 获取 用户类型ID:1:机构用户,2:志愿者用户,3:志愿团体用户
	 */
	public Integer getUserTypeId() {
		return userTypeId;
	}
	
	/**
	 * 设置 用户类型ID:1:机构用户,2:志愿者用户,3:志愿团体用户
	 */
	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	/**
	 * 获取 用户状态
	 */
	public Integer getUserStatus() {
		return userStatus;
	}
	
	/**
	 * 设置 用户状态
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
}
