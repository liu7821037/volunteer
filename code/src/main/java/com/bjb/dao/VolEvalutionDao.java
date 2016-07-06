﻿package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bjb.entity.VolEvalution;

@Repository(value="volEvalutionDao")
public interface VolEvalutionDao extends BasicDao<VolEvalution> {
	public List<VolEvalution> findListByName(@Param("name")String name) throws SQLException;;
}
