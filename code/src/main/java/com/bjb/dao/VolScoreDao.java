package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolScore;

@Repository(value="volScoreDao")
public interface VolScoreDao extends BasicDao<VolScore> {
}
