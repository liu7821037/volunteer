package com.bjb.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolEvalutionDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolEvalution;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolServiceProject;
import com.bjb.entity.VolVolunteerUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolProjectSignupService extends BasicService{

	@Resource
	private VolProjectSignupDao enrollDao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolVolunteerUserDao userDao;
	@Resource
	private VolServiceProjectDao projectDao;
	@Resource
	private VolProjectSignupDao volprojectsignupDao;
	@Resource
	private VolEvalutionDao eDao;

	public Page<VolProjectSignup> getList(VolProjectSignup ups, int currentPage,
			int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		List<VolProjectSignup> rList = enrollDao.findByDto(ups);
		Page<VolProjectSignup> page = findByPage(rList);
		return page;
	}

	public VolProjectSignup getById(int id) throws SQLException {
		VolProjectSignup up = enrollDao.findById(id);
		VolVolunteerUser user = new VolVolunteerUser();
		user.setUserId(up.getVolunteerId());
		List<VolVolunteerUser> userList = userDao.findByDto(user);
		if(userList.size()>0){
			up.setUserName(userList.get(0).getFullName());
		}
		VolServiceProject project = projectDao.findById(up.getProjectId());
		if(project != null){
			up.setProjectName(project.getProjectTitle());
		}
		VolEvalution e = new VolEvalution();
		e.setProjectId(up.getProjectId());
		e.setVolunteerId(up.getVolunteerId());
		List<VolEvalution> eList = eDao.findByDto(e);
		if(eList.size()>0){
			VolBasicData data = dataDao.findById(eList.get(0).getStarId());
			if(data != null){
				up.setStarName(data.getDataName());
			}
		}
		return up;
	}

	public List<VolProjectSignup> getByDto(VolProjectSignup up) throws SQLException {
		List<VolProjectSignup> list = enrollDao.findByDto(up);
		List<VolProjectSignup> l = new ArrayList<VolProjectSignup>();
		for(VolProjectSignup enroll:list){
			VolVolunteerUser user = new VolVolunteerUser();
			user.setUserId(enroll.getVolunteerId());
			List<VolVolunteerUser> userList = userDao.findByDto(user);
			if(userList.size()>0){
				enroll.setUserName(userList.get(0).getFullName());
				enroll.setHeadPortrait(userList.get(0).getHeadPortrait());
			}
			l.add(enroll);
		}
		return l;
	}

	public List<VolProjectSignup> getProjectByName(VolProjectSignup up) throws SQLException, ParseException {
		List<VolProjectSignup> list = volprojectsignupDao.findByDto1(up);
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date smdate = time.parse(time.format(new Date()));
		for(int i=0;i<list.size();i++){
			if(list.get(i).getSignUpStutas() == 102){
				list.remove(i);
			}
			Date bdate = time.parse(time.format(list.get(i).getSignUpDate()));
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(smdate); 
			int time1 = (int) cal.getTimeInMillis(); 
			cal.setTime(bdate); 
			int time2 = (int) cal.getTimeInMillis(); 
			int time3 = (time1-time2)/1000;
		    if(time3<60){
		    	list.get(i).setTime("刚刚");
		    }else if(time3<3600){
		    	int a = time3/60;
		    	String stime = a+"分钟前";
		    	list.get(i).setTime(stime);
		    }else if(time3<24*3600){
		    	int a = time3/3600;
		    	String stime = a+"小时前";
		    	list.get(i).setTime(stime);
		    }else{
		    	int a = time3/(24*3600);
		    	String stime = a+"天前";
		    	list.get(i).setTime(stime);
		    }
		} 
		
		return list;
	}
	
	
}
