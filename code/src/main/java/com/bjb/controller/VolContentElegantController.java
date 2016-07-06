package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.common.controller.BaseController;
import com.bjb.dao.VolElegantDemeanourDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolElegantDemeanour;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.service.VolContentElegentService;
import com.bjb.service.VolVolunteerUserService;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;

@RestController
@RequestMapping("/contentelegant")
public class VolContentElegantController extends BaseController{

	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Resource
	private VolContentElegentService volelegantservice;
	@Resource
	private VolVolunteerUserService volvolunteeruserservice;
	@Resource
	private VolElegantDemeanourDao  dao;
	@Resource
	private VolVolunteerUserDao  volvolunteeruserDao;
	

	//获取列表
	@RequestMapping("/getList")
	public ReturnJsonObject getList(VolElegantDemeanour elegant) throws SQLException{
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
		Page<VolElegantDemeanour> page = volelegantservice.getList(elegant, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	@RequestMapping("/getListByLimit")
	public List<VolElegantDemeanour> getListByLimit() throws SQLException{
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return volelegantservice.getListByLimit(pageSize);
	}
	
	@RequestMapping("/addStyle")
	public ReturnJsonObject addStyle(@RequestBody VolElegantDemeanour demeanour) throws SQLException{
		demeanour.setAuditTypeId(1);
		demeanour.setCreateDate(new Date());
		demeanour.setReadNums(0);
		demeanour.setShareNums(0);
		demeanour.setPicture(StringUnit.getImgSrcByHtml(demeanour.getDetail()));
		int i = dao.insert(demeanour);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_003"));
	}
	
	@RequestMapping("/upStyle")
	public ReturnJsonObject upStyle(@RequestBody VolElegantDemeanour demeanour) throws SQLException{
		demeanour.setUpdateDate(new Date());
		int i = dao.updatePartial(demeanour);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
	}
	
	@RequestMapping("/findById/{id}")
	public ReturnJsonObject findById(@PathVariable("id")int id) throws SQLException{
		VolElegantDemeanour demeanour = volelegantservice.findById(id);
		if(demeanour!=null)
			return new ReturnJsonObject(demeanour);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	@RequestMapping("/getById/{id}")
	public ReturnJsonObject getById(@PathVariable("id")int id) throws SQLException{
		VolElegantDemeanour demeanour = dao.findById(id);
		if(demeanour!=null)
			return new ReturnJsonObject(demeanour);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	//志愿者排行
	@RequestMapping("/getvlist")
	public ReturnJsonObject getvlist() throws SQLException{
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
		Page<VolVolunteerUser> page = volvolunteeruserservice.getList1(currentPage, pageSize);

		return new ReturnJsonObject(page);

	}
	
	@RequestMapping("/deletElegantById/{id}")
	public ReturnJsonObject deletNewsById(@PathVariable("id")  int id) throws SQLException{
		boolean flag = volelegantservice.deletElegantById(id);
		if(flag)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_006"));
	}
	
	//上架
	@RequestMapping("/onShelf")
	public ReturnJsonObject onShelf() throws SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		VolElegantDemeanour elegant = dao.findById(id);
		elegant.setAuditTypeId(1);
		int i = dao.update(elegant);
		if(i == 0)
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_004"));
		else
			return new ReturnJsonObject();
	}
	
	//下架
	@RequestMapping("/offShelf")
	public ReturnJsonObject offShelf() throws SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		VolElegantDemeanour elegant = dao.findById(id);
		elegant.setAuditTypeId(0);
		int i = dao.update(elegant);
		if(i == 0)
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_005"));
		else
			return new ReturnJsonObject();
	}
}
