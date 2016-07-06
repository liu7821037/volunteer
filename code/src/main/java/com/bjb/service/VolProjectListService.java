package com.bjb.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolProjectCountDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.dao.VolUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolProjectCount;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolServiceProject;
import com.bjb.entity.VolUser;
import com.github.pagehelper.PageHelper;
@Service
public class VolProjectListService extends BasicService{
	
	@Resource
	private VolServiceProjectDao volserviceprojectdao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolProjectSignupDao enrollDao;
	@Resource
	private VolProjectCountDao countDao;
	@Resource
	private VolAreaDao areaDao;
	@Resource
	private VolUserDao userDao;
	
	public int insert(VolServiceProject project) throws SQLException{
		project.setCreateDate(new Date());
		project.setIstop(0);
		VolProjectCount count = new VolProjectCount();
		count.setJoinNums(0);
		count.setReadNums(0);
		count.setShareNums(0);
		count.setCreateDate(new Date());
		int i = volserviceprojectdao.insert(project);
		count.setId(project.getId());
		return countDao.insert(count);
	}
	
	public Page<VolServiceProject> getList(VolServiceProject project,
			int currentPage, int pageSize) throws SQLException {
		List<VolServiceProject> list = new ArrayList<VolServiceProject>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolServiceProject> rList = volserviceprojectdao.findByDto(project);
		Page<VolServiceProject> page = findByPage(rList);
		for(VolServiceProject newss:page.getDataList()){
			list.add(newss);				
		}
		page.setDataList(list);
		return page;
	}
	
	public Page<VolServiceProject> getList1(VolServiceProject project,
			int currentPage, int pageSize) throws SQLException {
		List<VolServiceProject> list = new ArrayList<VolServiceProject>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		project.setNowTimeStr(time.format(new Date()));
		PageHelper.startPage(currentPage, pageSize);
		List<VolServiceProject> rList = volserviceprojectdao.findByDto1(project);
		Page<VolServiceProject> page = findByPage(rList);
		for(VolServiceProject newss:page.getDataList()){
			if(newss.getProjectEnrrolEndDate().before(new Date())){
				newss.setCanEnroll(1);
			}else{
				newss.setCanEnroll(0);
			}
			list.add(newss);				
		}
		page.setDataList(list);
		return page;
	}
	
	//根据projectId获得团队详情
	public VolServiceProject getProjectById(int id,String userID) throws SQLException{
		VolServiceProject project = volserviceprojectdao.findById(id);
		VolBasicData data = dataDao.findById(project.getProjectServiceObject());
		if(data!=null){
			project.setObjectName(data.getDataName());
		}
		VolBasicData data1 = dataDao.findById(project.getProjectTypeId());
		if(data1!=null){
			project.setTypeName(data1.getDataName());
		}
		VolArea area = areaDao.findById(project.getAreaPid());
		if(area!=null){
			project.setCityName(area.getAreaName());
			project.setLatitude(area.getLatitude());
			project.setLongitude(area.getLongitude());
		}
		VolArea area1 = areaDao.findById(project.getAreaCid());
		if(area1!=null){
			project.setProvinceName(area1.getAreaName());
		}
		VolUser user = userDao.findById(project.getCreatorId());
		if(user!=null){
			project.setUserName(user.getUserCode());
		}
		if(project.getProjectEnrrolEndDate().before(new Date())){
			project.setCanEnroll(1);
		}else{
			project.setCanEnroll(0);
		}
		if(userID != null&&!userID.equals("")){
			VolProjectSignup up = new VolProjectSignup();
			up.setProjectId(id);
			up.setVolunteerId(Integer.parseInt(userID));
			List<VolProjectSignup> list = enrollDao.findByDto(up);
			if(list.size()>0){
				if(list.get(0).getSignUpStutas() == 100){
					project.setCanEnroll(2);
				}	
				else if(list.get(0).getSignUpStutas() == 101){
					project.setCanEnroll(3);
				}else if(list.get(0).getSignUpStutas() == 102){
					project.setCanEnroll(4);
				}else if(list.get(0).getSignUpStutas() == 197){
					project.setCanEnroll(3);
				}
					
			}
		}
		VolProjectCount count = countDao.findById(project.getId());
		if(count!=null){
			count.setReadNums(count.getReadNums()+1);
			count.setUpdateDate(new Date());
			countDao.update(count);
		}
		project.setProjectCount(count);
		return project;
	}
	
	//根据projectId删除project
	public boolean deletProjectById(int id) throws SQLException{
		volserviceprojectdao.delete(id);
		return true;
	}
	
	public List<VolServiceProject> getListByLimit(int pageSize) throws SQLException {
		VolServiceProject news = new VolServiceProject();
		PageHelper.startPage(1, pageSize);
		List<VolServiceProject> list = volserviceprojectdao.findByDto(news);
		return list;
	}
	
	public int toTop(Integer id) throws SQLException{
		int i = 0;
		if(id>0){
			VolServiceProject project = new VolServiceProject();
			project.setIstop(1);
			int count = volserviceprojectdao.countByDto(project);
			if(count<5){
				project = volserviceprojectdao.findById(id);
				project.setIstop(1);
				volserviceprojectdao.update(project);
				i=1;
			}else{
				return i;
			}
		}
		return i;
	}
	
	public int unTop(Integer id) throws SQLException{
		int i = 0;
		if(id>0){
			VolServiceProject project = volserviceprojectdao.findById(id);
			project.setIstop(0);
			volserviceprojectdao.update(project);
			i=1;
		}
		return i;
	}

	public Page<VolServiceProject> getListByUserId(VolServiceProject project, int currentPage,
			int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		List<VolServiceProject> rList = volserviceprojectdao.findByDto3(project);
		Page<VolServiceProject> page = findByPage(rList);
		return page;
	}
		
}
