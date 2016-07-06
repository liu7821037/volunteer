package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolReport extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 风采ID
	 */
	private Integer elegantId;
	private String elegantTitle;
	
	/**
	 * 举报者ID
	 */
	private Integer volunteerId;
	private String fullName;
	
	/**
	 * 举报日期
	 */
	private Date reportDate;
	
	/**
	 * 举报内容
	 */
	private String reportContent;
	
	/**
	 * 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	private String checkStatus;
	
	/**
	 * 审核者ID
	 */
	private Integer checkId;
	
	/**
	 * 审核日期
	 */
	private Date checkDate;
	
	/**
	 * Empty constructor
	 */
	public VolReport() {
		super();
	}
	
	/**
	 * 获取 风采ID
	 */
	public Integer getElegantId() {
		return elegantId;
	}
	
	/**
	 * 设置 风采ID
	 */
	public void setElegantId(Integer elegantId) {
		this.elegantId = elegantId;
	}
	
	/**
	 * 获取 举报者ID
	 */
	public Integer getVolunteerId() {
		return volunteerId;
	}
	
	/**
	 * 设置 举报者ID
	 */
	public void setVolunteerId(Integer volunteerId) {
		this.volunteerId = volunteerId;
	}
	
	/**
	 * 获取 举报日期
	 */
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getReportDate() {
		return reportDate;
	}
	
	/**
	 * 设置 举报日期
	 */
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
	/**
	 * 获取 举报内容
	 */
	public String getReportContent() {
		return reportContent;
	}
	
	/**
	 * 设置 举报内容
	 */
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
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
	 * 获取 审核者ID
	 */
	public Integer getCheckId() {
		return checkId;
	}
	
	/**
	 * 设置 审核者ID
	 */
	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}
	
	/**
	 * 获取 审核日期
	 */
	public Date getCheckDate() {
		return checkDate;
	}
	
	/**
	 * 设置 审核日期
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getElegantTitle() {
		return elegantTitle;
	}

	public void setElegantTitle(String elegantTitle) {
		this.elegantTitle = elegantTitle;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
