package com.bjb.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.Constants;
import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.common.controller.BaseController;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.exception.AddException;
import com.bjb.service.VolVolunteerUserService;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;

@RestController
@RequestMapping("/VUser")
@Transactional
public class VolVolunteerUserController extends BaseController{

	@Autowired
	HttpSession session;
	@Resource
	VolVolunteerUserService service;
	@Resource
	VolVolunteerUserDao userDao;
	@Resource
	VolUserDao userDao1;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	
	//获取列表
	@RequestMapping("/getList")
	public ReturnJsonObject getList(VolVolunteerUser user) throws SQLException{
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
		Page<VolVolunteerUser> page = service.getList(user, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	//新增
	@RequestMapping("/add")
	@Transactional
	public ReturnJsonObject add(@RequestBody VolVolunteerUser user){
		int i = 0;
		String code = "MSG_ERROR_003";
		try {
			i = service.insert(user);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AddException e) {
			code= e.getCode();
			request.setAttribute("MSG_CODE", code);
			e.printStackTrace();
		}
		if(i>0){
			return new ReturnJsonObject(Constants.RETURN_CODE_1,MessageSettings.getValue("MSG_INFO_007"),null);
		}
		return new ReturnJsonObject(Constants.RETURN_CODE_0,MessageSettings.getValue(code),null);
	}
	
	@RequestMapping("/addUser")
	@Transactional
	public ReturnJsonObject addUser(VolUser user) throws SQLException{
		int i = service.addUser(user);
		if(i == -1)
			return new ReturnJsonObject(Constants.RETURN_CODE_0,MessageSettings.getValue("MSG_ERROR_007"),null);
		else if(i==0)
			return new ReturnJsonObject(Constants.RETURN_CODE_0,MessageSettings.getValue("MSG_ERROR_003"),null);
		else
			return new ReturnJsonObject(Constants.RETURN_CODE_1,MessageSettings.getValue("MSG_INFO_007"),null);
	}
	
	//局部字段更新
	@RequestMapping("/updatePartial")
	@Transactional
	public ReturnJsonObject updatePartial(@RequestBody VolVolunteerUser user) throws SQLException{
		VolUser suser = userDao1.findById(user.getUserId());
		VolVolunteerUser vuser = userDao.findById(user.getId());
		String uniqid = vuser.getOnlySign();
		if(!StringUnit.isNullOrEmpty(user.getOpwd())){
			String opwd = suser.getUserPwd();
			String pwd = StringUnit.MD5(user.getOpwd()).toLowerCase();
			if(!opwd.equals(pwd)){
				return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_012"));
			}
			String npwd = StringUnit.MD5(user.getNpwd()).toLowerCase();
			suser.setUserPwd(npwd);
			int j =userDao1.update(suser);
			if(j == 0){
				return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
			}
			user.setUser(suser);
		}
		return service.modifyUser(user,uniqid);
//		if(i>0)
//			return new ReturnJsonObject(Constants.RETURN_CODE_1,MessageSettings.getValue("MSG_INFO_007"),null);
//		else
//			return new ReturnJsonObject(Constants.RETURN_CODE_0,MessageSettings.getValue("MSG_ERROR_002"),null);
	}
	
	//更新头像
	@RequestMapping("/updatePicture")
	@Transactional
	public ReturnJsonObject updatePicture(VolVolunteerUser user) throws SQLException{
		VolVolunteerUser vuser = userDao.findById(user.getId());
		String uniqid = vuser.getOnlySign();
		return service.modifyUser(user,uniqid);
	}
	
	//查单条
	@RequestMapping("/findById/{id}")
	public ReturnJsonObject findById(@PathVariable("id") int id) throws SQLException{
		VolVolunteerUser user = userDao.findById(id);
		if(user != null)
			return new ReturnJsonObject(user);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	//根据userId查志愿者详细信息
	@RequestMapping("/findByUserId/{id}")
	public ReturnJsonObject findByUserId(@PathVariable("id") int id) throws SQLException{
		VolVolunteerUser user = service.findById(id);
		if(user != null)
			return new ReturnJsonObject(user);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	//删除
	@RequestMapping("/del")
	public int del() throws SQLException{
		return userDao.delete(Integer.parseInt(request.getParameter("id")));
	}
	
	//更新用户权限
		@RequestMapping("/upRole")
		public int upRole() throws SQLException{
			VolVolunteerUser user = new VolVolunteerUser();
			user.setUserId(Integer.parseInt(request.getParameter("user_id")));
			user = userDao.findByDto(user).get(0);
			user.setRoleId(Integer.parseInt(request.getParameter("role_id")));
			return userDao.update(user);
		}
}
