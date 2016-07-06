package com.bjb.entity;

public class VolBasicData extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 类型ID
	 */
	private Integer typeId;
	
	/**
	 * 信息名称
	 */
	private String dataName;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 创建人id
	 */
	private Integer createUserId;
	
	/**
	 * Empty constructor
	 */
	public VolBasicData() {
		super();
	}
	
	/**
	 * 获取 类型ID
	 */
	public Integer getTypeId() {
		return typeId;
	}
	
	/**
	 * 设置 类型ID
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	/**
	 * 获取 信息名称
	 */
	public String getDataName() {
		return dataName;
	}
	
	/**
	 * 设置 信息名称
	 */
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	
	/**
	 * 获取 排序
	 */
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
	 * 获取 创建人id
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}
	
	/**
	 * 设置 创建人id
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
}
