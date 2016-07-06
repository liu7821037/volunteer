package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolCommonUser;

@Repository(value="volCommonUserDao")
public interface VolCommonUserDao extends BasicDao<VolCommonUser> {
}
