package com.bjb.common.bean;

import com.bjb.Constants;
import com.bjb.util.MessageSettings;

public class ReturnJsonObject {

	public int returnCode;

	public String msg;

	public Object data;

	public ReturnJsonObject(Object data) {
		this.returnCode = Constants.RETURN_CODE_1;
		this.msg = MessageSettings.getValue("MSG_INFO_002");
		this.data = data;
	}
	
	public ReturnJsonObject(String msg) {
		this.returnCode = Constants.RETURN_CODE_0;
		this.msg = msg;
		this.data = null;
	}
	
	public ReturnJsonObject() {
		this.returnCode = Constants.RETURN_CODE_1;
		this.msg = MessageSettings.getValue("MSG_INFO_002");
		this.data = null;
	}

	public ReturnJsonObject(int returnCode, String msg, Object data) {
		this.returnCode = returnCode;
		this.msg = msg;
		this.data = data;
	}
}
