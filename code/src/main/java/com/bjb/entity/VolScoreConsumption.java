package com.bjb.entity;

import java.util.Date;

public class VolScoreConsumption extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 场馆ID
	 */
	private Integer organizationId;
	
	/**
	 * 志愿者ID
	 */
	private Integer volunteerId;
	
	/**
	 * 兑换积分
	 */
	private Integer RedeemForehead;
	
	/**
	 * 兑换日期
	 */
	private Date RedeemDate;
	
	/**
	 * 操作人（机构用户ID）
	 */
	private Integer operator;
	
	/**
	 * 事由
	 */
	private String RedeemReason;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * Empty constructor
	 */
	public VolScoreConsumption() {
		super();
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
	 * 获取 兑换积分
	 */
	public Integer getRedeemForehead() {
		return RedeemForehead;
	}
	
	/**
	 * 设置 兑换积分
	 */
	public void setRedeemForehead(Integer RedeemForehead) {
		this.RedeemForehead = RedeemForehead;
	}
	
	/**
	 * 获取 兑换日期
	 */
	public Date getRedeemDate() {
		return RedeemDate;
	}
	
	/**
	 * 设置 兑换日期
	 */
	public void setRedeemDate(Date RedeemDate) {
		this.RedeemDate = RedeemDate;
	}
	
	/**
	 * 获取 操作人（机构用户ID）
	 */
	public Integer getOperator() {
		return operator;
	}
	
	/**
	 * 设置 操作人（机构用户ID）
	 */
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	
	/**
	 * 获取 事由
	 */
	public String getRedeemReason() {
		return RedeemReason;
	}
	
	/**
	 * 设置 事由
	 */
	public void setRedeemReason(String RedeemReason) {
		this.RedeemReason = RedeemReason;
	}
	
	/**
	 * 获取 备注
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * 设置 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
