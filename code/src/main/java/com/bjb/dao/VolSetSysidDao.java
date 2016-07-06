package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolSetSysid;

@Repository(value="volSetSysidDao")
public interface VolSetSysidDao extends BasicDao<VolSetSysid> {
	public List<VolSetSysid> findByDto(VolSetSysid volsetsysid) throws SQLException;
}
