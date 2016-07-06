package com.bjb.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.bjb.Constants;
import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolBasicDataDao;
import com.bjb.dao.VolProjectSignupDao;
import com.bjb.dao.VolPushMessageDao;
import com.bjb.dao.VolRoleDao;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolBasicData;
import com.bjb.entity.VolProjectSignup;
import com.bjb.entity.VolPushMessage;
import com.bjb.entity.VolRole;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.exception.AddException;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;
import com.github.pagehelper.PageHelper;
import com.tools.HttpRequest;
import com.tools.UniqId;

@Service
public class VolVolunteerUserService extends BasicService{

	@Resource
	private VolUserDao dao;
	@Resource
	private VolVolunteerUserDao userDao;
	@Resource
	private VolBasicDataDao dataDao;
	@Resource
	private VolPushMessageDao mDao;
	@Resource
	private VolProjectSignupDao upDao;
	@Resource
	private VolAreaDao areaDao;
	@Resource
	private VolRoleDao roleDao;
	@Resource
	VolUserDao userDao1;

	public int insert(VolVolunteerUser vUser) throws NumberFormatException, UnsupportedEncodingException, SQLException, AddException{
		int i = 0;
		String uniqid = UniqId.getInstance().getUniqIDHashString();
		VolUser user = vUser.getUser();
		String pwd = StringUnit.MD5(vUser.getUser().getUserPwd()).toLowerCase();
		user.setUserPwd(pwd);
		if(StringUnit.isNullOrEmpty(user.getUserTypeId())){
			user.setUserTypeId(2);
		}
		user.setUserStatus(1);
		if(dao.insert(user)>0){
			vUser.setUserId(user.getId());
			vUser.setOnlySign(uniqid);
			vUser.setTelphone(vUser.getUser().getUserPhone());
			vUser.setRegisterDate(new Date());
			i = userDao.insert(vUser);
			String cover = "";
			if(vUser.getHeadPortrait() == null || vUser.getHeadPortrait() == ""){
				cover = "http://jlpt.img-cn-hangzhou.aliyuncs.com/volunteer/2016-06-29/KWMaZAA3kn.jpg";
			}else{
				cover = vUser.getHeadPortrait();
			}
			if(i>0){
				// 添加到活动系统 uniqid --》 member_unionid
				String sr=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/getToken", "member_unionid=2f30ee181e65442e9e75f6ff88fc23b1");
				JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
				String data = jsStr.getString("data");//获取data的值
				int code = Integer.parseInt(jsStr.getString("returnCode"));
				if(code == 1){
					JSONObject jstoken = JSONObject.fromObject(data); 
					String token = jstoken.getString("token");//获取token值
					String pstr ="";
					pstr ="token="+URLEncoder.encode(token, "UTF-8")
							+"&member_name="+vUser.getUser().getUserCode()
							+"&mobile="+vUser.getUser().getUserPhone()+
							"&password="+pwd
							+"&nickname="+vUser.getFullName()
							+"&cover="+cover+"&member_unionid="+URLEncoder.encode(uniqid, "UTF-8");
					String au=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/addUser", pstr);
					jsStr = JSONObject.fromObject(au); //将字符串转换为json结构
					code = Integer.parseInt(jsStr.getString("returnCode"));
					if(code != 1){
						throw new AddException("MSG_INFO_014");
					}
				}else{
					throw new AddException("MSG_INFO_014");
				}
			}
		}
		return i;
	}
	
	public Page<VolVolunteerUser> getList(VolVolunteerUser user,
			int currentPage, int pageSize) throws SQLException {
		List<VolVolunteerUser> list = new ArrayList<VolVolunteerUser>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolVolunteerUser> userList = userDao.findByDto(user);
		Page<VolVolunteerUser> page = findByPage(userList);
		for(VolVolunteerUser u:page.getDataList()){
			//性别
			VolBasicData data = dataDao.findById(u.getGender());
			if(data!=null){
				u.setSexName(data.getDataName());				
			}
			VolRole role = roleDao.findById(u.getRoleId());
			if(role!=null){
				u.setRoleName(role.getName());
			}
			VolArea area = areaDao.findById(u.getAreaId());
			if(area!=null){
				u.setCityName(area.getAreaName());
			}
			/*//服务类型
			VolBasicData data1 = dataDao.findById(u.getServiceTypeId());
			if(data1!=null){
				u.setServiceTypeName(data1.getDataName());				
			}
			//从业状况
			VolBasicData data2 = dataDao.findById(u.getEmploymentStatusId());
			if(data2!=null){
				u.setEmploymentName(data2.getDataName());				
			}*/
			list.add(u);
		}
		page.setDataList(list);
		return page;
	}

