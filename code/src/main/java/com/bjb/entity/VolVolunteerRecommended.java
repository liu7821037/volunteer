package com.bjb.entity;

import java.util.Date;

public class VolVolunteerRecommended extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 志愿者ID
	 */
	private Integer volunteerId;
	
	/**
	 * 服务类别
	 */
	private Integer serviceType;
	
	/**
	 * 服务时间：举例：周六-周日
	 */
	private String serviceDateStr;
	
	/**
	 * 服务区域
	 */
	private String area;
	
	/**
	 * 自我介绍
	 */
	private String introduction;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 更新日期
	 */
	private Date updateDate;
	
	/**
	 * Empty constructor
	 */
	public VolVolunteerRecommended() {
		super();
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
	 * 获取 服务类别
	 */
	public Integer getServiceType() {
		return serviceType;
	}
	
	/**
	 * 设置 服务类别
	 */
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	
	/**
	 * 获取 服务时间：举例：周六-周日
	 */
	public String getServiceDateStr() {
		return serviceDateStr;
	}
	
	/**
	 * 设置 服务时间：举例：周六-周日
	 */
	public void setServiceDateStr(String serviceDateStr) {
		this.serviceDateStr = serviceDateStr;
	}
	
	/**
	 * 获取 服务区域
	 */
	public String getArea() {
		return area;
	}
	
	/**
	 * 设置 服务区域
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	 * 获取 自我介绍
	 */
	public String getIntroduction() {
		return introduction;
	}
	
	/**
	 * 设置 自我介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * 获取 创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 获取 更新日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置 更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
