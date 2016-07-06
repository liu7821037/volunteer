package com.bjb.entity;

public class VolOrganization extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 场馆名称
	 */
	private String organizationName;
	
	/**
	 * 区域
	 */
	private String organizationArea;
	/**
	 * 本来想将上面的organizationArea换成int类型
	 */
	private String organizationAreaName;
	
	/**
	 * 详细地址
	 */
	private String organizationAddress;
	
	/**
	 * 负责人
	 */
	private String organizationHead;
	
	/**
	 * 负责人电话
	 */
	private String organizationHeadPhone;
	
	/**
	 * 邮箱
	 */
	private String organizationEmail;
	
	/**
	 * 邮编
	 */
	private String organizationZip;
	
	/**
	 * Empty constructor
	 */
	public VolOrganization() {
		super();
	}
	
	/**
	 * 获取 场馆名称
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	
	/**
	 * 设置 场馆名称
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	/**
	 * 获取 区域
	 */
	public String getOrganizationArea() {
		return organizationArea;
	}
	
	/**
	 * 设置 区域
	 */
	public void setOrganizationArea(String organizationArea) {
		this.organizationArea = organizationArea;
	}
	
	/**
	 * 获取 详细地址
	 */
	public String getOrganizationAddress() {
		return organizationAddress;
	}
	
	/**
	 * 设置 详细地址
	 */
	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}
	
	/**
	 * 获取 负责人
	 */
	public String getOrganizationHead() {
		return organizationHead;
	}
	
	/**
	 * 设置 负责人
	 */
	public void setOrganizationHead(String organizationHead) {
		this.organizationHead = organizationHead;
	}
	
	/**
	 * 获取 负责人电话
	 */
	public String getOrganizationHeadPhone() {
		return organizationHeadPhone;
	}
	
	/**
	 * 设置 负责人电话
	 */
	public void setOrganizationHeadPhone(String organizationHeadPhone) {
		this.organizationHeadPhone = organizationHeadPhone;
	}
	
	/**
	 * 获取 邮箱
	 */
	public String getOrganizationEmail() {
		return organizationEmail;
	}
	
	/**
	 * 设置 邮箱
	 */
	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}
	
	/**
	 * 获取 邮编
	 */
	public String getOrganizationZip() {
		return organizationZip;
	}
	
	/**
	 * 设置 邮编
	 */
	public void setOrganizationZip(String organizationZip) {
		this.organizationZip = organizationZip;
	}

	public String getOrganizationAreaName() {
		return organizationAreaName;
	}

	public void setOrganizationAreaName(String organizationAreaName) {
		this.organizationAreaName = organizationAreaName;
	}
	
	
}
