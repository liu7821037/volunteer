package com.bjb.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolElegantDemeanourDao;
import com.bjb.dao.VolProjectCountDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.dao.VolSetSysidDao;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolElegantDemeanour;
import com.bjb.entity.VolProjectCount;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolServiceProject;
import com.bjb.entity.VolSetSysid;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.service.VolOutwardService;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;
import com.tools.HttpRequest;

@RestController
@RequestMapping("/outward")
public class VolOutwardController {

	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Resource
	private VolUserDao userDao;
	@Resource
	private VolVolunteerUserDao voluserDao;
	@Resource
	private VolSetSysidDao volsetsysidDao;
	@Resource
	private VolServiceProjectDao projectDao;
	@Resource
	private VolProjectSignupDao volprojectsignupDao;
	@Resource
	private VolProjectCountDao volprojectcountDao;
	@Resource
	private VolElegantDemeanourDao volelegantdemeanourDao;
	@Resource
	private VolAreaDao areaDao;
	@Resource
	private VolOutwardService voloutwardservice;
	
	//获取token
	@RequestMapping("/gettoken")
	public ReturnJsonObject gettoken(@RequestBody VolUser user) throws SQLException{
		if(user.getUserCode() == null){
			return new ReturnJsonObject("缺少参数userCode");
		}
		if(user.getUserPwd() == null){
			return new ReturnJsonObject("缺少参数userPwd");
		}
		return voloutwardservice.gettoken(user);
	}
	
	//发布项目
	@RequestMapping("/addproject")
	@Transactional
	public ReturnJsonObject addproject(@RequestBody VolServiceProject project) throws SQLException, ParseException, UnsupportedEncodingException{
		if(project.getToken() == null){
			return new ReturnJsonObject("缺少参数token");
		}
		if(project.getId() == null){
			return new ReturnJsonObject("缺少参数id");
		}
		if(project.getProjectTitle() == null){
			return new ReturnJsonObject("缺少参数ProjectTitle");
		}
		if(project.getAreaCid() == null){
			return new ReturnJsonObject("缺少参数area_cid");
		}
		if(project.getAreaPid() == null){
			return new ReturnJsonObject("缺少参数area_pid");
		}
		if(project.getProjectTypeId() == null){
			return new ReturnJsonObject("缺少参数projectTypeId");
		}
		if(project.getProjectServiceObject() == null){
			return new ReturnJsonObject("缺少参数projectServiceObject");
		}
		if(project.getProjectRecruitment() == null){
			return new ReturnJsonObject("缺少参数projectRecruitment");
		}
		if(project.getProjectOrganizer() == null){
			return new ReturnJsonObject("缺少参数projectOrganizer");
		}
		if(project.getDetail() == null){
			return new ReturnJsonObject("缺少参数detail");
		}
		if(project.getProjectEndDate1() == null){
			return new ReturnJsonObject("缺少参数projectEndDate");
		}
		if(project.getProjectEnrrolEndDate1() == null){
			return new ReturnJsonObject("缺少参数projectEnrrolEndDate");
		}
		if(project.getProjectStartDate1() == null){
			return new ReturnJsonObject("缺少参数projectStartDate");
		}
		if(project.getProjectScore() == null){
			return new ReturnJsonObject("缺少参数projectScore");
		}
		if(project.getIstop() == null){
			return new ReturnJsonObject("缺少参数istop");
		}
		return voloutwardservice.addproject(project);
	}
	
	//发布风采
	@RequestMapping("/addelegant")
	@Transactional
	public ReturnJsonObject addelegant(@RequestBody VolElegantDemeanour elegant) throws SQLException, UnsupportedEncodingException{
		if(elegant.getToken() == null){
			return new ReturnJsonObject("缺少参数token");
		}
		if(elegant.getId() == null){
			return new ReturnJsonObject("缺少参数id");
		}
		if(elegant.getElegantTitle() == null){
			return new ReturnJsonObject("缺少参数elegantTitle");
		}
		if(elegant.getType() == null){
			return new ReturnJsonObject("缺少参数type");
		}
		if(elegant.getDetail() == null){
			return new ReturnJsonObject("缺少参数detail");
		}
		if(elegant.getAuditTypeId() == null){
			return new ReturnJsonObject("缺少参数auditTypeId");
		}
		return voloutwardservice.addelegant(elegant);
	}
	
	//添加项目参与数据
	@RequestMapping("/addcount")
	public ReturnJsonObject addcount(@RequestBody VolProjectCount volprojectcount) throws SQLException, UnsupportedEncodingException{
		if(volprojectcount.getToken() == null){
			return new ReturnJsonObject("缺少参数token");
		}
		if(volprojectcount.getId() == null){
			return new ReturnJsonObject("缺少参数id");
		}
		return voloutwardservice.addcount(volprojectcount);
	}
	
	//报名信息一览取得
	@RequestMapping("/getlist")
	public ReturnJsonObject getlist() throws SQLException, UnsupportedEncodingException{
		if(StringUnit.isNullOrEmpty(request.getParameter("token"))){
			return new ReturnJsonObject("缺少参数token");
		}
		if(StringUnit.isNullOrEmpty(request.getParameter("projectId"))){
			return new ReturnJsonObject("缺少参数id");
		}
		String token = request.getParameter("token");
		int projectid = Integer.parseInt(request.getParameter("projectId"));
		return voloutwardservice.getlist(token, projectid);
	}
}
