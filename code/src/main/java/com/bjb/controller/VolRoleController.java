package com.bjb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolRoleDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolRole;
import com.bjb.service.VolRoleService;
import com.bjb.util.MessageSettings;

@RestController
@RequestMapping("/role")
public class VolRoleController {

	@Resource
	VolRoleDao roleDao;
	@Resource
	private VolRoleService roleService;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("/getList")
	public ReturnJsonObject getList() throws SQLException{
		VolRole role = new VolRole();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		Page<VolRole> page = roleService.getList(role, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	@RequestMapping("/all")
	public ReturnJsonObject all() throws SQLException{
		VolRole role = new VolRole();
		role.setStatus(1);
		List<VolRole> list = roleDao.findByDto(role);
		return new ReturnJsonObject(list);
	}
	
	@RequestMapping("/addRole")
	public ReturnJsonObject add(VolRole role) throws SQLException{
		int i = roleDao.insert(role);
		if(i > 0){
			return new ReturnJsonObject();
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	@RequestMapping("/findbyid/{id}")
	public ReturnJsonObject findById(@PathVariable("id") int id) throws SQLException{
//		response.addHeader("Access-Control-Allow-Origin:","*");
		VolRole role = roleDao.findById(id);
		return new ReturnJsonObject(role);
	}
	
	@RequestMapping("/upRole")
	public ReturnJsonObject upRole() throws SQLException{
		VolRole role = roleDao.findById(Integer.parseInt(request.getParameter("id")));
		role.setName(request.getParameter("name"));
		role.setRemark(request.getParameter("remark"));
		role.setStatus(Integer.parseInt(request.getParameter("status")));
		int i = roleDao.update(role);
		if(i > 0){
			return new ReturnJsonObject();
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	@RequestMapping("/del")
	public ReturnJsonObject delete() throws SQLException{
		int i = roleDao.delete(Integer.parseInt(request.getParameter("id")));
		if(i > 0){
			return new ReturnJsonObject();
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		} 
	}
}
