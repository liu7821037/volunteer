package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolTeamUser;

@Repository(value="volTeamUserDao")
public interface VolTeamUserDao extends BasicDao<VolTeamUser> {
}
