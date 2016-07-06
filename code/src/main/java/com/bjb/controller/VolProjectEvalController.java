package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolEvalutionDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolEvalution;
import com.bjb.service.VolProjectEvalService;

@RestController
@RequestMapping("/projecteval")
public class VolProjectEvalController {
	
	@Resource
	VolEvalutionDao eDao;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	@Resource
	VolProjectEvalService volprojecteval;
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolEvalution> getList() throws SQLException{
		String name = request.getParameter("name");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return volprojecteval.getList(name, currentPage, pageSize);
	}
	
	@RequestMapping("/getEvalById/{id}")
	public VolEvalution getEvalById(@PathVariable("id") int id) throws SQLException{
		return volprojecteval.getEvalutionById(id);
	}
	
	//新增
	@RequestMapping("/add")
	public int add(VolEvalution e) throws SQLException{
		e.setEvalutionDate(new Date());
		return eDao.insert(e);
	}
}
