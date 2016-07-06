package com.bjb.entity;

public class VolCommonUser extends BasicDto {

	private static final long serialVersionUID = 1;
	
	/**
	 * 公共用户账号
	 */
	private String commonUserCode;
	
	/**
	 * 公共用户密码
	 */
	private String commonUserPwd;
	
	/**
	 * 公共用户昵称
	 */
	private String commonUserNickname;
	
	/**
	 * 公共用户头像
	 */
	private String commonUserPortrait;
	
	/**
	 * 公共用户手机号
	 */
	private String commonUserPhone;
	
	/**
	 * 公共用户邮箱
	 */
	private String commonUserEmail;
	
	/**
	 * 用户统一标识
	 */
	private String onlySign;
	
	/**
	 * Empty constructor
	 */
	public VolCommonUser() {
		super();
	}
	
	/**
	 * 获取 公共用户账号
	 */
	public String getCommonUserCode() {
		return commonUserCode;
	}
	
	/**
	 * 设置 公共用户账号
	 */
	public void setCommonUserCode(String commonUserCode) {
		this.commonUserCode = commonUserCode;
	}
	
	/**
	 * 获取 公共用户密码
	 */
	public String getCommonUserPwd() {
		return commonUserPwd;
	}
	
	/**
	 * 设置 公共用户密码
	 */
	public void setCommonUserPwd(String commonUserPwd) {
		this.commonUserPwd = commonUserPwd;
	}
	
	/**
	 * 获取 公共用户昵称
	 */
	public String getCommonUserNickname() {
		return commonUserNickname;
	}
	
	/**
	 * 设置 公共用户昵称
	 */
	public void setCommonUserNickname(String commonUserNickname) {
		this.commonUserNickname = commonUserNickname;
	}
	
	/**
	 * 获取 公共用户头像
	 */
	public String getCommonUserPortrait() {
		return commonUserPortrait;
	}
	
	/**
	 * 设置 公共用户头像
	 */
	public void setCommonUserPortrait(String commonUserPortrait) {
		this.commonUserPortrait = commonUserPortrait;
	}
	
	/**
	 * 获取 公共用户手机号
	 */
	public String getCommonUserPhone() {
		return commonUserPhone;
	}
	
	/**
	 * 设置 公共用户手机号
	 */
	public void setCommonUserPhone(String commonUserPhone) {
		this.commonUserPhone = commonUserPhone;
	}
	
	/**
	 * 获取 公共用户邮箱
	 */
	public String getCommonUserEmail() {
		return commonUserEmail;
	}
	
	/**
	 * 设置 公共用户邮箱
	 */
	public void setCommonUserEmail(String commonUserEmail) {
		this.commonUserEmail = commonUserEmail;
	}
	
	/**
	 * 获取 用户统一标识
	 */
	public String getOnlySign() {
		return onlySign;
	}
	
	/**
	 * 设置 用户统一标识
	 */
	public void setOnlySign(String onlySign) {
		this.onlySign = onlySign;
	}
}
