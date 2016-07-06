package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolAccess;

@Repository(value="volAccessDao")
public interface VolAccessDao extends BasicDao<VolAccess> {
}
