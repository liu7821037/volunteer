package com.bjb.exception;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常拦截
 * @author liuli
 *
 */
public class ExceptionHandler implements HandlerExceptionResolver{

	/**
	 * 错误日记记录
	 */
	private static Logger errorLogger = Logger.getLogger("errorFile");
	
	//@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex) {
		
		 Map<String, String> model = new HashMap<String, String>();  
		 model.put("ex", exceptionHandler(ex));
     return new ModelAndView("/errorInfo", model);  
	}
	
	/**
	 * 异常数据组装
	 * @param ex
	 * @return
	 */
	private String exceptionHandler(Exception ex){
		String result="";
		if(ex instanceof SQLException){
			result=createFriendlyErrMSG("数据库操作错误："+ex.getMessage());
		}else if(ex instanceof NullPointerException){
			result=createFriendlyErrMSG("空指针异常："+ex.getMessage());
		}else if(ex instanceof NoSuchMethodException){
			result=createFriendlyErrMSG("Action方法名错误："+ex.getMessage());
		}else if(ex instanceof IOException){
			result=createFriendlyErrMSG("输入输出流错误："+ex.getMessage());
		}else if(ex instanceof ClassCastException){
			result=createFriendlyErrMSG("类型强制转化错误："+ex.getMessage());
		}else if(ex instanceof Exception){
			result=createFriendlyErrMSG("程序内部发生错误："+ex.getMessage());
		}
		errorLogger.error(result);
		return result;
	}
	
	/**
	 * 封装自定义异常信息
	 * @param errorBody
	 * @return
	 */
	private  String createFriendlyErrMSG(String errorBody){
		String prefix = "抱歉，";
		String suffix = "请稍后再试，或与管理员联系！";
		StringBuffer sb = new StringBuffer();
		sb.append(prefix);
		sb.append(errorBody);
		sb.append(suffix);
		return sb.toString();
	}


}
