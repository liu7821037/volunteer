package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolNewsInfomation extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 标题
	 */
	private String infomationTitle;
	
	/**
	 * 正文内容
	 */
	private String infomationContent;
	
	/**
	 * 类型：0：资讯，1：公告，2：活动动态，3：工作文件
	 */
	private Integer infomationType;
	
	/**
	 * 发布者（机构用户ID）
	 */
	private Integer infomationRelease;
	private String userName;
	
	/**
	 * 发布日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	private Date releaseDate;
	
	/**
	 * 浏览次数
	 */
	private Integer viewed;
	int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Empty constructor
	 */
	public VolNewsInfomation() {
		super();
	}
	
	/**
	 * 获取 标题
	 */
	public String getInfomationTitle() {
		return infomationTitle;
	}
	
	/**
	 * 设置 标题
	 */
	public void setInfomationTitle(String infomationTitle) {
		this.infomationTitle = infomationTitle;
	}
	
	/**
	 * 获取 正文内容
	 */
	public String getInfomationContent() {
		return infomationContent;
	}
	
	/**
	 * 设置 正文内容
	 */
	public void setInfomationContent(String infomationContent) {
		this.infomationContent = infomationContent;
	}
	
	/**
	 * 获取 类型：0：资讯，1：公告，2：活动动态，3：工作文件
	 */
	public Integer getInfomationType() {
		return infomationType;
	}
	
	/**
	 * 设置 类型：0：资讯，1：公告，2：活动动态，3：工作文件
	 */
	public void setInfomationType(Integer infomationType) {
		this.infomationType = infomationType;
	}
	
	/**
	 * 获取 发布者（机构用户ID）
	 */
	public Integer getInfomationRelease() {
		return infomationRelease;
	}
	
	/**
	 * 设置 发布者（机构用户ID）
	 */
	public void setInfomationRelease(Integer infomationRelease) {
		this.infomationRelease = infomationRelease;
	}
	
	/**
	 * 获取 发布日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	/**
	 * 设置 发布日期，格式：YYYY-MM-DD HH:MM:SS
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	/**
	 * 获取 浏览次数
	 */
	public Integer getViewed() {
		return viewed;
	}
	
	/**
	 * 设置 浏览次数
	 */
	public void setViewed(Integer viewed) {
		this.viewed = viewed;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
