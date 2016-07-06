package com.bjb.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.common.controller.BaseController;
import com.bjb.dao.VolNewsInfomationDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolNewsInfomation;
import com.bjb.service.VolContentNewsService;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;

@RestController
@RequestMapping("/contentnews")
public class VolContentNewsInfomationController extends BaseController{
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Resource
	private VolContentNewsService volcontentnewsservice;
	@Resource
	private VolNewsInfomationDao newsDao;
	
	//获取列表
	@RequestMapping("/getList")
	public ReturnJsonObject getList(VolNewsInfomation news) throws SQLException{
		String curentPage = request.getParameter("currentPage");
		String pagesize = request.getParameter("pageSize");
		if(curentPage == null){
			curentPage = 1+"";
		}
		if(pagesize == null){
			pagesize = 10+"";
		}
		int currentPage = Integer.parseInt(curentPage);
		int pageSize = Integer.parseInt(pagesize);
		Page<VolNewsInfomation> page = volcontentnewsservice.getList(news, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	@RequestMapping("/getListByLimit")
	public List<VolNewsInfomation> getListByLimit() throws SQLException{
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return volcontentnewsservice.getListByLimit(pageSize);
	}
	
	@RequestMapping("/getById/{id}")
	public ReturnJsonObject getById(@PathVariable("id")int id) throws SQLException{
		VolNewsInfomation news = newsDao.findById(id);
		if(news != null)
			return new ReturnJsonObject(news);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	@RequestMapping("/getNewsById/{id}")
	public ReturnJsonObject getNewsById(@PathVariable("id")int id) throws SQLException{
		VolNewsInfomation news = volcontentnewsservice.getNewsById(id);
		if(news != null)
			return new ReturnJsonObject(news);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_001"));
	}
	
	@RequestMapping("/updateNewsById")
	public ReturnJsonObject updatNewsById(@RequestBody VolNewsInfomation news) throws SQLException{
		int i = newsDao.updatePartial(news);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
	}
	
	@RequestMapping("/deletNewsById/{id}")
	public boolean deletNewsById(@PathVariable("id")int id) throws SQLException{
		
		return volcontentnewsservice.deleteNewsById(id);
	}
	
	@RequestMapping("/addNewsById")
	public ReturnJsonObject addNewsById(@RequestBody VolNewsInfomation news) throws SQLException{
		news.setReleaseDate(new Date());
		news.setViewed(0);
		int i = newsDao.insert(news);
		if(i>0)
			return new ReturnJsonObject();
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_003"));
	}
}
