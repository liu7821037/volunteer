package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolEvalutionDao;
import com.bjb.dao.VolOrganizationDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolEvalution;
import com.bjb.entity.VolOrganization;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolServiceProject;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolVolunteerUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolProjectEvalService extends BasicService{

	@Resource
	private VolEvalutionDao volevalutiondao;
	@Resource
	private VolBasicDataDao volbasicdatadao;
	@Resource
	private VolServiceProjectDao volserviceprojectdao;
	@Resource
	private VolVolunteerUserDao volvolunteeruserdao;
	@Resource
	private VolOrganizationDao volorganization;
	@Resource
	private VolProjectSignupDao volprojectsignupdao;
	@Resource
	private VolUserDao userDao;
	
	public Page<VolEvalution> getList(String name, int currentPage, int pageSize) throws SQLException {
		List<VolEvalution> list = new ArrayList<VolEvalution>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolEvalution> rList = volevalutiondao.findListByName(name);
		Page<VolEvalution> page = findByPage(rList);
		for(VolEvalution up:page.getDataList()){
			VolServiceProject project = volserviceprojectdao.findById(up.getProjectId());
			if(project != null){
				up.setProjectName(project.getProjectTitle());
			}
			VolVolunteerUser user = new VolVolunteerUser();
			user.setUserId(up.getVolunteerId());
			List<VolVolunteerUser> userList = volvolunteeruserdao.findByDto(user);
			if(userList.size()>0){
				up.setVolunteerName(userList.get(0).getFullName());
			}
			VolBasicData data = volbasicdatadao.findById(up.getStarId());
			if(data != null){
				up.setStarName(data.getDataName());
			}
			VolUser user1 = userDao.findById(up.getEvalutionAuditor());
			if(user1 != null){
				up.setEvalutionName(user1.getUserCode());
			}
			VolOrganization organization = volorganization.findById(up.getOrganizationId());
			if(organization != null){
				up.setOrganizationName(organization.getOrganizationName());
			}
			list.add(up);				
		}
		page.setDataList(list);
		return page;
	}
	
	//根据projectId获得团队详情
	public VolEvalution getEvalutionById(int id) throws SQLException{
		
		VolEvalution eval = volevalutiondao.findById(id);
		VolServiceProject project = volserviceprojectdao.findById(eval.getProjectId());
		if(project != null){
			eval.setProjectName(project.getProjectTitle());
		}
		VolVolunteerUser user = new VolVolunteerUser();
		user.setUserId(eval.getVolunteerId());
		List<VolVolunteerUser> userList = volvolunteeruserdao.findByDto(user);
		if(userList.size()>0){
			eval.setVolunteerName(userList.get(0).getFullName());
		}
		VolBasicData data = volbasicdatadao.findById(eval.getStarId());
		if(data != null){
			eval.setStarName(data.getDataName());
		}
		VolUser user1 = userDao.findById(eval.getEvalutionAuditor());
		if(user1 != null){
			eval.setEvalutionName(user1.getUserCode());
		}
		VolOrganization organization = volorganization.findById(eval.getOrganizationId());
		if(organization != null){
			eval.setOrganizationName(organization.getOrganizationName());
		}
		VolProjectSignup signup = new VolProjectSignup();
		signup.setProjectId(eval.getProjectId());
		signup.setVolunteerId(eval.getVolunteerId());
		List<VolProjectSignup> eList = volprojectsignupdao.findByDto(signup);
		if(eList.size()>0){
			eval.setGetScore(eList.get(0).getGetScore());
		}
		return eval;
		}
}
