package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolElegantDemeanourDao;
import com.bjb.dao.VolReportDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolElegantDemeanour;
import com.bjb.entity.VolReport;
import com.bjb.entity.VolVolunteerUser;
import com.github.pagehelper.PageHelper;

@Service
public class VolCheckReportService extends BasicService{

	@Resource
	private VolReportDao reportDao;
	@Resource
	private VolElegantDemeanourDao elegantDao;
	@Resource
	private VolVolunteerUserDao userDao;
	
	public Page<VolReport> getList(String name, int currentPage, int pageSize) throws SQLException {
		List<VolReport> list = new ArrayList<VolReport>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolReport> rList = reportDao.findListByName(name);
		Page<VolReport> page = findByPage(rList);
		for(VolReport report:page.getDataList()){
			VolVolunteerUser user = userDao.findById(report.getVolunteerId());
			if(user != null){
				report.setFullName(user.getFullName());				
			}
			VolElegantDemeanour elegant = elegantDao.findById(report.getElegantId());
			if(elegant != null){
				report.setElegantTitle(elegant.getElegantTitle());				
			}
			list.add(report);				
		}
		page.setDataList(list);
		return page;
	}
	
	//获得所有举报
	public List<VolReport> findList() throws SQLException{
		PageHelper.startPage(1, 10);
		List<VolReport> reportList = reportDao.findAll();
		List<VolReport> list = new ArrayList<VolReport>();
		for(VolReport report:reportList){
			VolElegantDemeanour elegant = elegantDao.findById(report.getElegantId());
			report.setElegantTitle(elegant.getElegantTitle());
			VolVolunteerUser user = userDao.findById(report.getVolunteerId());
			report.setFullName(user.getFullName());
			list.add(report);
		}
		return list;
	}

	//置1
	public boolean updateTrue(Integer reportId,Integer userId) throws SQLException{
		VolReport report = reportDao.findById(reportId);
		VolElegantDemeanour elegant = elegantDao.findById(report.getElegantId());
		
		
		report.setCheckStatus("1");
		report.setCheckDate(new Date());
		report.setCheckId(userId);
		
		elegant.setAuditTypeId(2);
		elegant.setAuditDate(new Date());
		elegant.setAuditor(userId);
		

		
		elegantDao.update(elegant);
		reportDao.update(report);
		return true;
	}
	//置2
	public boolean updateFalse(Integer reportId,Integer userId) throws SQLException{
		VolReport report = reportDao.findById(reportId);
		VolElegantDemeanour elegant = elegantDao.findById(report.getElegantId());
		report.setCheckStatus("2");
		report.setCheckDate(new Date());
		report.setCheckId(userId);
		
		
		elegant.setAuditTypeId(1);
		elegant.setAuditDate(new Date());
		elegant.setAuditor(userId);
		

		elegantDao.update(elegant);
		reportDao.update(report);
		return true;
	}
	
}
