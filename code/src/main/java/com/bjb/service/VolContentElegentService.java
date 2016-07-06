package com.bjb.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolElegantDemeanourDao;
import com.bjb.dao.VolTeamUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolElegantDemeanour;
import com.bjb.entity.VolTeamUser;
import com.bjb.entity.VolVolunteerUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolContentElegentService extends BasicService{
	
	@Resource
	private VolElegantDemeanourDao volelegantdemeanourdao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolVolunteerUserDao vuserDao;
	@Resource
	private VolTeamUserDao tuserDao;
	
	public boolean deletElegantById(int id) throws SQLException{
		boolean flag = false;
		if(id>0){
			VolElegantDemeanour elegant = volelegantdemeanourdao.findById(id);
			if(elegant!=null){
				elegant.setAuditTypeId(2);
				volelegantdemeanourdao.update(elegant);
				flag = true;
			}
		}
		return flag;
	}

	public Page<VolElegantDemeanour> getList(VolElegantDemeanour elegant,
			int currentPage, int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		List<VolElegantDemeanour> rList = volelegantdemeanourdao.findByDto(elegant);
		Page<VolElegantDemeanour> page = findByPage(rList);
		return page;
	}

	public VolElegantDemeanour findById(int id) throws SQLException {
		VolElegantDemeanour elegant = null;
		if(id>0){
			elegant = volelegantdemeanourdao.findById(id);
			if(elegant.getType()==1){
				VolVolunteerUser user = new VolVolunteerUser();
				user.setUserId(elegant.getCreatorId());
				List<VolVolunteerUser> list = vuserDao.findByDto(user);
				if(list.size()>0){
					elegant.setUserName(list.get(0).getFullName());
				}
			}else{
				VolTeamUser user = new VolTeamUser();
				user.setUserId(elegant.getCreatorId());
				List<VolTeamUser> list = tuserDao.findByDto(user);
				if(list.size()>0){
					elegant.setUserName(list.get(0).getTeamName());
				}
			}
			elegant.setReadNums(elegant.getReadNums()+1);
			elegant.setUpdateDate(new Date());
			volelegantdemeanourdao.update(elegant);
		}
		return elegant;
	}

	public List<VolElegantDemeanour> getListByLimit(int pageSize) throws SQLException {
		VolElegantDemeanour elegant = new VolElegantDemeanour();
		PageHelper.startPage(1, pageSize);
		List<VolElegantDemeanour> list = volelegantdemeanourdao.findByDto(elegant);
		return list;
	}
	
}
