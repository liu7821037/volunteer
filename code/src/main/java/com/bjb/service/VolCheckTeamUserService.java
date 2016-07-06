package com.bjb.service;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolTeamUserDao;
import com.bjb.entity.VolTeamUser;

@Service
public class VolCheckTeamUserService {

	
	@Resource
	private VolTeamUserDao volteamuserdao;
	
	//根据teamId获得团队详情
	public VolTeamUser getTeamUserById(int id) throws SQLException{
		VolTeamUser team = volteamuserdao.findById(id);
		return team;
	}
	//置1
	public boolean updateTrue(int id,int userId) throws SQLException{
		VolTeamUser team = volteamuserdao.findById(id);
		team.setCheckStatus("1");
		team.setCheckId(userId);
		team.setCheckDate(new Date());
		volteamuserdao.update(team);
		return true;
	}
	//置2
	public boolean updateFalse(int id,int userId) throws SQLException{
		VolTeamUser team = volteamuserdao.findById(id);
		team.setCheckStatus("2");
		team.setCheckId(userId);
		team.setCheckDate(new Date());
		volteamuserdao.update(team);
		return true;
	}
}
