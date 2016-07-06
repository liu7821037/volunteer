package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolDataType;

@Repository(value="volDataTypeDao")
public interface VolDataTypeDao extends BasicDao<VolDataType> {
}
