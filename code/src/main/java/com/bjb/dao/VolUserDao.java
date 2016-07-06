package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolUser;

@Repository(value="volUserDao")
public interface VolUserDao extends BasicDao<VolUser> {
}
