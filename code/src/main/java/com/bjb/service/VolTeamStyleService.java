package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolTeamStyleDao;
import com.bjb.dao.VolTeamUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolTeamStyle;
import com.bjb.entity.VolTeamUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolTeamStyleService extends BasicService{
	@Resource
	private VolTeamStyleDao volTeamStyleDao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolAreaDao areaDao;
	@Resource
	private VolTeamUserDao teamUserDao;
	
	public boolean deletElegantById(int id) throws SQLException{
		volTeamStyleDao.delete(id);
		return true;
	}
	public Page<VolTeamStyle> getList(VolTeamStyle teamstyle,
			int currentPage, int pageSize) throws SQLException{
		List<VolTeamStyle> list = new ArrayList<VolTeamStyle>();
		PageHelper.startPage(currentPage,pageSize);
		List<VolTeamStyle> rList = volTeamStyleDao.findByDto(teamstyle);	
		Page<VolTeamStyle> page = findByPage(rList);
		for(VolTeamStyle team :page.getDataList()){
			VolBasicData data = dataDao.findById(team.getSerciveType());
			if(data != null){
				team.setTypeName(data.getDataName());
			}
			VolArea _data = areaDao.findById(team.getTeamArea());
			if(_data!=null){
				team.setArea(_data.getAreaName());
			}
			VolTeamUser teamUser = teamUserDao.findById(team.getStyleTeam());
			if(teamUser!= null){
				team.setTeam(teamUser.getTeamName());
			}
			
			list.add(team);
		}
		page.setDataList(list);
		
		return page;
	}
	public VolTeamStyle findById(int id) throws SQLException{
		VolTeamStyle teamstyle = null;
		if(id>0){
			teamstyle = volTeamStyleDao.findById(id);
			VolBasicData data = dataDao.findById(teamstyle.getSerciveType());
			VolTeamUser _team = teamUserDao.findById(teamstyle.getStyleTeam());
			VolArea _area = areaDao.findById(teamstyle.getTeamArea());
			if(data !=null){
				teamstyle.setTypeName(data.getDataName());
			}
			if(_team !=null){
				teamstyle.setTeam(_team.getTeamName());
			}
			if(_area!=null){
				teamstyle.setArea(_area.getAreaName());
			}
		}
		return teamstyle;
	}
	public List<VolTeamStyle> getListByLimit(int pageSize) throws SQLException{
		VolTeamStyle teamstyle = new VolTeamStyle();
		PageHelper.startPage(1,pageSize);
		List<VolTeamStyle> list = volTeamStyleDao.findByDto(teamstyle);
		return list;
	}
}
