package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolElegantDemeanour extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 标题
	 */
	private String elegantTitle;
	
	/**
	 * 1:个人风采；2：团体风采
	 */
	private Integer type;
	
	/**
	 * 图片
	 */
	private String picture;
	
	/**
	 * 项目详细
	 */
	private String detail;
	
	/**
	 * 审核人，本场馆机构用户可以审核
	 */
	private Integer auditor;
	
	/**
	 * 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	private Integer auditTypeId;
	
	/**
	 * 审核日期
	 */
	private Date auditDate;
	
	/**
	 * 阅读人数
	 */
	private Integer read_nums;
	
	/**
	 * 分享数
	 */
	private Integer share_nums;
	
	/**
	 * 创建者Id
	 */
	private Integer creatorId;
	private String userName;
	private String token;
	


	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 更新日期
	 */
	private Date updateDate;
	int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Empty constructor
	 */
	public VolElegantDemeanour() {
		super();
	}
	
	/**
	 * 获取 标题
	 */
	public String getElegantTitle() {
		return elegantTitle;
	}
	
	/**
	 * 设置 标题
	 */
	public void setElegantTitle(String elegantTitle) {
		this.elegantTitle = elegantTitle;
	}
	
	/**
	 * 获取 1:个人风采；2：团体风采
	 */
	public Integer getType() {
		return type;
	}
	
	/**
	 * 设置 1:个人风采；2：团体风采
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * 获取 项目详细
	 */
	public String getDetail() {
		return detail;
	}
	
	/**
	 * 设置 项目详细
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * 获取 审核人，本场馆机构用户可以审核
	 */
	public Integer getAuditor() {
		return auditor;
	}
	
	/**
	 * 设置 审核人，本场馆机构用户可以审核
	 */
	public void setAuditor(Integer auditor) {
		this.auditor = auditor;
	}
	
	/**
	 * 获取 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	public Integer getAuditTypeId() {
		return auditTypeId;
	}
	
	/**
	 * 设置 审核状态：0：未审核，1：审核通过，2：审核未通过
	 */
	public void setAuditTypeId(Integer auditTypeId) {
		this.auditTypeId = auditTypeId;
	}
	
	/**
	 * 获取 审核日期
	 */
	public Date getAuditDate() {
		return auditDate;
	}
	
	/**
	 * 设置 审核日期
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	
	/**
	 * 获取 阅读人数
	 */
	public Integer getReadNums() {
		return read_nums;
	}
	
	/**
	 * 设置 阅读人数
	 */
	public void setReadNums(Integer read_nums) {
		this.read_nums = read_nums;
	}
	
	/**
	 * 获取 分享数
	 */
	public Integer getShareNums() {
		return share_nums;
	}
	
	/**
	 * 设置 分享数
	 */
	public void setShareNums(Integer share_nums) {
		this.share_nums = share_nums;
	}
	
	/**
	 * 获取 创建者Id
	 */
	public Integer getCreatorId() {
		return creatorId;
	}
	
	/**
	 * 设置 创建者Id
	 */
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	/**
	 * 获取 创建日期
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
