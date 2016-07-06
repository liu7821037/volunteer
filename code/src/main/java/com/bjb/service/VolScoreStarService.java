package com.bjb.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolScoreStarDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolScoreStar;
import com.github.pagehelper.PageHelper;

@Service
public class VolScoreStarService extends BasicService{

	@Resource
	private VolScoreStarDao starDao;

	public Page<VolScoreStar> getList(VolScoreStar star, int currentPage,
			int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		Page<VolScoreStar> page = findByPage(starDao.findByDto(star));
		return page;
	}
	
	
}
