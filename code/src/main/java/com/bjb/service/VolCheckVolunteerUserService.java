package com.bjb.service;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.VolVolunteerUser;

@Service
public class VolCheckVolunteerUserService {

	@Resource
	private VolVolunteerUserDao volvolunteeruserdao;
	/***
	 * 志愿者审核
	 */
	
	//根据userId获得举报内容
	public VolVolunteerUser findUserById(int id) throws SQLException{
		VolVolunteerUser user = volvolunteeruserdao.findById(id);
		return user;
	}
	//置1
	public boolean updateTrue(int id,int userId) throws SQLException{
		VolVolunteerUser user = volvolunteeruserdao.findById(id);
		user.setCheckStatus(1);
		user.setCheckId(userId);
		user.setCheckDate(new Date());
		volvolunteeruserdao.update(user);
		return true;
	}
	//置2
	public boolean updateFalse(int id,int userId) throws SQLException{
		VolVolunteerUser user = volvolunteeruserdao.findById(id);
		user.setCheckStatus(1);
		user.setCheckId(userId);
		user.setCheckDate(new Date());
		volvolunteeruserdao.update(user);
		return true;
	}
}
