package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolVolunteerUser;

@Repository(value="volVolunteerUserDao")
public interface VolVolunteerUserDao extends BasicDao<VolVolunteerUser> {
	public List<VolVolunteerUser> findlist() throws SQLException;
}
