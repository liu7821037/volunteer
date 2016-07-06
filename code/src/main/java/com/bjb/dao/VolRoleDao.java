package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolRole;

@Repository(value="volRoleDao")
public interface VolRoleDao extends BasicDao<VolRole> {
}
