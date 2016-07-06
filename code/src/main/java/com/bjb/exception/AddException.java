package com.bjb.exception;

/**
 * 
 * @author Administrator
 *
 */
public class AddException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AddException(String code) {
		this.code = code;
	}
}
