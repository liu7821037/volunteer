package com.bjb.entity;

import java.util.Date;

import com.bjb.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VolServiceProject extends BasicDto {

	private static final long serialVersionUID = 1;
	
	private VolProjectCount projectCount;
	/**
	 * 项目标题
	 */
	private String projectTitle;
	
	/**
	 * 省区域
	 */
	private Integer area_pid;
	private String provinceName;
	
	/**
	 * 市区域
	 */
	private Integer area_cid;
	private String cityName;
	
	/**
	 * 项目类型：全部、扶危济困、敬老助残、社区服务、秩序维护、文体服务、环境保护、治安防范、医疗救治、法律援助、大型活动、心里疏导、精神抚慰、支教支医、科学普及、应急救援、便民服务、民事调解、文明引导、安全生产
	 */
	private Integer projectTypeId;
	private String typeName;
	
	/**
	 * 服务对象
	 */
	private Integer projectServiceObject;
	private String objectName;
	
	/**
	 * 项目招募人数
	 */
	private Integer projectRecruitment;
	
	/**
	 * 主办机构
	 */
	private String projectOrganizer;
	
	/**
	 * 活动地点
	 */
	private String projectAddress;
	
	/**
	 * 经度
	 */
	private Double latitude;
	
	/**
	 * 纬度
	 */
	private Double longitude;
	
	/**
	 * 封面
	 */
	private String projectCover;
	
	/**
	 * 项目详细
	 */
	private String detail;
	
	/**
	 * 招募结束日期
	 */
	private Date projectEnrrolEndDate;
	
	/**
	 * 项目开始日期 格式：YYYY-MM-DD HH:MM
	 */
	private Date projectStartDate;
	
	/**
	 * 项目结束日期
	 */
	private Date projectEndDate;
	
	/**
	 * 项目最高可获积分
	 */
	private Integer projectScore;
	
	/**
	 * 创建者Id
	 */
	private Integer creatorId;
	private String userName;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 更新日期
	 */
	private Date updateDate;
	
	private String nowTimeStr;
	private Integer flag;
	private Integer state;
	private String projectEndDate1;
	private String projectStartDate1;
	private String projectEnrrolEndDate1;
	private String token;
	


	

	/**
	 * 是否置顶（1：置顶；0：否）
	 */
	private Integer istop;
	
	private Integer canEnroll;
	/**
	 * Empty constructor
	 */
	public VolServiceProject() {
		super();
	}
	
	/**
	 * 获取 项目标题
	 */
	public String getProjectTitle() {
		return projectTitle;
	}
	
	/**
	 * 设置 项目标题
	 */
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	
	/**
	 * 获取 省区域
	 */
	public Integer getAreaPid() {
		return area_pid;
	}
	
	/**
	 * 设置 省区域
	 */
	public void setAreaPid(Integer area_pid) {
		this.area_pid = area_pid;
	}
	
	/**
	 * 获取 市区域
	 */
	public Integer getAreaCid() {
		return area_cid;
	}
	
	/**
	 * 设置 市区域
	 */
	public void setAreaCid(Integer area_cid) {
		this.area_cid = area_cid;
	}
	
	/**
	 * 获取 项目类型：全部、扶危济困、敬老助残、社区服务、秩序维护、文体服务、环境保护、治安防范、医疗救治、法律援助、大型活动、心里疏导、精神抚慰、支教支医、科学普及、应急救援、便民服务、民事调解、文明引导、安全生产
	 */
	public Integer getProjectTypeId() {
		return projectTypeId;
	}
	
	/**
	 * 设置 项目类型：全部、扶危济困、敬老助残、社区服务、秩序维护、文体服务、环境保护、治安防范、医疗救治、法律援助、大型活动、心里疏导、精神抚慰、支教支医、科学普及、应急救援、便民服务、民事调解、文明引导、安全生产
	 */
	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	
	/**
	 * 获取 服务对象
	 */
	public Integer getProjectServiceObject() {
		return projectServiceObject;
	}
	
	/**
	 * 设置 服务对象
	 */
	public void setProjectServiceObject(Integer projectServiceObject) {
		this.projectServiceObject = projectServiceObject;
	}
	
	/**
	 * 获取 项目招募人数
	 */
	public Integer getProjectRecruitment() {
		return projectRecruitment;
	}
	
	/**
	 * 设置 项目招募人数
	 */
	public void setProjectRecruitment(Integer projectRecruitment) {
		this.projectRecruitment = projectRecruitment;
	}
	
	/**
	 * 获取 主办机构
	 */
	public String getProjectOrganizer() {
		return projectOrganizer;
	}
	
	/**
	 * 设置 主办机构
	 */
	public void setProjectOrganizer(String projectOrganizer) {
		this.projectOrganizer = projectOrganizer;
	}
	
	/**
	 * 获取 活动地点
	 */
	public String getProjectAddress() {
		return projectAddress;
	}
	
	/**
	 * 设置 活动地点
	 */
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	
	/**
	 * 获取 经度
	 */
	public Double getLatitude() {
		return latitude;
	}
	
	/**
	 * 设置 经度
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 获取 纬度
	 */
	public Double getLongitude() {
		return longitude;
	}
	
	/**
	 * 设置 纬度
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 获取 封面
	 */
	public String getProjectCover() {
		return projectCover;
	}
	
	/**
	 * 设置 封面
	 */
	public void setProjectCover(String projectCover) {
		this.projectCover = projectCover;
	}
	
	/**
	 * 获取 项目详细
	 */
	public String getDetail() {
		return detail;
	}
	
	/**
	 * 设置 项目详细
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * 获取 招募结束日期
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getProjectEnrrolEndDate() {
		return projectEnrrolEndDate;
	}
	
	/**
	 * 设置 招募结束日期
	 */
	public void setProjectEnrrolEndDate(Date projectEnrrolEndDate) {
		this.projectEnrrolEndDate = projectEnrrolEndDate;
	}
	
	/**
	 * 获取 项目开始日期 格式：YYYY-MM-DD HH:MM
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	
	/**
	 * 设置 项目开始日期 格式：YYYY-MM-DD HH:MM
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
	/**
	 * 获取 项目结束日期
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	
	/**
	 * 设置 项目结束日期
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	/**
	 * 获取 项目最高可获积分
	 */
	public Integer getProjectScore() {
		return projectScore;
	}
	
	/**
	 * 设置 项目最高可获积分
	 */
	public void setProjectScore(Integer projectScore) {
		this.projectScore = projectScore;
	}
	
	/**
	 * 获取 创建者Id
	 */
	public Integer getCreatorId() {
		return creatorId;
	}
	
	/**
	 * 设置 创建者Id
	 */
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	/**
	 * 获取 创建日期
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
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

	public Integer getIstop() {
		return istop;
	}

	public void setIstop(Integer istop) {
		this.istop = istop;
	}

	public String getNowTimeStr() {
		return nowTimeStr;
	}

	public void setNowTimeStr(String nowTimeStr) {
		this.nowTimeStr = nowTimeStr;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public VolProjectCount getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(VolProjectCount projectCount) {
		this.projectCount = projectCount;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCanEnroll() {
		return canEnroll;
	}

	public void setCanEnroll(Integer canEnroll) {
		this.canEnroll = canEnroll;
	}
	
	public String getProjectEndDate1() {
		return projectEndDate1;
	}

	public void setProjectEndDate1(String projectEndDate1) {
		this.projectEndDate1 = projectEndDate1;
	}

	public String getProjectStartDate1() {
		return projectStartDate1;
	}

	public void setProjectStartDate1(String projectStartDate1) {
		this.projectStartDate1 = projectStartDate1;
	}

	public String getProjectEnrrolEndDate1() {
		return projectEnrrolEndDate1;
	}

	public void setProjectEnrrolEndDate1(String projectEnrrolEndDate1) {
		this.projectEnrrolEndDate1 = projectEnrrolEndDate1;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
