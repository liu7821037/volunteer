package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolServiceProject;

@Repository(value="volServiceProjectDao")
public interface VolServiceProjectDao extends BasicDao<VolServiceProject> {
	public List<VolServiceProject> findByDto1(VolServiceProject project) throws SQLException;
	public List<VolServiceProject> findByUserId(Integer userId) throws SQLException;
	public List<VolServiceProject> findByDto3(VolServiceProject project) throws SQLException;
}
