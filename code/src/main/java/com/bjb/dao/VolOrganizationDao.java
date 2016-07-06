package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolOrganization;

@Repository(value="volOrganizationDao")
public interface VolOrganizationDao extends BasicDao<VolOrganization> {
	public List<VolOrganization> findListByName(VolOrganization venues) throws SQLException;

}