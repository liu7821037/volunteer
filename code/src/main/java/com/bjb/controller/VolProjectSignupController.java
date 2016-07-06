package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.common.controller.BaseController;
import com.bjb.dao.VolProjectCountDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolPushMessageDao;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolProjectCount;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolPushMessage;
import com.bjb.entity.VolServiceProject;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.service.VolProjectSignupService;
import com.bjb.util.MessageSettings;

@RestController
@RequestMapping("/enroll")
public class VolProjectSignupController extends BaseController{

	@Resource
	private VolProjectSignupDao enrollDao;
	@Resource
	private VolPushMessageDao enrollDao1;
	@Resource
	private VolProjectCountDao countDao;
	@Resource
	private VolServiceProjectDao volserviceprojectDao;
	@Resource
	private VolVolunteerUserDao volvolunteeruserDao;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	@Resource
	private VolProjectSignupService service;
	
	//获取列表
	@RequestMapping("/getList")
	public ReturnJsonObject getList(VolProjectSignup up) throws SQLException{
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
		Page<VolProjectSignup> page = service.getList(up, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	@RequestMapping("/getById/{id}")
	public ReturnJsonObject getById(@PathVariable("id")int id) throws SQLException{
		VolProjectSignup ps = service.getById(id);
		if(ps != null){
			return new ReturnJsonObject(ps);
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	//录用
	@RequestMapping("/employ")
	@Transactional
	public ReturnJsonObject employ() throws SQLException{
		int userId = Integer.parseInt(request.getParameter("userId"));
		VolProjectSignup up = enrollDao.findById(Integer.parseInt(request.getParameter("id")));
		VolServiceProject sp = volserviceprojectDao.findById(Integer.parseInt(request.getParameter("projectId")));
		VolVolunteerUser user = new VolVolunteerUser();
		user.setUserId(userId);
		List<VolVolunteerUser> list = volvolunteeruserDao.findByDto(user);
		user = list.get(0);
		int time = 0;
		if(user.getServiceTime() == null){
			time = 0;
		}else{
			time = user.getServiceTime();	
		}
		Date sdate = sp.getProjectStartDate();
		Date edate = sp.getProjectEndDate();
		long a = (edate.getTime() - sdate.getTime()) / 1000 / 60 / 60;
		int time1 = (int) (time + a) ;
		user.setServiceTime(time1);
		int j = volvolunteeruserDao.update(user);
		up.setSignUpStutas(Integer.parseInt(request.getParameter("signUpStutas")));
		int i = enrollDao.update(up);
		if(i >0){
			VolPushMessage pm = new VolPushMessage();
			pm.setProjectId(up.getProjectId());
			pm.setVolunteerId(up.getVolunteerId());
			pm.setMessageTitle(sp.getProjectTitle());
			pm.setMessageContent("恭喜你已经被录用");
			pm.setReadOrNot(0);
			pm.setPushDate(new Date());
			enrollDao1.insert(pm);
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	//拒绝
	@RequestMapping("/refuse")
	@Transactional
	public ReturnJsonObject refuse() throws SQLException{
		VolProjectSignup up = enrollDao.findById(Integer.parseInt(request.getParameter("id")));
		up.setSignUpStutas(Integer.parseInt(request.getParameter("signUpStutas")));
		up.setGetScore(0);
		up.setRefuseReason(request.getParameter("messageContent"));
		VolPushMessage pm = new VolPushMessage();
		pm.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		pm.setVolunteerId(Integer.parseInt(request.getParameter("volunteerId")));
		pm.setMessageTitle(request.getParameter("messageTitle"));
		pm.setMessageContent(request.getParameter("messageContent"));
		pm.setReadOrNot(0);
		pm.setPushDate(new Date());
		int i = enrollDao.update(up);
		int j = 0;
		if(i > 0){
			j = enrollDao1.insert(pm);
		}
		if(j > 0){
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
		
	}
	
	//评价
	@RequestMapping("/evaluate")
	@Transactional
	public ReturnJsonObject evaluate() throws SQLException{
		VolProjectSignup up = enrollDao.findById(Integer.parseInt(request.getParameter("id")));
		up.setSignUpStutas(Integer.parseInt(request.getParameter("signUpStutas")));
		up.setSignId(Integer.parseInt(request.getParameter("signId")));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		VolServiceProject vup = new VolServiceProject();
		vup = volserviceprojectDao.findById(projectId);
		int score = vup.getProjectScore();
		up.setGetScore(score);
		int i = enrollDao.update(up);
		if(i > 0){
			VolProjectCount count = countDao.findById(up.getProjectId());
			if(count!=null){
				count.setJoinNums(count.getJoinNums()+1);
				count.setUpdateDate(new Date());
				countDao.update(count);
			}
			VolPushMessage pm = new VolPushMessage();
			pm.setProjectId(up.getProjectId());
			pm.setVolunteerId(up.getVolunteerId());
			pm.setMessageTitle(vup.getProjectTitle());
			pm.setMessageContent("恭喜你评价成功");
			pm.setReadOrNot(0);
			pm.setPushDate(new Date());
			enrollDao1.insert(pm);
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	@RequestMapping("/countByDto")
	public int countByDto(VolProjectSignup up) throws SQLException{
		int count = enrollDao.countByDto(up);
		return count;
	}
	
	@RequestMapping("/getByDto")
	public List<VolProjectSignup> getByDto(VolProjectSignup up) throws SQLException{
		return service.getByDto(up);
	}
	
	@RequestMapping("/enroll")
	public ReturnJsonObject enroll(VolProjectSignup up) throws SQLException{
		VolServiceProject list1 = volserviceprojectDao.findById(up.getProjectId());
		int list2 = enrollDao.count1(up);
		int list3 = list1.getProjectRecruitment();
		if(list2 >= list3){
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_011"));
		}
		List<VolProjectSignup> list = enrollDao.findByDto(up);
		if(list.size()<1){
			up.setSignUpDate(new Date());
			up.setSignUpStutas(100);
			up.setSignUpType(98);
			int i = enrollDao.insert(up);
			if(i>0){
				VolProjectCount count = countDao.findById(up.getProjectId());
				if(count!=null){
					count.setJoinNums(count.getJoinNums()+1);
					count.setUpdateDate(new Date());
					countDao.update(count);
				}
				return new ReturnJsonObject();
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
			}
		}
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_009"));
	}
	
	@RequestMapping("/cancelEnroll")
	public ReturnJsonObject cancelEnroll(VolProjectSignup up) throws SQLException{
		List<VolProjectSignup> list = enrollDao.findByDto(up);
		if(list.size()>0){
			if(list.get(0).getSignUpStutas()==101){
				return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_008"));
			}else if(list.get(0).getSignUpStutas()==102){
				return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_013"));
			}else{
				VolProjectCount count = countDao.findById(up.getProjectId());
				if(count!=null){
					count.setJoinNums(count.getJoinNums()-1);
					count.setUpdateDate(new Date());
					countDao.update(count);
				}
				enrollDao.delete(list.get(0).getId());
				return new ReturnJsonObject();
			}
		}
		return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_008"));
	}
}
