package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolTeamStyleDao;
import com.bjb.dao.VolTeamUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolTeamStyle;
import com.bjb.entity.VolTeamUser;
import com.bjb.service.VolTeamStyleService;

@RestController
@RequestMapping("teamstyle")
public class VolTeamStyleController {
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Resource
    private VolTeamStyleService volTeamStyleService; 
	@Resource
	private VolTeamStyleDao teamStyleDao;
	@Resource
	private VolTeamUserDao teamUserDao;
	
	@RequestMapping("/getList")
	public Page<VolTeamStyle> getList(VolTeamStyle teamstyle) throws SQLException{
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return volTeamStyleService.getList(teamstyle, currentPage, pageSize);
	}
    @RequestMapping("/getListByLimit")
	public List<VolTeamStyle>  getListByLimit() throws SQLException{
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return volTeamStyleService.getListByLimit(pageSize);
	}
    @RequestMapping("/findById/{id}")
    public VolTeamStyle findById(@PathVariable("id") int id) throws SQLException{
    	return volTeamStyleService.findById(id);
    }
    @RequestMapping("/updateTeamStyle")
    public int updateTeamStyle() throws SQLException{
    	VolTeamStyle teamstyle = new VolTeamStyle();
    	teamstyle.setId(Integer.parseInt(request.getParameter("id")));
    	teamstyle.setStyleTitle(request.getParameter("styleTitle"));
    	teamstyle.setStyleTeam(Integer.parseInt(request.getParameter("styleTeam")));
    	teamstyle.setTeamArea(Integer.parseInt(request.getParameter("teamArea")));
    	teamstyle.setSerciveType(Integer.parseInt(request.getParameter("serciveType")));
    	teamstyle.setTeamPhone(request.getParameter("teamPhone"));
    	teamstyle.setContent(request.getParameter("content"));
    	teamstyle.setPicture(request.getParameter("picture"));
    	teamstyle.setUpdateDate(new Date());
    	return teamStyleDao.update(teamstyle);
    }
    @RequestMapping("/addteamStyle")
    public int addteamStyle() throws SQLException{
    	VolTeamStyle teamStyle = new VolTeamStyle();    	
    	teamStyle.setStyleTitle(request.getParameter("styleTitle"));
    	teamStyle.setStyleTeam(Integer.parseInt(request.getParameter("styleTeam")));
    	teamStyle.setTeamPhone(request.getParameter("teamPhone"));
    	teamStyle.setCreatePeople(request.getParameter("createPeople"));
    	teamStyle.setTeamArea(Integer.parseInt(request.getParameter("teamArea")));
    	teamStyle.setSerciveType(Integer.parseInt(request.getParameter("serciveType")));
    	teamStyle.setPicture(request.getParameter("picture"));
    	teamStyle.setContent(request.getParameter("content"));
    	teamStyle.setCreateDate(new Date());
    	return teamStyleDao.insert(teamStyle);
    }
    @RequestMapping("/findteam")
    public List<VolTeamUser> findteam() throws SQLException{
    	VolTeamUser team = new VolTeamUser();
    	team.setCheckStatus(1+"");
    	return teamUserDao.findByDto(team);
    }
    
    @RequestMapping("/deletElegantById/{id}")
    public boolean delStyleById(@PathVariable("id") int id) throws SQLException{
    	return volTeamStyleService.deletElegantById(id);
    }
}
