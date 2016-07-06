package com.bjb.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolNewsInfomationDao;
import com.bjb.dao.VolUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolNewsInfomation;
import com.bjb.entity.VolUser;
import com.github.pagehelper.PageHelper;


@Service
public class VolContentNewsService extends BasicService{
	@Resource
	private VolNewsInfomationDao volnewsinfomationdao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolUserDao userDao;
	
	public VolNewsInfomation getNewsById(int id) throws SQLException{
		VolNewsInfomation news = volnewsinfomationdao.findById(id);
		VolUser user = userDao.findById(news.getInfomationRelease());
		if(user!=null){
			news.setUserName(user.getUserCode());
		}
		news.setViewed(news.getViewed()+1);
		volnewsinfomationdao.update(news);
		return news;
	}
	
	//根据newsId删除news
	public boolean deleteNewsById(int id) throws SQLException{
		volnewsinfomationdao.delete(id);
		return true;
	}
	
	public Page<VolNewsInfomation> getList(VolNewsInfomation news,
			int currentPage, int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		List<VolNewsInfomation> rList = volnewsinfomationdao.findByDto(news);
		Page<VolNewsInfomation> page = findByPage(rList);
		return page;
	}

	public List<VolNewsInfomation> getListByLimit(int pageSize) throws SQLException {
		VolNewsInfomation news = new VolNewsInfomation();
		PageHelper.startPage(1, pageSize);
		List<VolNewsInfomation> list = volnewsinfomationdao.findByDto(news);
		return list;
	}
}
