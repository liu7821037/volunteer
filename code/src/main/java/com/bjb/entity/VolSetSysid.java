package com.bjb.entity;

import java.util.Date;

public class VolSetSysid extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 用户唯一标识符
	 */
	private String onlySign;
	
	/**
	 * 新生成的id
	 */
	private Integer projectId;
	
	/**
	 * 原id
	 */
	private Integer sid;
	
	/**
	 * 创建时间
	 */
	private Date creat_time;
	
	/**
	 * 更新时间
	 */
	private Date update_time;
	
	/**
	 * Empty constructor
	 */
	public VolSetSysid() {
		super();
	}
	
	/**
	 * 获取 用户唯一标识符
	 */
	public String getOnlySign() {
		return onlySign;
	}
	
	/**
	 * 设置 用户唯一标识符
	 */
	public void setOnlySign(String onlySign) {
		this.onlySign = onlySign;
	}
	
	/**
	 * 获取 新生成的id
	 */
	public Integer getProjectId() {
		return projectId;
	}
	
	/**
	 * 设置 新生成的id
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	/**
	 * 获取 原id
	 */
	public Integer getSid() {
		return sid;
	}
	
	/**
	 * 设置 原id
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	/**
	 * 获取 创建时间
	 */
	public Date getCreatTime() {
		return creat_time;
	}
	
	/**
	 * 设置 创建时间
	 */
	public void setCreatTime(Date creat_time) {
		this.creat_time = creat_time;
	}
	
	/**
	 * 获取 更新时间
	 */
	public Date getUpdateTime() {
		return update_time;
	}
	
	/**
	 * 设置 更新时间
	 */
	public void setUpdateTime(Date update_time) {
		this.update_time = update_time;
	}
}
