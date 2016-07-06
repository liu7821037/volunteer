package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bjb.entity.VolNode;

@Repository(value="volNodeDao")
public interface VolNodeDao extends BasicDao<VolNode> {
	public List<VolNode> findByUserId(@Param("userId")Integer userId,@Param("pid")Integer pid,@Param("level")Integer level) throws SQLException;
}
