package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolScoreStar extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 积分等级名称
	 */
	private String scoreTypeName;
	
	/**
	 * 积分数
	 */
	private Integer scoreNumber;
	
	/**
	 * 等级图标
	 */
	private String scoreTypePic;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 创建者Id
	 */
	private Integer createId;
	
	/**
	 * Empty constructor
	 */
	public VolScoreStar() {
		super();
	}
	
	/**
	 * 获取 积分等级名称
	 */
	public String getScoreTypeName() {
		return scoreTypeName;
	}
	
	/**
	 * 设置 积分等级名称
	 */
	public void setScoreTypeName(String scoreTypeName) {
		this.scoreTypeName = scoreTypeName;
	}
	
	/**
	 * 获取 积分数
	 */
	public Integer getScoreNumber() {
		return scoreNumber;
	}
	
	/**
	 * 设置 积分数
	 */
	public void setScoreNumber(Integer scoreNumber) {
		this.scoreNumber = scoreNumber;
	}
	
	/**
	 * 获取 等级图标
	 */
	public String getScoreTypePic() {
		return scoreTypePic;
	}
	
	/**
	 * 设置 等级图标
	 */
	public void setScoreTypePic(String scoreTypePic) {
		this.scoreTypePic = scoreTypePic;
	}
	
	/**
	 * 获取 创建时间
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 获取 创建者Id
	 */
	public Integer getCreateId() {
		return createId;
	}
	
	/**
	 * 设置 创建者Id
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
}
