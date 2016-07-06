package com.bjb.entity;

public class VolDataType extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * Empty constructor
	 */
	public VolDataType() {
		super();
	}
	
	/**
	 * 获取 类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	
	/**
	 * 设置 类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
}
