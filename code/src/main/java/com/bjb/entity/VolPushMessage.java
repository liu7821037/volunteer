package com.bjb.entity;

import java.util.Date;

public class VolPushMessage extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 项目ID
	 */
	private Integer projectId;
	private String projectTitle;
	
	/**
	 * 自愿者ID
	 */
	private Integer volunteerId;
	private String userName;
	
	/**
	 * 消息标题
	 */
	private String messageTitle;
	
	/**
	 * 消息内容
	 */
	private String messageContent;
	
	/**
	 * 操作人（机构用户id)
	 */
	private Integer messageOperator;
	
	/**
	 * 推送日期
	 */
	private Date pushDate;
	
	/**
	 * '1','0'
	 */
	private Integer readOrNot;
	
	/**
	 * Empty constructor
	 */
	public VolPushMessage() {
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
	 * 获取 自愿者ID
	 */
	public Integer getVolunteerId() {
		return volunteerId;
	}
	
	/**
	 * 设置 自愿者ID
	 */
	public void setVolunteerId(Integer volunteerId) {
		this.volunteerId = volunteerId;
	}
	
	/**
	 * 获取 消息标题
	 */
	public String getMessageTitle() {
		return messageTitle;
	}
	
	/**
	 * 设置 消息标题
	 */
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	
	/**
	 * 获取 消息内容
	 */
	public String getMessageContent() {
		return messageContent;
	}
	
	/**
	 * 设置 消息内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	/**
	 * 获取 操作人（机构用户id)
	 */
	public Integer getMessageOperator() {
		return messageOperator;
	}
	
	/**
	 * 设置 操作人（机构用户id)
	 */
	public void setMessageOperator(Integer messageOperator) {
		this.messageOperator = messageOperator;
	}
	
	/**
	 * 获取 推送日期
	 */
	public Date getPushDate() {
		return pushDate;
	}
	
	/**
	 * 设置 推送日期
	 */
	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}
	
	/**
	 * 获取 '1','0'
	 */
	public Integer getReadOrNot() {
		return readOrNot;
	}
	
	/**
	 * 设置 '1','0'
	 */
	public void setReadOrNot(Integer readOrNot) {
		this.readOrNot = readOrNot;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
