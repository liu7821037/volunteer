package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolOrganizationUser extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	private String userCode;
	/**
	 * 用户头像
	 */
	private String organizationUserPortrait;
	
	/**
	 * 用户统一标识
	 */
	private String onlySign;
	
	/**
	 * 性别 0：保密 1：男 2：女
	 */
	private Integer organizationUserGender;
	private String sexName;
	
	/**
	 * 联系电话
	 */
	private String organizationUserPhone;
	
	/**
	 * 邮箱地址
	 */
	private String organizationUserEmail;
	
	/**
	 * 区域
	 */
	private String organizationArea;
	
	/**
	 * 所属场馆ID
	 */
	private Integer organizationId;
	private String organizationName;
	
	/**
	 * 注册时间，格式：YYYY-MM-DD HH:MM:SS
	 */
	private Date registerDate;
	
	/**
	 * 更新时间，格式：YYYY-MM-DD HH:MM:SS
	 */
	private Date updateDate;
	
	/**
	 * 角色：1：机构管理员、2：机构用户
	 */
	private Integer roleId;
	private String roleName;
	
	private Integer userStatus;
	/**
	 * Empty constructor
	 */
	public VolOrganizationUser() {
		super();
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
	 * 获取 用户头像
	 */
	public String getOrganizationUserPortrait() {
		return organizationUserPortrait;
	}
	
	/**
	 * 设置 用户头像
	 */
	public void setOrganizationUserPortrait(String organizationUserPortrait) {
		this.organizationUserPortrait = organizationUserPortrait;
	}
	
	/**
	 * 获取 用户统一标识
	 */
	public String getOnlySign() {
		return onlySign;
	}
	
	/**
	 * 设置 用户统一标识
	 */
	public void setOnlySign(String onlySign) {
		this.onlySign = onlySign;
	}
	
	/**
	 * 获取 性别 0：保密 1：男 2：女
	 */
	public Integer getOrganizationUserGender() {
		return organizationUserGender;
	}
	
	/**
	 * 设置 性别 0：保密 1：男 2：女
	 */
	public void setOrganizationUserGender(Integer organizationUserGender) {
		this.organizationUserGender = organizationUserGender;
	}
	
	/**
	 * 获取 联系电话
	 */
	public String getOrganizationUserPhone() {
		return organizationUserPhone;
	}
	
	/**
	 * 设置 联系电话
	 */
	public void setOrganizationUserPhone(String organizationUserPhone) {
		this.organizationUserPhone = organizationUserPhone;
	}
	
	/**
	 * 获取 邮箱地址
	 */
	public String getOrganizationUserEmail() {
		return organizationUserEmail;
	}
	
	/**
	 * 设置 邮箱地址
	 */
	public void setOrganizationUserEmail(String organizationUserEmail) {
		this.organizationUserEmail = organizationUserEmail;
	}
	
	/**
	 * 获取 区域
	 */
	public String getOrganizationArea() {
		return organizationArea;
	}
	
	/**
	 * 设置 区域
	 */
	public void setOrganizationArea(String organizationArea) {
		this.organizationArea = organizationArea;
	}
	
	/**
	 * 获取 所属场馆ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	
	/**
	 * 设置 所属场馆ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	/**
	 * 获取 注册时间，格式：YYYY-MM-DD HH:MM:SS
	 */
	public Date getRegisterDate() {
		return registerDate;
	}
	
	/**
	 * 设置 注册时间，格式：YYYY-MM-DD HH:MM:SS
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	/**
	 * 获取 更新时间，格式：YYYY-MM-DD HH:MM:SS
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置 更新时间，格式：YYYY-MM-DD HH:MM:SS
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 获取 角色：1：机构管理员、2：机构用户
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色：1：机构管理员、2：机构用户
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
}
