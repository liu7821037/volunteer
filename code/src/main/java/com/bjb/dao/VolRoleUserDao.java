package com.bjb.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolRoleUser;

@Repository(value="volRoleUserDao")
public interface VolRoleUserDao extends BasicDao<VolRoleUser> {
	
	public int delete(String id) throws SQLException;
}
