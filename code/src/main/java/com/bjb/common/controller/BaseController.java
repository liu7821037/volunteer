package com.bjb.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bjb.Constants;
import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;

/**
 * 共通父控制器
 * @author: Bjb.liuhui
 * Date: 16-05-16
 * Version: 1.0
 */
public class BaseController {
	/** 基于@ExceptionHandler异常处理 */
	@ExceptionHandler
	public ReturnJsonObject exp(HttpServletRequest request, Exception ex) {
		ex.printStackTrace();
		String code = "MSG_ERROR_000";
		if(StringUnit.isNotEmpty(request.getAttribute("MSG_CODE"))){
			code = (String)request.getAttribute("MSG_CODE");
		}
		return new ReturnJsonObject(Constants.RETURN_CODE_0,
				MessageSettings.getValue(code), null);
	}
}