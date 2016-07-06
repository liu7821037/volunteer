package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolAccessDao;
import com.bjb.dao.VolNodeDao;
import com.bjb.dao.VolRoleUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolAccess;
import com.bjb.entity.VolNode;
import com.github.pagehelper.PageHelper;


@Service
public class VolNodeService extends BasicService{

	@Resource
	private VolNodeDao nodeDao;
	@Resource
	private VolAccessDao accessDao;
	@Resource
	private VolRoleUserDao RUDao;

	public List<VolNode> findById(int id) throws SQLException {
		List<VolNode> list = new ArrayList<VolNode>();
		List<VolNode> vList = nodeDao.findAll();
		for(VolNode a:vList){
			VolAccess access = new VolAccess();
			access.setRole_id(id);
			access.setNode_id(a.getId());
			List<VolAccess> aList = accessDao.findByDto(access);
			if(aList.size()>0){
				a.setAccess(1);
			}else{
				a.setAccess(0);
			}
			list.add(a);
		}
		return list;
	}

	public Page<VolNode> getList(VolNode node, int currentPage, int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		Page<VolNode> page = findByPage(nodeDao.findByDto(node));
		return page;
	}
	
	public Map<String, Map<String,Map<String,String>>> getAccessByUserId(Integer userId) throws SQLException{
		Map<String, Map<String,Map<String,String>>> map = new LinkedHashMap<String, Map<String,Map<String,String>>>();
		List<VolNode> list = nodeDao.findByUserId(userId,0,1);
		for(VolNode node:list){
			Map<String,Map<String,String>> map1 = new LinkedHashMap<String, Map<String,String>>();
			List<VolNode> list1 = nodeDao.findByUserId(userId,node.getId(),2);
			for(VolNode node1:list1){
				Map<String, String> map2 = new LinkedHashMap<String, String>();
				List<VolNode> list2 = nodeDao.findByUserId(userId,node1.getId(),3);
				for(VolNode node2:list2){
					map2.put(node2.getName().toUpperCase(), node2.getId()+"");
				}
				map1.put(node1.getName().toUpperCase(), map2);
			}
			map.put(node.getName().toUpperCase(), map1);
		}
		return map;
	}

	public List<VolNode> getTree() throws SQLException {
		List<VolNode> List = new ArrayList<VolNode>();
		VolNode node = new VolNode();
		node.setPid(1);;
		List<VolNode> list = nodeDao.findByDto(node);
		for(VolNode n:list){
			node.setPid(n.getId());
			List<VolNode> list1 = nodeDao.findByDto(node);
			n.setNode(list1);
			List.add(n);
		}
		return List;
	}
}
