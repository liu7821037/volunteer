package com.bjb.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolElegantDemeanourDao;
import com.bjb.dao.VolProjectCountDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolServiceProjectDao;
import com.bjb.dao.VolSetSysidDao;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolElegantDemeanour;
import com.bjb.entity.VolProjectCount;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolServiceProject;
import com.bjb.entity.VolSetSysid;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;
import com.tools.HttpRequest;

@Service
public class VolOutwardService {
	@Resource
	private VolUserDao userDao;
	@Resource
	private VolVolunteerUserDao voluserDao;
	@Resource
	private VolSetSysidDao volsetsysidDao;
	@Resource
	private VolServiceProjectDao projectDao;
	@Resource
	private VolProjectSignupDao volprojectsignupDao;
	@Resource
	private VolProjectCountDao volprojectcountDao;
	@Resource
	private VolElegantDemeanourDao volelegantdemeanourDao;
	@Resource
	private VolAreaDao areaDao;
	
	//获取token
	public ReturnJsonObject gettoken(VolUser user) throws SQLException{
		List<VolUser> list = userDao.findByDto(user);
		if(list.size() > 0){
			VolVolunteerUser vuser = new VolVolunteerUser();
			vuser.setUserId(list.get(0).getId());
			List<VolVolunteerUser> list1 = voluserDao.findByDto(vuser);
			String onlysign = list1.get(0).getOnlySign();
			String sr=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/getToken", "member_unionid="+onlysign);
			JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
			String msg = jsStr.getString("msg");
			String data = jsStr.getString("data");//获取data的值
			int code = Integer.parseInt(jsStr.getString("returnCode"));
			if(code == 1){
				JSONObject jstoken = JSONObject.fromObject(data); 
				String token = jstoken.getString("token");//获取token值
				Map map=new HashMap();
				map.put("token", token);
				return new ReturnJsonObject(map);
			}else{
				return new ReturnJsonObject(msg);
			}
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_015"));
		}
	}
	
