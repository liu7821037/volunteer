package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolNewsInfomation;

@Repository(value="volNewsInfomationDao")
public interface VolNewsInfomationDao extends BasicDao<VolNewsInfomation> {
}
