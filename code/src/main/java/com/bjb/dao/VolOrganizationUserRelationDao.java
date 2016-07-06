package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjb.entity.VolOrganizationUserRelation;

@Repository(value="volOrganizationUserRelationDao")
public interface VolOrganizationUserRelationDao extends BasicDao<VolOrganizationUserRelation> {
	/**
	 * 联合查询
	 * @param cloud 
	 */
	public List<VolOrganizationUserRelation> findVenuesUserByDto(VolOrganizationUserRelation relation) throws SQLException;
}
