package com.bjb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolDataTypeDao;
import com.bjb.entity.VolDataType;
import com.bjb.util.MessageSettings;

@RestController
@RequestMapping("/type")
public class VolDataTypeController {

	@Resource
	private VolDataTypeDao typeDao;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("/all")
	public ReturnJsonObject findList() throws SQLException{
		VolDataType type = new VolDataType();
		type.setStatus(1);
		List<VolDataType> list = typeDao.findByDto(type);
		if(list.size() > 0){
			return new ReturnJsonObject(list); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
}
