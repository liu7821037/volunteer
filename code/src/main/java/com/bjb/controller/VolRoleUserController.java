package com.bjb.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolRoleUserDao;
import com.bjb.entity.VolRoleUser;

@RestController
@RequestMapping("/ruser")
public class VolRoleUserController {

	@Resource
	private VolRoleUserDao ruDao;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	
	//根据userId查角色
	@RequestMapping("/findByUserId/{id}")
	public VolRoleUser findByUserId(@PathVariable("id") String id) throws SQLException{
		VolRoleUser ru = new VolRoleUser();
		ru.setUser_id(id);
		if(ruDao.findByDto(ru).size()>0){
			return ruDao.findByDto(ru).get(0);
		}else{
			return null;
		}
	}
	
	//新增角色用户
	@RequestMapping("/add")
	public int add() throws SQLException{
		VolRoleUser ru = new VolRoleUser();
		ru.setRole_id(Integer.parseInt(request.getParameter("role_id")));
		ru.setUser_id(request.getParameter("user_id"));
		return ruDao.insert(ru);
	}
	
	//删除角色用户
	@RequestMapping("/del")
	public int del() throws SQLException{
		return ruDao.delete(request.getParameter("id"));
	}
	
}
