package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolProjectSignup extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 项目ID
	 */
	private Integer projectId;
	private String projectName;
	
	/**
	 * 志愿者ID
	 */
	private Integer volunteerId;
	private String userName;
	private String headPortrait;
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 报名日期
	 */
	private Date signUpDate;
	
	/**
	 * 报名类型：1：自主报名，2：配送报名
	 */
	private Integer signUpType;
	private String typeName;
	
	/**
	 * 录用状态：0：处理中，1：已录用，2：未录用
	 */
	private Integer signUpStutas;
	private String statusName;
	
	/**
	 * 拒绝理由：（名额已满、条件不符合）
	 */
	private String refuseReason;
	
	/**
	 * 实际所得积分
	 */
	private Integer getScore;
	
	private String starName;
	private String time;
	private Integer signId;
	
	public Integer getSignId() {
		return signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Empty constructor
	 */
	public VolProjectSignup() {
		super();
	}
	
	/**
	 * 获取 项目ID
	 */
	public Integer getProjectId() {
		return projectId;
	}
	
	/**
	 * 设置 项目ID
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	/**
	 * 获取 志愿者ID
	 */
	public Integer getVolunteerId() {
		return volunteerId;
	}
	
	/**
	 * 设置 志愿者ID
	 */
	public void setVolunteerId(Integer volunteerId) {
		this.volunteerId = volunteerId;
	}
	
	/**
	 * 获取 报名日期
	 */
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getSignUpDate() {
		return signUpDate;
	}
	
	/**
	 * 设置 报名日期
	 */
	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
	
	/**
	 * 获取 报名类型：1：自主报名，2：配送报名
	 */
	public Integer getSignUpType() {
		return signUpType;
	}
	
	/**
	 * 设置 报名类型：1：自主报名，2：配送报名
	 */
	public void setSignUpType(Integer signUpType) {
		this.signUpType = signUpType;
	}
	
	/**
	 * 获取 录用状态：0：处理中，1：已录用，2：未录用
	 */
	public Integer getSignUpStutas() {
		return signUpStutas;
	}
	
	/**
	 * 设置 录用状态：0：处理中，1：已录用，2：未录用
	 */
	public void setSignUpStutas(Integer signUpStutas) {
		this.signUpStutas = signUpStutas;
	}
	
	/**
	 * 获取 拒绝理由：（名额已满、条件不符合）
	 */
	public String getRefuseReason() {
		return refuseReason;
	}
	
	/**
	 * 设置 拒绝理由：（名额已满、条件不符合）
	 */
	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}
	
	/**
	 * 获取 实际所得积分
	 */
	public Integer getGetScore() {
		return getScore;
	}
	
	/**
	 * 设置 实际所得积分
	 */
	public void setGetScore(Integer getScore) {
		this.getScore = getScore;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStarName() {
		return starName;
	}

	public void setStarName(String starName) {
		this.starName = starName;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	
}
