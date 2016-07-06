package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.dao.VolOrganizationUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolOrganizationUser;
import com.bjb.service.VolOrganizationUserService;

@RestController
@RequestMapping("/OUser")
public class VolOrganizationUserController {

	@Resource
	private VolOrganizationUserService service;
	@Resource
	private VolOrganizationUserDao userDao;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolOrganizationUser> getList() throws SQLException{
		String name = request.getParameter("name");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return service.getList(name, currentPage, pageSize);
	}
	
	//新增
	@RequestMapping("/add")
	public int add() throws SQLException{
		VolOrganizationUser user = new VolOrganizationUser();
		user.setOrganizationUserPhone(request.getParameter("organizationUserPhone"));
		user.setOrganizationUserGender(Integer.parseInt(request.getParameter("organizationUserGender")));
		user.setOrganizationArea(request.getParameter("organizationArea"));
		user.setRegisterDate(new Date());
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		user.setOrganizationId(Integer.parseInt(request.getParameter("organizationId")));
		return userDao.insert(user);
	}
	
	//更新用户权限
	@RequestMapping("/upRole")
	public int upRole() throws SQLException{
		VolOrganizationUser user = new VolOrganizationUser();
		user.setUserId(Integer.parseInt(request.getParameter("user_id")));
		user = userDao.findByDto(user).get(0);
		user.setRoleId(Integer.parseInt(request.getParameter("role_id")));
		return userDao.update(user);
	}
	
	//修改用户头像
	@RequestMapping("/upimg")
	public int upImg() throws SQLException{
		VolOrganizationUser user = new VolOrganizationUser();
		user.setUserId(Integer.parseInt(request.getParameter("id")));
		user = userDao.findByDto(user).get(0);
		user.setOrganizationUserPortrait(request.getParameter("organizationUserPortrait"));
		return userDao.update(user);
	}
	
	//根据userId查单条信息
	@RequestMapping("/findByUserId/{userId}")
	public VolOrganizationUser findByUserId(@PathVariable("userId") int userId) throws SQLException{
		VolOrganizationUser user = new VolOrganizationUser();
		user.setUserId(userId);
		if(userDao.findByDto(user).size()>0){
			return userDao.findByDto(user).get(0);
		}else{
			return null;
		}
	}
	
	//更新用户信息
	@RequestMapping("/up")
	public int up() throws SQLException{
		VolOrganizationUser user = new VolOrganizationUser();
		user.setUserId(Integer.parseInt(request.getParameter("id")));
		user = userDao.findByDto(user).get(0);
		user.setOrganizationUserPhone(request.getParameter("organizationUserPhone"));
		user.setOrganizationUserGender(Integer.parseInt(request.getParameter("organizationUserGender")));
		user.setOrganizationArea(request.getParameter("organizationArea"));
		user.setOrganizationUserEmail(request.getParameter("organizationUserEmail"));
		user.setUpdateDate(new Date());
		return userDao.update(user);
		
	}
}
