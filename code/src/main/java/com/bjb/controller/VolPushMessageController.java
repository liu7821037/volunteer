package com.bjb.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolPushMessageDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolPushMessage;
import com.bjb.service.VolPushMessageService;
import com.bjb.util.MessageSettings;

@RestController
@RequestMapping("/message")
public class VolPushMessageController {

	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	@Resource
	private VolPushMessageService service;
	@Resource
	private VolPushMessageDao dao;
	
	//获得消息列表（含分页信息）
	@RequestMapping("/getList")
	public ReturnJsonObject getList(VolPushMessage message) throws SQLException{
		String curentPage = request.getParameter("currentPage");
		String pagesize = request.getParameter("pageSize");
		if(curentPage == null){
			curentPage = 1+"";
		}
		if(pagesize == null){
			pagesize = 10+"";
		}
		int currentPage = Integer.parseInt(curentPage);
		int pageSize = Integer.parseInt(pagesize);
		Page<VolPushMessage> page = service.getList(message,currentPage,pageSize);
		return new ReturnJsonObject(page);
	}
	
	//根据ID查消息详情
	@RequestMapping("/getById/{id}")
	public ReturnJsonObject getById(@PathVariable("id")int id) throws SQLException{
		VolPushMessage message = dao.findById(id);
		if(message != null){
			message.setReadOrNot(1);
			dao.update(message);
			return new ReturnJsonObject(message);			
		}
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	//根据条件统计总数
	@RequestMapping("/countByDto")
	public ReturnJsonObject countByDto(VolPushMessage message) throws SQLException{
		int count = dao.countByDto(message);
		return new ReturnJsonObject(count);
	}
}
