package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bjb.entity.VolProjectSignup;

@Repository(value="volProjectSignupDao")
public interface VolProjectSignupDao extends BasicDao<VolProjectSignup> {
	public VolProjectSignup getScoreByProjectId(Integer id) throws SQLException;
	public List<VolProjectSignup> findListByName(@Param("name")String name) throws SQLException;
	public List<VolProjectSignup> findByDto1(VolProjectSignup up) throws SQLException;
	public List<VolProjectSignup> findByDto2(VolProjectSignup up) throws SQLException;
	public int count1(VolProjectSignup up) throws SQLException;
}
