package com.bjb.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolAccessDao;
import com.bjb.entity.VolAccess;
import com.bjb.util.MessageSettings;

@RestController
@RequestMapping("/access")
public class VolAccessController {

	@Resource
	private VolAccessDao accessDao;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	//新增角色节点权限
	@RequestMapping("/add")
	public ReturnJsonObject add() throws SQLException{
		VolAccess access = new VolAccess();
		access.setRole_id(Integer.parseInt(request.getParameter("role_id")));
		access.setNode_id(Integer.parseInt(request.getParameter("node_id")));
		access.setLevel(Integer.parseInt(request.getParameter("level")));
		int i = accessDao.insert(access);
		if(i > 0){
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		} 
	}
	
	//删除角色节点权限
	@RequestMapping("/del")
	public ReturnJsonObject delete() throws SQLException{
		int i = accessDao.delete(Integer.parseInt(request.getParameter("id")));
		if(i > 0){
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}  
	}
}
