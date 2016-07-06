package com.bjb.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolPushMessageDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolPushMessage;
import com.github.pagehelper.PageHelper;

@Service
public class VolPushMessageService extends BasicService{

	@Resource
	private VolPushMessageDao messageDao;

	public Page<VolPushMessage> getList(VolPushMessage message,
			int currentPage, int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		List<VolPushMessage> rList = messageDao.findByDto(message);
		Page<VolPushMessage> page = findByPage(rList);
		return page;
	}
}
