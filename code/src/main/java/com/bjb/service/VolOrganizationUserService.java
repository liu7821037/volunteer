package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolOrganizationDao;
import com.bjb.dao.VolOrganizationUserDao;
import com.bjb.dao.VolRoleDao;
import com.bjb.dao.VolUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolOrganization;
import com.bjb.entity.VolOrganizationUser;
import com.bjb.entity.VolRole;
import com.bjb.entity.VolUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolOrganizationUserService extends BasicService{

	@Resource
	private VolOrganizationUserDao userDao;
	@Resource
	private VolRoleDao roleDao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolOrganizationDao ODao;
	@Resource
	private VolUserDao uDao;
	
	public Page<VolOrganizationUser> getList(String name,Integer currentPage,Integer pageSize) throws SQLException{
		List<VolOrganizationUser> list = new ArrayList<VolOrganizationUser>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolOrganizationUser> userList = userDao.findListByName(name);
		Page<VolOrganizationUser> page = findByPage(userList);
		for(VolOrganizationUser u:page.getDataList()){
			//角色名
			VolRole role = roleDao.findById(u.getRoleId());
			if(role==null){
				u.setRoleName("尚未设置权限");
			}else{
				u.setRoleName(role.getName());
			}
			//性别
			VolBasicData data = dataDao.findById(u.getOrganizationUserGender());
			if(data!=null){
				u.setSexName(data.getDataName());				
			}
			//场馆名
			VolOrganization o = ODao.findById(u.getOrganizationId());
			if(o!=null){
				u.setOrganizationName(o.getOrganizationName());
			}
			//状态
			VolUser u1 = uDao.findById(u.getUserId());
			if(u1!=null){
				u.setUserStatus(u1.getUserStatus());
				u.setUserCode(u1.getUserCode());
			}
			list.add(u);
		}
		page.setDataList(list);
		return page;
	} 
}
