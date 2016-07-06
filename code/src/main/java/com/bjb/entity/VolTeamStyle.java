package com.bjb.entity;

import java.util.Date;

public class VolTeamStyle extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 标题
	 */
	private String styleTitle;
	
	/**
	 * 所属团队
	 */
	private Integer styleTeam;
	private String team;
	
	/**
	 * 创建人
	 */
	private String createPeople;
	
	/**
	 * 电话
	 */
	private String teamPhone;
	
	/**
	 * 服务地区
	 */
	private Integer teamArea;
	private String area;
	
	/**
	 * 服务类型
	 */
	private Integer serciveType;
	private String typeName;
	
	/**
	 * 图片
	 */
	private String picture;
	
	/**
	 * 风采简介
	 */
	private String content;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 修改时间
	 */
	private Date updateDate;
	
	/**
	 * Empty constructor
	 */
	public VolTeamStyle() {
		super();
	}
	
	/**
	 * 获取 标题
	 */
	public String getStyleTitle() {
		return styleTitle;
	}
	
	/**
	 * 设置 标题
	 */
	public void setStyleTitle(String styleTitle) {
		this.styleTitle = styleTitle;
	}
	
	/**
	 * 获取 所属团队
	 */
	public Integer getStyleTeam() {
		return styleTeam;
	}
	
	/**
	 * 设置 所属团队
	 */
	public void setStyleTeam(Integer styleTeam) {
		this.styleTeam = styleTeam;
	}
	
	/**
	 * 获取 创建人
	 */
	public String getCreatePeople() {
		return createPeople;
	}
	
	/**
	 * 设置 创建人
	 */
	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}
	
	/**
	 * 获取 电话
	 */
	public String getTeamPhone() {
		return teamPhone;
	}
	
	/**
	 * 设置 电话
	 */
	public void setTeamPhone(String teamPhone) {
		this.teamPhone = teamPhone;
	}
	
	/**
	 * 获取 服务地区
	 */
	public Integer getTeamArea() {
		return teamArea;
	}
	
	/**
	 * 设置 服务地区
	 */
	public void setTeamArea(Integer teamArea) {
		this.teamArea = teamArea;
	}
	
	/**
	 * 获取 服务类型
	 */
	public Integer getSerciveType() {
		return serciveType;
	}
	
	/**
	 * 设置 服务类型
	 */
	public void setSerciveType(Integer serciveType) {
		this.serciveType = serciveType;
	}
	
	/**
	 * 获取 图片
	 */
	public String getPicture() {
		return picture;
	}
	
	/**
	 * 设置 图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取 风采简介
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 风采简介
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 获取 修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置 修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
}