	//发布项目
	public ReturnJsonObject addproject(VolServiceProject project) throws ParseException, SQLException, UnsupportedEncodingException{
		String token = project.getToken();
		String sr=HttpRequest.sendGet("http://localhost/b2c/B2c/Jlptlogin/getUserInfo", "token="+URLEncoder.encode(token, "UTF-8"));
		JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
		String msg = jsStr.getString("msg");
		String data = jsStr.getString("data");//获取data的值
		int code = Integer.parseInt(jsStr.getString("returnCode"));
		if(code == 0){
			return new ReturnJsonObject(msg);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		project.setProjectEndDate(sdf.parse(project.getProjectEndDate1()));
		project.setProjectStartDate(sdf.parse(project.getProjectStartDate1()));
		project.setProjectEnrrolEndDate(sdf.parse(project.getProjectEnrrolEndDate1()));
		VolSetSysid setsysid = new VolSetSysid();
		setsysid.setSid(project.getId());
		List<VolSetSysid> list = volsetsysidDao.findByDto(setsysid);
		Date date = new Date();
		if(list.size() > 0){
			VolServiceProject project1 = projectDao.findById(list.get(0).getProjectId());
			project.setId(list.get(0).getProjectId());
			VolArea area = areaDao.findById(project.getAreaCid());
			project.setLatitude(area.getLatitude());
			project.setLongitude(area.getLongitude());
			project.setUpdateDate(date);
			int i = projectDao.updatePartial(project);
			if(i > 0 ){
				Map map=new HashMap();
				map.put("projectId", project.getId());
				return new ReturnJsonObject(map);
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
			}
		}else{
			//获取唯一标识
			JSONObject data1 = JSONObject.fromObject(data); //将字符串转换为json结构
			String member_uniqid = data1.getString("member_unionid");
			//根据唯一标识查找user_id
			VolVolunteerUser vuser = new VolVolunteerUser();
			vuser.setOnlySign(member_uniqid);
			List<VolVolunteerUser> list1 = voluserDao.findByDto(vuser);
			//给project中creatorid赋值
			project.setCreatorId(list1.get(0).getUserId());
			//project表id主键赋值为空
			project.setId(null);
			//查找经纬度
			VolArea area = areaDao.findById(project.getAreaCid());
			project.setLatitude(area.getLatitude());
			project.setLongitude(area.getLongitude());
			//赋值创建时间和更新时间
			project.setCreateDate(date);
			project.setUpdateDate(date);
			//为项目添加封面
			if(project.getProjectCover() == null){
				StringUnit.getImgSrcByHtml(project.getDetail());
			}
			//插入project表
			projectDao.insert(project);
			//对接表赋值
			setsysid.setProjectId(project.getId());
			setsysid.setOnlySign(member_uniqid);
			setsysid.setCreatTime(date);
			setsysid.setUpdateTime(date);
			volsetsysidDao.insert(setsysid);
			//对projectId进行封装
			Map map=new HashMap();
			map.put("projectId", project.getId());
			return new ReturnJsonObject(map);
		}
	}
	
	//发布风采
	public ReturnJsonObject addelegant(VolElegantDemeanour elegant) throws SQLException, UnsupportedEncodingException{
		String token = elegant.getToken();
		String sr=HttpRequest.sendGet("http://localhost/b2c/B2c/Jlptlogin/getUserInfo", "token="+URLEncoder.encode(token, "UTF-8"));
		JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
		String msg = jsStr.getString("msg");
		String data = jsStr.getString("data");//获取data的值
		int code = Integer.parseInt(jsStr.getString("returnCode"));
		if(code == 0){
			return new ReturnJsonObject(msg);
		}
		VolSetSysid setsysid = new VolSetSysid();
		setsysid.setSid(elegant.getId());
		List<VolSetSysid> list = volsetsysidDao.findByDto(setsysid);
		Date date = new Date();
		if(list.size() > 0){
			VolElegantDemeanour elegantdemeanour = volelegantdemeanourDao.findById(list.get(0).getProjectId());
			elegant.setId(list.get(0).getProjectId());
			int i = volelegantdemeanourDao.updatePartial(elegant);
			if(i > 0 ){
				Map map=new HashMap();
				map.put("projectId", elegant.getId());
				return new ReturnJsonObject(map);
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_000"));
			}
		}else{
			//获取唯一标识
			JSONObject data1 = JSONObject.fromObject(data); //将字符串转换为json结构
			String member_uniqid = data1.getString("member_unionid");
			//根据唯一标识查找user_id
			VolVolunteerUser vuser = new VolVolunteerUser();
			vuser.setOnlySign(member_uniqid);
			List<VolVolunteerUser> list1 = voluserDao.findByDto(vuser);
			
			elegant.setCreatorId(list1.get(0).getUserId());
			elegant.setId(null);
			elegant.setCreateDate(date);
			elegant.setUpdateDate(date);
			//为风采添加封面
			if(elegant.getPicture() == null){
				StringUnit.getImgSrcByHtml(elegant.getDetail());
			}
			//插入风采表
			volelegantdemeanourDao.insert(elegant);
			//对接表赋值
			setsysid.setProjectId(elegant.getId());
			setsysid.setOnlySign(member_uniqid);
			setsysid.setCreatTime(date);
			setsysid.setUpdateTime(date);
			volsetsysidDao.insert(setsysid);
			//对projectId进行封装
			Map map=new HashMap();
			map.put("projectId", elegant.getId());
			return new ReturnJsonObject(map);
		}
	}
	
	//取得报名一览
	public ReturnJsonObject getlist(String token,int projectid) throws SQLException, UnsupportedEncodingException{
		String sr=HttpRequest.sendGet("http://localhost/b2c/B2c/Jlptlogin/getUserInfo", "token="+URLEncoder.encode(token, "UTF-8"));
		JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
		String msg = jsStr.getString("msg");
		int code = Integer.parseInt(jsStr.getString("returnCode"));
		if(code == 1){
			VolProjectSignup up = new VolProjectSignup();
			up.setProjectId(projectid);
		    List<VolProjectSignup> list = volprojectsignupDao.findByDto2(up);
			return new ReturnJsonObject(list);
		}else{
			return new ReturnJsonObject(msg);
		}
	}
	
	//添加项目参与数据
	public ReturnJsonObject addcount(VolProjectCount volprojectcount) throws SQLException, UnsupportedEncodingException{
		String token = volprojectcount.getToken();
		String sr=HttpRequest.sendGet("http://localhost/b2c/B2c/Jlptlogin/getUserInfo", "token="+URLEncoder.encode(token, "UTF-8"));
		JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
		String msg = jsStr.getString("msg");
		int code = Integer.parseInt(jsStr.getString("returnCode"));
		if(code == 0){
			return new ReturnJsonObject(msg);
		}
		VolProjectCount count = new VolProjectCount();
		count.setId(volprojectcount.getId());
		List<VolProjectCount> list = volprojectcountDao.findByDto(count);
		if(list.size() == 0){
			return new ReturnJsonObject("请先插入该项目");
		}
		volprojectcount.setJoinNums(volprojectcount.getJoinNums()+list.get(0).getJoinNums());
		volprojectcount.setReadNums(volprojectcount.getReadNums()+list.get(0).getReadNums());
		volprojectcount.setShareNums(volprojectcount.getShareNums()+list.get(0).getReadNums());
		Date date = new Date();
		volprojectcount.setUpdateDate(date);
		volprojectcountDao.updatePartial(volprojectcount);
		Map map=new HashMap();
		map.put("projectId", volprojectcount.getId());
		return new ReturnJsonObject(map);
	}
}
