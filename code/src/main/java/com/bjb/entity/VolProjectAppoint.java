package com.bjb.entity;

import java.util.Date;

public class VolProjectAppoint extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 报名编号ID
	 */
	private Integer signUpId;
	
	/**
	 * 配送人Id(机构用户ID)
	 */
	private Integer appointUserId;
	
	/**
	 * 配送时间
	 */
	private Date appointDate;
	
	/**
	 * Empty constructor
	 */
	public VolProjectAppoint() {
		super();
	}
	
	/**
	 * 获取 报名编号ID
	 */
	public Integer getSignUpId() {
		return signUpId;
	}
	
	/**
	 * 设置 报名编号ID
	 */
	public void setSignUpId(Integer signUpId) {
		this.signUpId = signUpId;
	}
	
	/**
	 * 获取 配送人Id(机构用户ID)
	 */
	public Integer getAppointUserId() {
		return appointUserId;
	}
	
	/**
	 * 设置 配送人Id(机构用户ID)
	 */
	public void setAppointUserId(Integer appointUserId) {
		this.appointUserId = appointUserId;
	}
	
	/**
	 * 获取 配送时间
	 */
	public Date getAppointDate() {
		return appointDate;
	}
	
	/**
	 * 设置 配送时间
	 */
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
}
