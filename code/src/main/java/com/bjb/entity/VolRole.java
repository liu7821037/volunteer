package com.bjb.entity;

public class VolRole extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 名称,类型：0：普通用户、1：志愿者，2：机构用户，3：志愿者团体
	 */
	private String name ;
	
	/**
	 * 父级ID
	 */
	private Integer pid;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * Empty constructor
	 */
	public VolRole() {
		super();
	}
	
	/**
	 * 获取 名称,类型：0：普通用户、1：志愿者，2：机构用户，3：志愿者团体
	 */
	public String getName () {
		return name ;
	}
	
	/**
	 * 设置 名称,类型：0：普通用户、1：志愿者，2：机构用户，3：志愿者团体
	 */
	public void setName (String name ) {
		this.name  = name ;
	}
	
	/**
	 * 获取 父级ID
	 */
	public Integer getPid() {
		return pid;
	}
	
	/**
	 * 设置 父级ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	/**
	 * 获取 状态
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
