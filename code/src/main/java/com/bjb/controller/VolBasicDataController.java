package com.bjb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolBasicDataDao;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.service.BasicService;
import com.bjb.util.MessageSettings;

@RestController
@RequestMapping("/data")
public class VolBasicDataController {

	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	//根据typeId查数据列表
	@RequestMapping("/findListByTypeId/{id}")
	public ReturnJsonObject findListByTypeId(@PathVariable("id") int id) throws SQLException{
//		response.addHeader("Access-Control-Allow-Origin:","*");
		VolBasicData data = new VolBasicData();
		data.setTypeId(id);
		List<VolBasicData> list = dataDao.findByDto(data);
		if(list.size() > 0){
			return new ReturnJsonObject(list); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	//新增基础数据
	@RequestMapping("/add")
	public ReturnJsonObject add() throws SQLException{
		VolBasicData data = new VolBasicData();
		data.setCreateUserId(Integer.parseInt(request.getParameter("createUserId")));
		data.setDataName(request.getParameter("dataName"));
		data.setSort(Integer.parseInt(request.getParameter("sort")));
		data.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		int i = dataDao.insert(data);
		if(i > 0){
			return new ReturnJsonObject(data); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	//根据Id查单条信息
	@RequestMapping("/findById/{id}")
	public ReturnJsonObject findById(@PathVariable("id") int id) throws SQLException{
		VolBasicData bd = dataDao.findById(id);
		return new ReturnJsonObject(bd); 
	}
	
	//更新
	@RequestMapping("/up")
	public ReturnJsonObject up() throws NumberFormatException, SQLException{
		VolBasicData data = dataDao.findById(Integer.parseInt(request.getParameter("id")));
		data.setDataName(request.getParameter("dataName"));
		data.setSort(Integer.parseInt(request.getParameter("sort")));
		int i = dataDao.update(data);
		if(i > 0){
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		}
	}
	
	//删除
	@RequestMapping("/del")
	public ReturnJsonObject del() throws NumberFormatException, SQLException{
		int i = dataDao.delete(Integer.parseInt(request.getParameter("id")));
		if(i > 0){
			return new ReturnJsonObject(); 
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
		} 
	}
	
	//获取列表
	@RequestMapping("/list")
	public ReturnJsonObject getList(VolBasicData data) throws SQLException{
		data.setTypeId(3);
		List<VolBasicData> list= dataDao.findByDto(data);
		return new ReturnJsonObject(list);
	}
}
