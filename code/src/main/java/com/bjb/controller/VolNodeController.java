package com.bjb.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolNodeDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolNode;
import com.bjb.service.VolNodeService;

@RestController
@RequestMapping("/node")
public class VolNodeController {

	@Resource
	private VolNodeDao nodeDao;
	@Resource
	private VolNodeService nodeService;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	//根据角色Id获取节点列表
	@RequestMapping("/findbyid/{id}")
	public ReturnJsonObject findById(@PathVariable("id") int id) throws SQLException{
		List<VolNode> list = nodeService.findById(id);
		return new ReturnJsonObject(list); 
	}
	
	//获取分页列表
	@RequestMapping("/getList")
	public Page<VolNode> getList() throws SQLException{
		VolNode node = new VolNode();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return nodeService.getList(node, currentPage, pageSize);
	}
	
	//获取所有
	@RequestMapping("/getAll")
	public List<VolNode> getAll() throws SQLException{
		return nodeDao.findAll();
	}
	
	//获取节点树
	@RequestMapping("/getTree")
	public List<VolNode> getTree() throws SQLException{
		return nodeService.getTree();
	}
	
	//根据用户id 获取对应access
	@RequestMapping("/getAccessByUserId/{userId}")
	public Map<String, Map<String,Map<String,String>>> getAccessByUserId(@PathVariable("userId") int userId) throws SQLException{
		//int userId = Integer.parseInt(request.getParameter("userId"));
		return nodeService.getAccessByUserId(userId);
	}
}
