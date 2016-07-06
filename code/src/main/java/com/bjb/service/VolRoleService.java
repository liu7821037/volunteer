package com.bjb.service;

import java.sql.SQLException;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolRoleDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolRole;
import com.github.pagehelper.PageHelper;

@Service
public class VolRoleService extends BasicService{

	@Resource
	private VolRoleDao roleDao;
	
	public int addRole(VolRole role) throws SQLException{
		role.setPid(0);
		role.setStatus(1);
		return roleDao.insert(role);
	}

	public Page<VolRole> getList(VolRole role, int currentPage, int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		Page<VolRole> page = findByPage(roleDao.findByDto(role));
		return page;
	}
}
