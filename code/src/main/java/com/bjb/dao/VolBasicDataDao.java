package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolBasicData;

@Repository(value="volBasicDataDao")
public interface VolBasicDataDao extends BasicDao<VolBasicData> {
}
