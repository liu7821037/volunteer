package com.bjb.entity;

import java.util.Date;

public class VolProjectCount extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 报名人数
	 */
	private Integer join_nums;
	
	/**
	 * 阅读人数
	 */
	private Integer read_nums;
	
	/**
	 * 分享数
	 */
	private Integer share_nums;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 更新日期
	 */
	private Date updateDate;
	private String token;
	
	

	/**
	 * Empty constructor
	 */
	public VolProjectCount() {
		super();
	}
	
	/**
	 * 获取 报名人数
	 */
	public Integer getJoinNums() {
		return join_nums;
	}
	
	/**
	 * 设置 报名人数
	 */
	public void setJoinNums(Integer join_nums) {
		this.join_nums = join_nums;
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
	 * 获取 创建日期
	 */
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
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
