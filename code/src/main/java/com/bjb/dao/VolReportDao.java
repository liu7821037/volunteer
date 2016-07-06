package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bjb.entity.VolReport;

@Repository(value="volReportDao")
public interface VolReportDao extends BasicDao<VolReport> {

	public List<Object> findElegantByReportId(int id);
	public int updateStatus(int reportId,int elegantId,int report,int elegant);
	public List<VolReport> findListByName(@Param("name")String name)throws SQLException;
}
