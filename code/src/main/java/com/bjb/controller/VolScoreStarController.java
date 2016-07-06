package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolScoreStarDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolScoreStar;
import com.bjb.service.VolScoreStarService;

@RestController
@RequestMapping("/star")
public class VolScoreStarController {

	@Resource
	private VolScoreStarService service;
	@Resource
	private VolScoreStarDao starDao;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolScoreStar> getList() throws SQLException{
		VolScoreStar star = new VolScoreStar();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return service.getList(star, currentPage, pageSize);
	}
	
	//新增
	@RequestMapping("/add")
	public int add() throws SQLException{
		VolScoreStar star = new VolScoreStar();
		star.setCreateDate(new Date());
		star.setCreateId(Integer.parseInt(request.getParameter("createId")));
		star.setScoreNumber(Integer.parseInt(request.getParameter("scoreNumber")));
		star.setScoreTypeName(request.getParameter("scoreTypeName"));
		star.setScoreTypePic(request.getParameter("scoreTypePic"));
		return starDao.insert(star);
	}
	
	//根据Id查单条信息
	@RequestMapping("/findbyid/{id}")
	public VolScoreStar findById(@PathVariable("id") int id) throws SQLException{
		return starDao.findById(id);
	}
	
	//修改
	@RequestMapping("/up")
	public int upRole() throws SQLException{
		VolScoreStar star = findById(Integer.parseInt(request.getParameter("id")));
		star.setScoreNumber(Integer.parseInt(request.getParameter("scoreNumber")));
		star.setScoreTypeName(request.getParameter("scoreTypeName"));
		star.setScoreTypePic(request.getParameter("scoreTypePic"));
		return starDao.update(star);
	}
	
	//删除
	@RequestMapping("/del")
	public int delete() throws SQLException{
		return starDao.delete(Integer.parseInt(request.getParameter("id")));
	}
}
