package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolVolunteerUser extends BasicDto {

	private static final long serialVersionUID = 1;
	
	private VolUser user;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	private String onlySign;
	
	/**
	 * 用户类型ID:1:机构用户,2:志愿者用户,3:志愿团体用户
	 */
	private Integer userTypeId;
	
	/**
	 * 头像
	 */
	private String headPortrait;
	
	/**
	 * 真实姓名
	 */
	private String fullName;
	
	/**
	 * 电子邮箱
	 */
	private String email;
	
	/**
	 * 性别
	 */
	private Integer gender;
	private String sexName;
	
	/**
	 * 出生日期,格式：YYYY年MM月DD日
	 */
	private String birthDate;
	
	/**
	 * 国籍
	 */
	private String nationality;
	
	/**
	 * 籍贯
	 */
	private String birthPlace;
	
	/**
	 * 证件类型
	 */
	private Integer certificatesTypeId;
	
	/**
	 * 证件号码
	 */
	private String certificatesNumber;
	
	/**
	 * 政治面貌
	 */
	private Integer politicsFaceId;
	
	/**
	 * 民族
	 */
	private Integer nation;
	
	/**
	 * 手机
	 */
	private String telphone;
	
	/**
	 * 固定电话
	 */
	private String fixedTelphone;
	
	/**
	 * QQ
	 */
	private String qq;
	
	/**
	 * 微信
	 */
	private String weChat;
	
	/**
	 * 微博
	 */
	private String microblog;
	
	/**
	 * 区域
	 */
	private Integer area_id;
	private String cityName;
	private Integer area_pid;
	

	/**
	 * 详细地址
	 */
	private String addressDetail;
	
	/**
	 * 邮编
	 */
	private String zipCode;
	
	/**
	 * 最高学历,博士研究生、硕士研究生、大学本科、大学专科、中等专科、职业高中、技工学校、高中、初中、小学、其他
	 */
	private Integer highestDegreeId;
	
	/**
	 * 从业状况
	 */
	private Integer employmentStatusId;
	private String employmentName;
	
	/**
	 * 服务类别
	 */
	private Integer serviceTypeId;
	private String serviceTypeName;
	
	/**
	 * 所属场馆ID
	 */
	private Integer organizationId;
	
	private String contactorName;
	
	/**
	 * 主管单位名称
	 */
	private String teamUnitName;
	
	/**
	 * 志愿者人数
	 */
	private Integer teamNumber;
	
	/**
	 * 注册类型 1：普通注册 2、微信账号登录 3、QQ账号登录 4：微博账号登录
	 */
	private Integer registerTypeId;
	
	/**
	 * 注册日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	private Date registerDate;
	
	/**
	 * 更新日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	private Date updateDate;
	
	/**
	 * 服务时长：小时 
	 */
	private Integer serviceTime;
	
	/**
	 * 志愿者星级(按服务时长评级）
	 */
	private Integer starId;
	
	/**
	 * 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	private Integer checkStatus;
	
	/**
	 * 审核时间
	 */
	private Date checkDate;
	
	/**
	 * 审核人
	 */
	private Integer checkId;
	
	/**
	 * 角色
	 */
	private Integer roleId;
	private String roleName;
	
	private Integer messageCount;
	private Integer finishCount;
	private Integer doingCount;
	private String opwd;
	private String npwd;

	public String getOpwd() {
		return opwd;
	}

	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}

	public String getNpwd() {
		return npwd;
	}

	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}

	/**
	 * Empty constructor
	 */
	public VolVolunteerUser() {
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
	 * 获取 头像
	 */
	public String getHeadPortrait() {
		return headPortrait;
	}
	
	/**
	 * 设置 头像
	 */
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	
	/**
	 * 获取 真实姓名
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 设置 真实姓名
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * 获取 电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置 电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取 性别
	 */
	public Integer getGender() {
		return gender;
	}
	
	/**
	 * 设置 性别
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取 出生日期,格式：YYYY年MM月DD日
	 */
	public String getBirthDate() {
		return birthDate;
	}
	
	/**
	 * 设置 出生日期,格式：YYYY年MM月DD日
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * 获取 国籍
	 */
	public String getNationality() {
		return nationality;
	}
	
	/**
	 * 设置 国籍
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * 获取 籍贯
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	
	/**
	 * 设置 籍贯
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	/**
	 * 获取 证件类型
	 */
	public Integer getCertificatesTypeId() {
		return certificatesTypeId;
	}
	
	/**
	 * 设置 证件类型
	 */
	public void setCertificatesTypeId(Integer certificatesTypeId) {
		this.certificatesTypeId = certificatesTypeId;
	}
	
	/**
	 * 获取 证件号码
	 */
	public String getCertificatesNumber() {
		return certificatesNumber;
	}
	
	/**
	 * 设置 证件号码
	 */
	public void setCertificatesNumber(String certificatesNumber) {
		this.certificatesNumber = certificatesNumber;
	}
	
	/**
	 * 获取 政治面貌
	 */
	public Integer getPoliticsFaceId() {
		return politicsFaceId;
	}
	
	/**
	 * 设置 政治面貌
	 */
	public void setPoliticsFaceId(Integer politicsFaceId) {
		this.politicsFaceId = politicsFaceId;
	}
	
	/**
	 * 获取 民族
	 */
	public Integer getNation() {
		return nation;
	}
	
	/**
	 * 设置 民族
	 */
	public void setNation(Integer nation) {
		this.nation = nation;
	}
	
	/**
	 * 获取 手机
	 */
	public String getTelphone() {
		return telphone;
	}
	
	/**
	 * 设置 手机
	 */
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	/**
	 * 获取 固定电话
	 */
	public String getFixedTelphone() {
		return fixedTelphone;
	}
	
	/**
	 * 设置 固定电话
	 */
	public void setFixedTelphone(String fixedTelphone) {
		this.fixedTelphone = fixedTelphone;
	}
	
	/**
	 * 获取 QQ
	 */
	public String getQq() {
		return qq;
	}
	
	/**
	 * 设置 QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	/**
	 * 获取 微信
	 */
	public String getWeChat() {
		return weChat;
	}
	
	/**
	 * 设置 微信
	 */
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	
	/**
	 * 获取 微博
	 */
	public String getMicroblog() {
		return microblog;
	}
	
	/**
	 * 设置 微博
	 */
	public void setMicroblog(String microblog) {
		this.microblog = microblog;
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
	public String getAddressDetail() {
		return addressDetail;
	}
	
	/**
	 * 设置 详细地址
	 */
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	/**
	 * 获取 邮编
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * 设置 邮编
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * 获取 最高学历,博士研究生、硕士研究生、大学本科、大学专科、中等专科、职业高中、技工学校、高中、初中、小学、其他
	 */
	public Integer getHighestDegreeId() {
		return highestDegreeId;
	}
	
	/**
	 * 设置 最高学历,博士研究生、硕士研究生、大学本科、大学专科、中等专科、职业高中、技工学校、高中、初中、小学、其他
	 */
	public void setHighestDegreeId(Integer highestDegreeId) {
		this.highestDegreeId = highestDegreeId;
	}
	
	/**
	 * 获取 从业状况
	 */
	public Integer getEmploymentStatusId() {
		return employmentStatusId;
	}
	
	/**
	 * 设置 从业状况
	 */
	public void setEmploymentStatusId(Integer employmentStatusId) {
		this.employmentStatusId = employmentStatusId;
	}
	
	/**
	 * 获取 服务类别
	 */
	public Integer getServiceTypeId() {
		return serviceTypeId;
	}
	
	/**
	 * 设置 服务类别
	 */
	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
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
	 * 获取 注册类型 1：普通注册 2、微信账号登录 3、QQ账号登录 4：微博账号登录
	 */
	public Integer getRegisterTypeId() {
		return registerTypeId;
	}
	
	/**
	 * 设置 注册类型 1：普通注册 2、微信账号登录 3、QQ账号登录 4：微博账号登录
	 */
	public void setRegisterTypeId(Integer registerTypeId) {
		this.registerTypeId = registerTypeId;
	}
	
	/**
	 * 获取 注册日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getRegisterDate() {
		return registerDate;
	}
	
	/**
	 * 设置 注册日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	/**
	 * 获取 更新日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置 更新日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 获取 服务时长：小时 
	 */
	public Integer getServiceTime() {
		return serviceTime;
	}
	
	/**
	 * 设置 服务时长：小时 
	 */
	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	/**
	 * 获取 志愿者星级(按服务时长评级）
	 */
	public Integer getStarId() {
		return starId;
	}
	
	/**
	 * 设置 志愿者星级(按服务时长评级）
	 */
	public void setStarId(Integer starId) {
		this.starId = starId;
	}
	
	/**
	 * 获取 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	public Integer getCheckStatus() {
		return checkStatus;
	}
	
	/**
	 * 设置 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	public void setCheckStatus(Integer checkStatus) {
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
	
	/**
	 * 获取 角色
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色
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

	public String getEmploymentName() {
		return employmentName;
	}

	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public Integer getFinishCount() {
		return finishCount;
	}

	public void setFinishCount(Integer finishCount) {
		this.finishCount = finishCount;
	}

	public Integer getDoingCount() {
		return doingCount;
	}

	public void setDoingCount(Integer doingCount) {
		this.doingCount = doingCount;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public VolUser getUser() {
		return user;
	}

	public void setUser(VolUser user) {
		this.user = user;
	}

	public String getContactorName() {
		return contactorName;
	}

	public void setContactorName(String contactorName) {
		this.contactorName = contactorName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOnlySign() {
		return onlySign;
	}

	public void setOnlySign(String onlySign) {
		this.onlySign = onlySign;
	}

	public Integer getArea_pid() {
		return area_pid;
	}

	public void setArea_pid(Integer area_pid) {
		this.area_pid = area_pid;
	}

	
	
}
