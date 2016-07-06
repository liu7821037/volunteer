package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolTeamUser extends BasicDto {

	private static final long serialVersionUID = 1;
	

	/**
	 * 登录表用户ID
	 */
	private Integer userId;
	
	/**
	 * 用户统一标识
	 */
	private String onlySign;
	
	/**
	 * 负责人电子邮箱
	 */
	private String captainEmail;
	
	/**
	 * 志愿团体名称
	 */
	private String teamName;
	
	/**
	 * 团体类型
	 */
	private Integer teamType;
	private String teamTypeName;
	
	/**
	 * 主管单位名称
	 */
	private String teamUnitName;
	
	/**
	 * 区域
	 */
	private Integer area_id;
	
	/**
	 * 详细地址
	 */
	private String teamAddress;
	
	/**
	 * 邮编
	 */
	private String teamZipCode;
	
	/**
	 * 成立日期(团队成立，但不是志愿者类型)
	 */
	private Date createDate;
	
	/**
	 * 志愿者人数
	 */
	private Integer teamNumber;
	
	/**
	 * 服务类型
	 */
	private Integer serviceTypeId;
	private String serviceTypeName;
	
	/**
	 * 联系人姓名
	 */
	private String contactorName;
	
	/**
	 * 联系人手机
	 */
	private String captainTel;
	
	/**
	 * 联系人电话
	 */
	private String contactorMobile;
	
	/**
	 * 联系人QQ
	 */
	private String contactorQQ;
	
	/**
	 * 注册类型 1：普通注册 2、微信账号登录 3、QQ账号登录 4：微博账号登录
	 */
	private Integer registType;
	
	/**
	 * 注册时间（注册志愿者时间）
	 */
	private Date registDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	
	/**
	 * 服务次数
	 */
	private Integer serviceTime;
	
	/**
	 * 团队星级(按照团队服务的次数计算)
	 */
	private Integer starId;
	
	/**
	 * 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	private String checkStatus;
	
	/**
	 * 审核时间
	 */
	private Date checkDate;
	
	/**
	 * 审核人
	 */
	private Integer checkId;
	
	/**
	 * Empty constructor
	 */
	public VolTeamUser() {
		super();
	}
	
	/**
	 * 获取 登录表用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * 设置 登录表用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	 * 获取 负责人电子邮箱
	 */
	public String getCaptainEmail() {
		return captainEmail;
	}
	
	/**
	 * 设置 负责人电子邮箱
	 */
	public void setCaptainEmail(String captainEmail) {
		this.captainEmail = captainEmail;
	}
	
	/**
	 * 获取 志愿团体名称
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/**
	 * 设置 志愿团体名称
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/**
	 * 获取 团体类型
	 */
	public Integer getTeamType() {
		return teamType;
	}
	
	/**
	 * 设置 团体类型
	 */
	public void setTeamType(Integer teamType) {
		this.teamType = teamType;
	}
	
	/**
	 * 获取 主管单位名称
	 */
	public String getTeamUnitName() {
		return teamUnitName;
	}
	
	/**
	 * 设置 主管单位名称
	 */
	public void setTeamUnitName(String teamUnitName) {
		this.teamUnitName = teamUnitName;
	}
	
	/**
	 * 获取 区域
	 */
	public Integer getAreaId() {
		return area_id;
	}
	
	/**
	 * 设置 区域
	 */
	public void setAreaId(Integer area_id) {
		this.area_id = area_id;
	}
	
	/**
	 * 获取 详细地址
	 */
	public String getTeamAddress() {
		return teamAddress;
	}
	
	/**
	 * 设置 详细地址
	 */
	public void setTeamAddress(String teamAddress) {
		this.teamAddress = teamAddress;
	}
	
	/**
	 * 获取 邮编
	 */
	public String getTeamZipCode() {
		return teamZipCode;
	}
	
	/**
	 * 设置 邮编
	 */
	public void setTeamZipCode(String teamZipCode) {
		this.teamZipCode = teamZipCode;
	}
	
	/**
	 * 获取 成立日期(团队成立，但不是志愿者类型)
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置 成立日期(团队成立，但不是志愿者类型)
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 获取 志愿者人数
	 */
	public Integer getTeamNumber() {
		return teamNumber;
	}
	
	/**
	 * 设置 志愿者人数
	 */
	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}
	
	/**
	 * 获取 服务类型
	 */
	public Integer getServiceTypeId() {
		return serviceTypeId;
	}
	
	/**
	 * 设置 服务类型
	 */
	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	
	/**
	 * 获取 联系人姓名
	 */
	public String getContactorName() {
		return contactorName;
	}
	
	/**
	 * 设置 联系人姓名
	 */
	public void setContactorName(String contactorName) {
		this.contactorName = contactorName;
	}
	
	/**
	 * 获取 联系人手机
	 */
	public String getCaptainTel() {
		return captainTel;
	}
	
	/**
	 * 设置 联系人手机
	 */
	public void setCaptainTel(String captainTel) {
		this.captainTel = captainTel;
	}
	
	/**
	 * 获取 联系人电话
	 */
	public String getContactorMobile() {
		return contactorMobile;
	}
	
	/**
	 * 设置 联系人电话
	 */
	public void setContactorMobile(String contactorMobile) {
		this.contactorMobile = contactorMobile;
	}
	
	/**
	 * 获取 联系人QQ
	 */
	public String getContactorQQ() {
		return contactorQQ;
	}
	
	/**
	 * 设置 联系人QQ
	 */
	public void setContactorQQ(String contactorQQ) {
		this.contactorQQ = contactorQQ;
	}
	
	/**
	 * 获取 注册类型 1：普通注册 2、微信账号登录 3、QQ账号登录 4：微博账号登录
	 */
	public Integer getRegistType() {
		return registType;
	}
	
	/**
	 * 设置 注册类型 1：普通注册 2、微信账号登录 3、QQ账号登录 4：微博账号登录
	 */
	public void setRegistType(Integer registType) {
		this.registType = registType;
	}
	
	/**
	 * 获取 注册时间（注册志愿者时间）
	 */
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getRegistDate() {
		return registDate;
	}
	
	/**
	 * 设置 注册时间（注册志愿者时间）
	 */
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	/**
	 * 获取 更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置 更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 获取 服务次数
	 */
	public Integer getServiceTime() {
		return serviceTime;
	}
	
	/**
	 * 设置 服务次数
	 */
	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	/**
	 * 获取 团队星级(按照团队服务的次数计算)
	 */
	public Integer getStarId() {
		return starId;
	}
	
	/**
	 * 设置 团队星级(按照团队服务的次数计算)
	 */
	public void setStarId(Integer starId) {
		this.starId = starId;
	}
	
	/**
	 * 获取 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	public String getCheckStatus() {
		return checkStatus;
	}
	
	/**
	 * 设置 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	/**
	 * 获取 审核时间
	 */
	public Date getCheckDate() {
		return checkDate;
	}
	
	/**
	 * 设置 审核时间
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	/**
	 * 获取 审核人
	 */
	public Integer getCheckId() {
		return checkId;
	}
	
	/**
	 * 设置 审核人
	 */
	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public String getTeamTypeName() {
		return teamTypeName;
	}

	public void setTeamTypeName(String teamTypeName) {
		this.teamTypeName = teamTypeName;
	}

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}
	
}