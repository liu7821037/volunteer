package com.bjb.dao;

import org.springframework.stereotype.Repository;
import com.bjb.entity.VolPushMessage;

@Repository(value="volPushMessageDao")
public interface VolPushMessageDao extends BasicDao<VolPushMessage> {
}
