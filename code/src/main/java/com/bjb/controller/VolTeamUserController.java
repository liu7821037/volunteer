package com.bjb.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolTeamUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolTeamUser;
import com.bjb.service.VolTeamUserService;

@RestController
@RequestMapping("/TUser")
public class VolTeamUserController {

	@Resource
	private VolTeamUserService service;
	@Resource
	private VolTeamUserDao userDao;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolTeamUser> getList(VolTeamUser user) throws SQLException{
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return service.getList(user, currentPage, pageSize);
	}
	
	//新增
	@RequestMapping("/add")
	public int add() throws Exception{
		VolTeamUser user = new VolTeamUser();
		user.setAreaId(Integer.parseInt(request.getParameter("area_id")));
		user.setCaptainTel(request.getParameter("captainTel"));
		user.setCaptainEmail(request.getParameter("captainEmail"));
		user.setContactorMobile(request.getParameter("contactorMobile"));
		user.setContactorName(request.getParameter("contactorName"));
		user.setContactorQQ(request.getParameter("contactorQQ"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		user.setCreateDate(sdf.parse(request.getParameter("createDate")));
		user.setRegistDate(new Date());
		user.setRegistType(Integer.parseInt(request.getParameter("registType")));
		user.setServiceTime(Integer.parseInt(request.getParameter("serviceTime")));
		user.setServiceTypeId(Integer.parseInt(request.getParameter("serviceTypeId")));
		user.setStarId(Integer.parseInt(request.getParameter("starId")));
		user.setTeamAddress(request.getParameter("teamAddress"));
		user.setTeamName(request.getParameter("teamName"));
		user.setTeamNumber(Integer.parseInt(request.getParameter("teamNumber")));
		user.setTeamType(Integer.parseInt(request.getParameter("teamType")));
		user.setTeamUnitName(request.getParameter("teamUnitName"));
		user.setTeamZipCode(request.getParameter("teamZipCode"));
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		return userDao.insert(user);
	}
	
	//查单条
	@RequestMapping("/findById/{id}")
	public VolTeamUser findById(@PathVariable("id") int id) throws SQLException{
		return userDao.findById(id);
	}
	
	//删除
	@RequestMapping("/del")
	public int del() throws SQLException{
		return userDao.delete(Integer.parseInt(request.getParameter("id")));
	}
}