	public int addUser(VolUser user) throws SQLException {
		int i = 0;
		if(user!=null){
			VolUser user1 = new VolUser();
			user1.setUserCode(user.getUserCode());
			if(dao.findByDto(user1).size()>0){
				i=-1;
			}else{
				dao.insert(user);
				VolVolunteerUser vuser = new VolVolunteerUser();
				vuser.setCheckStatus(1);
				vuser.setFullName(user.getUserCode());
				vuser.setUserId(user.getId());
				vuser.setTelphone(user.getUserPhone());
				vuser.setServiceTime(0);
				userDao.insert(vuser);
				i=user.getId();
			}
		}
		return i;
	}
	
	public VolVolunteerUser findById(Integer id) throws SQLException{
		VolVolunteerUser user = new VolVolunteerUser();
		user.setUserId(id);
		List<VolVolunteerUser> list = userDao.findByDto(user);
		if(list.size()>0){
			user = list.get(0);
			VolPushMessage m = new VolPushMessage();
			m.setVolunteerId(id);
			m.setReadOrNot(0);
			user.setMessageCount(mDao.countByDto(m));
			VolProjectSignup up = new VolProjectSignup();
			up.setVolunteerId(id);
			up.setSignUpStutas(100);
			user.setDoingCount(upDao.countByDto(up));
			up.setSignUpStutas(101);
			user.setFinishCount(upDao.countByDto(up));
			VolArea area = areaDao.findById(user.getAreaId());
			if(area != null){
				user.setCityName(area.getAreaName());
			}
		}
		return user;
	}

	public Page<VolVolunteerUser> getList1(int currentPage, int pageSize) throws SQLException {
		List<VolVolunteerUser> list = new ArrayList<VolVolunteerUser>();
		PageHelper.startPage(currentPage, pageSize);
		List<VolVolunteerUser> userList = userDao.findlist();
		Page<VolVolunteerUser> page = findByPage(userList);
		for(VolVolunteerUser u:page.getDataList()){
			//性别
			VolBasicData data = dataDao.findById(u.getGender());
			if(data!=null){
				u.setSexName(data.getDataName());				
			}
			VolRole role = roleDao.findById(u.getRoleId());
			if(role!=null){
				u.setRoleName(role.getName());
			}
			list.add(u);
		}
		page.setDataList(list);
		return page;
	}
	
	public ReturnJsonObject modifyUser(VolVolunteerUser user,String uniqid) throws SQLException{
		user.setUpdateDate(new Date());
		if(user.getUser() != null){
			userDao1.updatePartial(user.getUser());
			user.setTelphone(user.getUser().getUserPhone());
		}
		int i = userDao.updatePartial(user);
		if(i>0){
			String sr=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/getToken", "member_unionid=2f30ee181e65442e9e75f6ff88fc23b1");
			JSONObject jsStr = JSONObject.fromObject(sr); //将字符串转换为json结构
			String data = jsStr.getString("data");//获取data的值
			int code = Integer.parseInt(jsStr.getString("returnCode"));
			if(code == 1){
				JSONObject jstoken = JSONObject.fromObject(data); 
				String token = jstoken.getString("token");//获取token值
				String pstr ="";
				try {
					pstr ="token="+URLEncoder.encode(token, "UTF-8")
							+"&member_unionid="+URLEncoder.encode(uniqid, "UTF-8");
					
					if(user.getFullName() != null){
						pstr += "+&nickname="+user.getFullName();
					}
					if(user.getHeadPortrait() != null){
						pstr += "+&cover="+user.getHeadPortrait();
					}
					if(user.getUser() != null){
						if(user.getUser().getUserPwd() != null){
							pstr += "+&password="+user.getUser().getUserPwd();
						}
					}
					if(user.getTelphone() != null){
						pstr += "+&member_name="+user.getTelphone();
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String au=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/modifyUser", pstr);
				JSONObject jsStr1 = JSONObject.fromObject(au); //将字符串转换为json结构
				String data1 = jsStr1.getString("data");//获取data的值
				int code1 = Integer.parseInt(jsStr1.getString("returnCode"));
				if(code1 == 1){
					return new ReturnJsonObject(Constants.RETURN_CODE_1,MessageSettings.getValue("MSG_INFO_007"),null);
				}else{
					return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
				}
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
			}
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
		}
	}
	
}
