package com.bjb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolOrganizationDao;
import com.bjb.dao.VolOrganizationUserDao;
import com.bjb.dao.VolOrganizationUserRelationDao;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolUserTypeDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolOrganization;
import com.bjb.entity.VolOrganizationUser;
import com.bjb.entity.VolOrganizationUserRelation;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolUserType;
import com.bjb.util.StaticSelectUtil;
import com.github.pagehelper.PageHelper;

@Service
public class VolOrganizationService extends BasicService{

	@Resource
	private VolOrganizationDao venuesDao;
	@Resource
	private VolOrganizationUserRelationDao venuesUserRelationDao;
	@Resource
	private VolAreaDao areaDao;
	@Resource
	private VolUserTypeDao userTypeDao;
	@Resource
	private VolUserDao userDao;
	@Resource
	private VolOrganizationUserDao organizationUserDao;
	
	public Page<VolOrganization> getList(VolOrganization venues,Integer currentPage,Integer pageSize) throws SQLException{
		List<VolOrganization> list = new ArrayList<VolOrganization>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolOrganization> userList = venuesDao.findByDto(venues);
		Page<VolOrganization> page = findByPage(userList);
		for(VolOrganization u:page.getDataList()){
			//地区名称
			/*if(u.getOrganizationArea()!=null&&StaticSelectUtil.judgeAreaIdIsIncludeIntOrString(u.getOrganizationArea())){
				if(u.getOrganizationArea()!=null&&StaticSelectUtil.containsArea(Integer.parseInt(u.getOrganizationArea()))){
					VolArea area = areaDao.findById(Integer.parseInt(u.getOrganizationArea()));
					if(area!=null){
						u.setOrganizationAreaName(area.getAreaName());				
					}
				}else{
					u.setOrganizationAreaName("该字段填入一个非地区编码的ID"+u.getOrganizationArea());
				}
			}else{
				u.setOrganizationAreaName("该字段填入一个非数字的字符串"+u.getOrganizationArea());
			}*/
			VolArea area = areaDao.findById(Integer.parseInt(u.getOrganizationArea()));
			if(area!=null){
				u.setOrganizationAreaName(area.getAreaName());				
			}
			list.add(u);
		}
		page.setDataList(list);
		return page;
	}

	public Page<VolOrganizationUserRelation> findUserPageByVenues(
			VolOrganizationUserRelation venuesUserRelation, int currentPage,
			int pageSize) throws SQLException {
		List<VolOrganizationUserRelation> list = new ArrayList<VolOrganizationUserRelation>();
		List<VolOrganizationUserRelation> userList = new ArrayList<VolOrganizationUserRelation>();
		PageHelper.startPage(currentPage, pageSize);
		if(venuesUserRelation.getUserName()!=null&&venuesUserRelation.getUserName().length() > 0){
			userList = venuesUserRelationDao.findVenuesUserByDto(venuesUserRelation);
		}else{
			userList = venuesUserRelationDao.findByDto(venuesUserRelation);
		}
		Page<VolOrganizationUserRelation> page = findByPage(userList);
		for(VolOrganizationUserRelation u:page.getDataList()){
			if(u.getUserType()!=null){
				VolUserType userType = userTypeDao.findById(u.getUserType());
				if(userType!=null){
					u.setUserTypeName(userType.getUserTypeName());
					if(u.getUserId()!=null&&u.getUserType()==1){  //该场馆用户是机构用户
						VolOrganizationUser organizationUser = organizationUserDao.findById(u.getUserId());
						if(organizationUser!=null){
							u.setUserName(organizationUser.getUserCode());
						}else{
							u.setUserName("该场馆用户("+u.getUserId()+")在该类型无信息");
						}
					}
					if(u.getUserId()!=null&&u.getUserType()==2){  //该场馆用户是志愿者用户
						VolUser user = userDao.findById(u.getUserId());
						if(user!=null){
							u.setUserName(user.getUserCode());
						}else{
							u.setUserName("该场馆用户("+u.getUserId()+")在该类型无信息");
						}
					}
				}else{
					u.setUserTypeName("该类型ID不正确");
					u.setUserName(u.getUserId().toString());
				}
			}else{
				u.setUserTypeName("该用户缺失类型ID");
				u.setUserName(u.getUserId().toString());
			}
			list.add(u);
		}
		page.setDataList(list);
		return page;
	}

	public VolOrganizationUserRelationDao getVenuesUserRelationDao() {
		return venuesUserRelationDao;
	}

	@Resource(name="volOrganizationUserRelationDao")
	public void setVenuesUserRelationDao(
			VolOrganizationUserRelationDao venuesUserRelationDao) {
		this.venuesUserRelationDao = venuesUserRelationDao;
	}
	
}
