package com.bjb.entity;

public class VolScore extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 场馆ID
	 */
	private Integer organizationId;
	
	/**
	 * 志愿者ID
	 */
	private Integer volunteerId;
	
	/**
	 * 当前积分
	 */
	private Integer currentScore;
	
	/**
	 * 累计积分
	 */
	private Integer totalScore;
	
	/**
	 * Empty constructor
	 */
	public VolScore() {
		super();
	}
	
	/**
	 * 获取 场馆ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	
	/**
	 * 设置 场馆ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	/**
	 * 获取 志愿者ID
	 */
	public Integer getVolunteerId() {
		return volunteerId;
	}
	
	/**
	 * 设置 志愿者ID
	 */
	public void setVolunteerId(Integer volunteerId) {
		this.volunteerId = volunteerId;
	}
	
	/**
	 * 获取 当前积分
	 */
	public Integer getCurrentScore() {
		return currentScore;
	}
	
	/**
	 * 设置 当前积分
	 */
	public void setCurrentScore(Integer currentScore) {
		this.currentScore = currentScore;
	}
	
	/**
	 * 获取 累计积分
	 */
	public Integer getTotalScore() {
		return totalScore;
	}
	
	/**
	 * 设置 累计积分
	 */
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
}
