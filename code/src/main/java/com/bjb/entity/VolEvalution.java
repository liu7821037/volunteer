package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolEvalution extends BasicDto {

	private static final long serialVersionUID = 1;
	
	
	/**
	 * 活动名称（项目名称）
	 * 参与者姓名（志愿者名称）
	 * 评价等级（）
	 * 场馆名称
	 * 评价者姓名
	 * 获得积分
	 */
	private String projectName;
	private String volunteerName;
	private String starName;
	private String organizationName;
	private String evalutionName;
	private int getScore;
	

	public int getGetScore() {
		return getScore;
	}

	public void setGetScore(int getScore) {
		this.getScore = getScore;
	}

	public String getEvalutionName() {
		return evalutionName;
	}

	public void setEvalutionName(String evalutionName) {
		this.evalutionName = evalutionName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getVolunteerName() {
		return volunteerName;
	}

	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}

	public String getStarName() {
		return starName;
	}

	public void setStarName(String starName) {
		this.starName = starName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * 项目ID
	 */
	private Integer projectId;
	
	/**
	 * 志愿者ID
	 */
	private Integer volunteerId;
	
	/**
	 * 星级评价ID
	 */
	private Integer starId;
	
	/**
	 * 评价人（机构用户ID)
	 */
	private Integer evalutionAuditor;
	
	/**
	 * 场馆ID
	 */
	private Integer organizationId;
	
	/**
	 * 评价日期
	 */
	private Date evalutionDate;
	
	/**
	 * Empty constructor
	 */
	public VolEvalution() {
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
	 * 获取 星级评价ID
	 */
	public Integer getStarId() {
		return starId;
	}
	
	/**
	 * 设置 星级评价ID
	 */
	public void setStarId(Integer starId) {
		this.starId = starId;
	}
	
	/**
	 * 获取 评价人（机构用户ID)
	 */
	public Integer getEvalutionAuditor() {
		return evalutionAuditor;
	}
	
	/**
	 * 设置 评价人（机构用户ID)
	 */
	public void setEvalutionAuditor(Integer evalutionAuditor) {
		this.evalutionAuditor = evalutionAuditor;
	}
	
	/**
	 * 获取 场馆ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	
	/**
	 * 设置 场馆ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	/**
	 * 获取 评价日期
	 */
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getEvalutionDate() {
		return evalutionDate;
	}
	
	/**
	 * 设置 评价日期
	 */
	public void setEvalutionDate(Date evalutionDate) {
		this.evalutionDate = evalutionDate;
	}
}
