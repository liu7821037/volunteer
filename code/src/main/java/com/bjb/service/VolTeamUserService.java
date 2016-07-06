package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolTeamUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolTeamUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolTeamUserService extends BasicService{

	@Resource
	private VolTeamUserDao userDao;
	@Resource
	private VolBasicDataDao dataDao;

	public Page<VolTeamUser> getList(VolTeamUser user, int currentPage,
			int pageSize) throws SQLException {
		List<VolTeamUser> list = new ArrayList<VolTeamUser>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolTeamUser> userList = userDao.findByDto(user);
		Page<VolTeamUser> page = findByPage(userList);
		for(VolTeamUser u:page.getDataList()){
			//团体类型
			VolBasicData data = dataDao.findById(u.getTeamType());
			if(data!=null){
				u.setTeamTypeName(data.getDataName());				
			}
			//服务类型
			VolBasicData data1 = dataDao.findById(u.getServiceTypeId());
			if(data1!=null){
				u.setServiceTypeName(data1.getDataName());				
			}
			list.add(u);
		}
		page.setDataList(list);
		return page;
	}
}
