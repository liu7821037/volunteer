package com.bjb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolOrganizationDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolOrganization;
import com.bjb.entity.VolOrganizationUserRelation;
import com.bjb.service.VolOrganizationService;

@RestController
@RequestMapping("/organization")
public class VolOrganizationController {

	@Resource
	private VolOrganizationService service;
	@Resource
	private VolOrganizationDao venuesdao;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("/all")
	public List<VolOrganization> getAll() throws SQLException{
		return venuesdao.findAll();
	}
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolOrganization> getList(VolOrganization venues) throws SQLException{
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return service.getList(venues, currentPage, pageSize);
	}
	
	//根据organizationName判断场馆名称是否存在(用于注册时使用)
	@RequestMapping("/findIdByName/{name}")
	public int findId(@PathVariable("name") String name) throws SQLException{
		VolOrganization venues = new VolOrganization();
		venues.setOrganizationName(name);
		int id = 0;
		if(venuesdao.findListByName(venues).size()>0){
			id = venuesdao.findListByName(venues).get(0).getId();			
		}
		return id;
	}
	
	//新增场馆
	@RequestMapping("/addVenues")
	public int add() throws SQLException{
		VolOrganization venues = new VolOrganization();
		venues.setOrganizationName(request.getParameter("organizationName"));
		venues.setOrganizationArea(request.getParameter("organizationArea"));
		venues.setOrganizationAddress(request.getParameter("organizationAddress"));
		venues.setOrganizationHead(request.getParameter("organizationHead"));
		venues.setOrganizationHeadPhone(request.getParameter("organizationHeadPhone"));
		venues.setOrganizationEmail(request.getParameter("organizationEmail"));
		venues.setOrganizationZip(request.getParameter("organizationZip"));
		return venuesdao.insert(venues);
	}
	
	//根据ID查找场馆的信息
	@RequestMapping("/findById/{id}")
	public VolOrganization findById(@PathVariable("id") int id) throws SQLException{
		return venuesdao.findById(id);
	}
	
	//更新场馆信息
	@RequestMapping("/updateVenues")
	public int updateVenues() throws SQLException{
		VolOrganization venues = new VolOrganization();
		venues.setId(Integer.parseInt(request.getParameter("id")));
		venues.setOrganizationName(request.getParameter("organizationName"));
		venues.setOrganizationArea(request.getParameter("organizationArea"));
		venues.setOrganizationAddress(request.getParameter("organizationAddress"));
		venues.setOrganizationHead(request.getParameter("organizationHead"));
		venues.setOrganizationHeadPhone(request.getParameter("organizationHeadPhone"));
		venues.setOrganizationEmail(request.getParameter("organizationEmail"));
		venues.setOrganizationZip(request.getParameter("organizationZip"));
		return venuesdao.update(venues);
	}
	
	//删除
	@RequestMapping("/delVenues")
	public int delVenues() throws SQLException{
		return venuesdao.delete(Integer.parseInt(request.getParameter("id")));
	}
	
	//根据场馆Id和场馆用户(志愿者和场馆工作人员)名称查找
	@RequestMapping("/findVenuesUserPageById")
	public Page<VolOrganizationUserRelation> findVenuesUserPageById() throws SQLException{
		VolOrganizationUserRelation venuesUserRelation = new VolOrganizationUserRelation();
		venuesUserRelation.setOrganizationId(Integer.parseInt(request.getParameter("id")));
		venuesUserRelation.setUserName(request.getParameter("name"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return service.findUserPageByVenues(venuesUserRelation, currentPage, pageSize);
	}
	
	//删除
	@RequestMapping("/delOrganizationUserRelation")
	public int delOrganizationUserRelation() throws SQLException{
		return service.getVenuesUserRelationDao().delete(Integer.parseInt(request.getParameter("id")));
	}
	
}
