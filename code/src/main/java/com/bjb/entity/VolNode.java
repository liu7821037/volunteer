package com.bjb.entity;

import java.util.List;

public class VolNode extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 排序
	 */
	private Integer remark;
	
	/**
	 * 父级ID
	 */
	private Integer sort;
	
	/**
	 * 层级
	 */
	private Integer pid;
	
	/**
	 * 备注
	 */
	private String level;
	
	private Integer access;
	
	private List<VolNode> node;
	/**
	 * Empty constructor
	 */
	public VolNode() {
		super();
	}
	
	/**
	 * 获取 名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取 标题
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * 获取 排序
	 */
	public Integer getRemark() {
		return remark;
	}
	
	/**
	 * 设置 排序
	 */
	public void setRemark(Integer remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取 父级ID
	 */
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 父级ID
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
	 * 获取 层级
	 */
	public Integer getPid() {
		return pid;
	}
	
	/**
	 * 设置 层级
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	/**
	 * 获取 备注
	 */
	public String getLevel() {
		return level;
	}
	
	/**
	 * 设置 备注
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getAccess() {
		return access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public List<VolNode> getNode() {
		return node;
	}

	public void setNode(List<VolNode> node) {
		this.node = node;
	}
	
}
