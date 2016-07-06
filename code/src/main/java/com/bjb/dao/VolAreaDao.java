package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolArea;

@Repository(value="volAreaDao")
public interface VolAreaDao extends BasicDao<VolArea> {
	public List<VolArea> getAllCityList(VolArea area) throws SQLException;
}
