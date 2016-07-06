package com.bjb.entity;

import java.util.Date;

public class VolArea extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 地域名称
	 */
	private String area_name;
	
	/**
	 * 上一级地域ID
	 */
	private Integer parent_area_id;
	
	/**
	 * 添加时间
	 */
	private Date add_time;
	
	/**
	 * 地域简称
	 */
	private String first_letter;
	
	/**
	 * 拼音
	 */
	private String pinyin;
	
	/**
	 * 区号
	 */
	private String area_number;
	
	/**
	 * 邮编
	 */
	private String zipCode;
	
	/**
	 * 是否热点城市 0:否 1:是
	 */
	private Integer hot_city;
	
	/**
	 * 经度
	 */
	private double longitude;
	
	/**
	 * 纬度
	 */
	private double latitude;
	
	/**
	 * 数量
	 */
	private Integer number;
	
	/**
	 * 排序
	 */
	private Integer area_sort;
	
	/**
	 * Empty constructor
	 */
	public VolArea() {
		super();
	}
	
	/**
	 * 获取 地域名称
	 */
	public String getAreaName() {
		return area_name;
	}
	
	/**
	 * 设置 地域名称
	 */
	public void setAreaName(String area_name) {
		this.area_name = area_name;
	}
	
	/**
	 * 获取 上一级地域ID
	 */
	public Integer getParentAreaId() {
		return parent_area_id;
	}
	
	/**
	 * 设置 上一级地域ID
	 */
	public void setParentAreaId(Integer parent_area_id) {
		this.parent_area_id = parent_area_id;
	}
	
	/**
	 * 获取 添加时间
	 */
	public Date getAddTime() {
		return add_time;
	}
	
	/**
	 * 设置 添加时间
	 */
	public void setAddTime(Date add_time) {
		this.add_time = add_time;
	}
	
	/**
	 * 获取 地域简称
	 */
	public String getFirstLetter() {
		return first_letter;
	}
	
	/**
	 * 设置 地域简称
	 */
	public void setFirstLetter(String first_letter) {
		this.first_letter = first_letter;
	}
	
	/**
	 * 获取 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}
	
	/**
	 * 设置 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
	/**
	 * 获取 区号
	 */
	public String getAreaNumber() {
		return area_number;
	}
	
	/**
	 * 设置 区号
	 */
	public void setAreaNumber(String area_number) {
		this.area_number = area_number;
	}
	
	/**
	 * 获取 邮编
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * 设置 邮编
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * 获取 是否热点城市 0:否 1:是
	 */
	public Integer getHotCity() {
		return hot_city;
	}
	
	/**
	 * 设置 是否热点城市 0:否 1:是
	 */
	public void setHotCity(Integer hot_city) {
		this.hot_city = hot_city;
	}
	
	/**
	 * 获取 经度
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * 设置 经度
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 获取 纬度
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * 设置 纬度
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 获取 数量
	 */
	public Integer getNumber() {
		return number;
	}
	
	/**
	 * 设置 数量
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	/**
	 * 获取 排序
	 */
	public Integer getAreaSort() {
		return area_sort;
	}
	
	/**
	 * 设置 排序
	 */
	public void setAreaSort(Integer area_sort) {
		this.area_sort = area_sort;
	}
}
