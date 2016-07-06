package com.bjb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bjb.entity.VolOrganizationUser;

@Repository(value="volOrganizationUserDao")
public interface VolOrganizationUserDao extends BasicDao<VolOrganizationUser> {

	public List<VolOrganizationUser> findListByName(@Param("name")String name) throws SQLException;
}
