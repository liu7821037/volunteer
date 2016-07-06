package com.bjb.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.common.controller.BaseController;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolServiceProject;
import com.bjb.service.VolProjectListService;
import com.bjb.service.VolProjectSignupService;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;
@RestController
@RequestMapping("/projectlist")
public class VolProjectListController extends BaseController{
	
	@Resource
	VolServiceProjectDao projectDao;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Resource
	private VolProjectListService volprojectlistservice;
	@Resource
	private VolProjectSignupService volprojectsignservice;
	
	@RequestMapping("/getAll")
	public List<VolServiceProject> getAll() throws SQLException{
		return projectDao.findAll();
	}
	
	//根据志愿者ID从数据库中检索出项目列表
	@RequestMapping("/getListByUserId")
	public ReturnJsonObject getListByUserId(VolServiceProject project) throws SQLException{
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
		Page<VolServiceProject> page = volprojectlistservice.getListByUserId(project, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolServiceProject> getList(VolServiceProject project) throws SQLException{
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
		return volprojectlistservice.getList(project, currentPage, pageSize);
	}
	
	//获取列表
	@RequestMapping("/getList1")
	public ReturnJsonObject getList1(VolServiceProject project) throws SQLException{
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
		Page<VolServiceProject> page = volprojectlistservice.getList1(project, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	@RequestMapping("/getListByLimit")
	public List<VolServiceProject> getListByLimit() throws SQLException{
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return volprojectlistservice.getListByLimit(pageSize);
	}
	
	//根据projectId查找
	@RequestMapping("/getById/{id}")
	public VolServiceProject getById(@PathVariable("id")  int id) throws SQLException{
		return projectDao.findById(id);
	}
	
	//根据projectId查找
	@RequestMapping("/getProjectById")
	public ReturnJsonObject getProjectById() throws SQLException{
		if(StringUnit.isNullOrEmpty(request.getParameter("id"))){
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_009"));
		}
		int id = Integer.parseInt(request.getParameter("id"));
		String userID = request.getParameter("userId");
		VolServiceProject project = volprojectlistservice.getProjectById(id,userID);
		if(project != null)
			return new ReturnJsonObject(project);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	//根据projectId查找报名人信息
	@RequestMapping("/getProjectByName")
	public ReturnJsonObject getProjectByName(VolProjectSignup up) throws SQLException, ParseException{
		List<VolProjectSignup> list = volprojectsignservice.getProjectByName(up);
		if(list.size()>0){
			return new ReturnJsonObject(list);
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
		}
			
	}
	
	//添加project
	@RequestMapping("/addProject")
	public ReturnJsonObject addProjectById(@RequestBody VolServiceProject project) throws SQLException, Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		project.setProjectEndDate(sdf.parse(project.getProjectEndDate1()));
		project.setProjectStartDate(sdf.parse(project.getProjectStartDate1()));
		project.setProjectEnrrolEndDate(sdf.parse(project.getProjectEnrrolEndDate1()));
		project.setProjectCover(StringUnit.getImgSrcByHtml(project.getDetail()));
		int i = volprojectlistservice.insert(project);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_003"));
	}
	
	//根据projectId删除
	@RequestMapping("/deletProjectById/{id}")
	public boolean deletProjectById(@PathVariable("id")  int id) throws SQLException{
		
		return volprojectlistservice.deletProjectById(id);
	}
	
	//根据projectId修改信息
	@RequestMapping("/updateProjectById")
	public ReturnJsonObject updatProjectById(@RequestBody VolServiceProject project) throws SQLException, Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		project.setProjectEndDate(sdf.parse(project.getProjectEndDate1()));
		project.setProjectStartDate(sdf.parse(project.getProjectStartDate1()));
		project.setProjectEnrrolEndDate(sdf.parse(project.getProjectEnrrolEndDate1()));
		project.setUpdateDate(new Date());
		int i = projectDao.updatePartial(project);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
	}
	
	//根据projectId修改封面
	@RequestMapping("/updateProjectpicture")
	public ReturnJsonObject updateProjectpicture(VolServiceProject project) throws SQLException, Exception{
		VolServiceProject project1 = projectDao.findById(project.getId());
		project1.setProjectCover(project.getProjectCover());
		int i = projectDao.update(project1);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
	}
	
	//置顶
	@RequestMapping("/toTop")
	public ReturnJsonObject toTop() throws SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		int i = volprojectlistservice.toTop(id);
		if(i == 0)
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_004"));
		else
			return new ReturnJsonObject();
	}
	
	//取消置顶
	@RequestMapping("/unTop")
	public ReturnJsonObject unTop() throws SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		int i = volprojectlistservice.unTop(id);
		if(i == 0)
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_005"));
		else
			return new ReturnJsonObject();
	}
}
