package com.bjb.entity;

public class VolAccess extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 角色ID
	 */
	private Integer role_id;
	
	/**
	 * 节点ID
	 */
	private Integer node_id;
	
	/**
	 * 层级
	 */
	private Integer level;
	
	/**
	 * 模块
	 */
	private String module;
	
	/**
	 * Empty constructor
	 */
	public VolAccess() {
		super();
	}
	
	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getNode_id() {
		return node_id;
	}

	public void setNode_id(Integer node_id) {
		this.node_id = node_id;
	}

	/**
	 * 获取 节点ID
	 */
	public Integer getNodeId() {
		return node_id;
	}
	
	/**
	 * 设置 节点ID
	 */
	public void setNodeId(Integer node_id) {
		this.node_id = node_id;
	}
	
	/**
	 * 获取 层级
	 */
	public Integer getLevel() {
		return level;
	}
	
	/**
	 * 设置 层级
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	/**
	 * 获取 模块
	 */
	public String getModule() {
		return module;
	}
	
	/**
	 * 设置 模块
	 */
	public void setModule(String module) {
		this.module = module;
	}
}
