package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolScoreConsumption;

@Repository(value="volScoreConsumptionDao")
public interface VolScoreConsumptionDao extends BasicDao<VolScoreConsumption> {
}
