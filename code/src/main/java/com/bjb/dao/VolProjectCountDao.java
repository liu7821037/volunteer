package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolProjectCount;

@Repository(value="volProjectCountDao")
public interface VolProjectCountDao extends BasicDao<VolProjectCount> {
}
