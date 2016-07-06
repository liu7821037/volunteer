package com.bjb.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolAreaDao;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolArea;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;
import com.github.pagehelper.PageHelper;
import com.tools.HttpRequest;
import com.tools.UniqId;

@Service
public class VolUserService extends BasicService{

	@Resource
	private VolUserDao userDao;
	@Autowired
	HttpSession session;
	@Resource
	private VolVolunteerUserDao vvuserDao;
	@Resource
	private VolAreaDao areaDao;
	@Resource
	VolVolunteerUserService service;
	
	public int insert(VolUser user) throws SQLException{
		int i = 0;
		if(user!=null){
			VolUser user1 = new VolUser();
			user1.setUserCode(user.getUserCode());
			if(userDao.findByDto(user1).size()>0){
				i=-1;
			}else{
				userDao.insert(user);
				i=user.getId();
			}
		}
		return i;
	}

	public Page<VolUser> getList(VolUser user, int currentPage,
			int pageSize) throws SQLException {
		PageHelper.startPage(currentPage, pageSize);
		List<VolUser> rList = userDao.findByDto(user);
		Page<VolUser> page = findByPage(rList);
		return page;
	}
	
	public ReturnJsonObject adduser(VolUser user) throws SQLException{
		//判断一次数据库中是否有该条数据
		VolUser luser = new VolUser();
		luser.setUserCode(user.getUserPhone());
		List<VolUser> llist = userDao.findByDto(luser);
		if(llist.size()>0){
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_010"));
		}
		//插入志愿者用户表
		String password = StringUnit.MD5(user.getUserPwd()).toLowerCase();
		user.setUserCode(user.getUserPhone());
		user.setUserPwd(password);
		user.setUserStatus(1);
		user.setUserTypeId(2);
		int userId = userDao.insert(user);
		// 登录过程
//		session.setAttribute("user",user);
		int num = 0;
		String uniqid = UniqId.getInstance().getUniqIDHashString();
		//插入志愿者表
		if(userId> 0){
			VolVolunteerUser vuser = new VolVolunteerUser();
			vuser.setUserId(user.getId());
			vuser.setFullName(user.getUserCode());
			vuser.setOnlySign(uniqid);
			num = vvuserDao.insert(vuser);
		}
		//插入活动系统用户表
		if(num > 0){
			// 添加到活动系统 uniqid --》 member_unionid
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
							+"&member_name="+user.getUserPhone()+
							"&password="+password
							+"&nickname="+user.getUserCode()
							+"&cover=''&member_unionid="+URLEncoder.encode(uniqid, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String au=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/addUser", pstr);
				JSONObject jsau = JSONObject.fromObject(au); //将字符串转换为json结构
				int acode = Integer.parseInt(jsau.getString("returnCode"));
				if(acode == 1){
					VolVolunteerUser vser = new VolVolunteerUser();
					vser.setUserId(user.getId());
					List<VolVolunteerUser> vlist = vvuserDao.findByDto(vser);
					return new ReturnJsonObject(vlist.get(0));
				}else{
					return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_010"));
				}
				
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_010"));
			}
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_010"));
		}
	}
	
	public ReturnJsonObject loginuser(String token,String userCode,String pwd) throws SQLException{
		
		if(StringUnit.isNullOrEmpty(token)){
			//使用cookies登录
			VolUser suser = new VolUser();
			suser.setUserCode(userCode);
			suser.setUserPwd(pwd);
			suser.setUserStatus(1);
			List<VolUser> slist = userDao.findByDto(suser);
			if(slist.size()>0){
				int userid = slist.get(0).getId();
				return new ReturnJsonObject(service.findById(userid));
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_015"));
			}
		}else{
			// 用token调用活动系统接口取得用户信息member_unionid
			String pstr ="";
			try {
				pstr ="token="+URLEncoder.encode(token, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String au=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/getUserInfo", pstr);
			JSONObject jsStr = JSONObject.fromObject(au); //将字符串转换为json结构
			String data = jsStr.getString("data");//获取data的值
			int code = Integer.parseInt(jsStr.getString("returnCode"));
			if(code == 1){
				JSONObject str = JSONObject.fromObject(data); 
				String member_unionid = str.getString("member_unionid");//获取member_unionid值
				VolVolunteerUser user = new VolVolunteerUser();
				user.setOnlySign(member_unionid);
				List<VolVolunteerUser> list =  vvuserDao.findByDto(user);
				if(list.size()>0){
					VolVolunteerUser vuser = service.findById(list.get(0).getUserId());
					return new ReturnJsonObject(vuser);	
				}else{
					int num = 0;
					VolUser suser = new VolUser();
					VolVolunteerUser vuser = new VolVolunteerUser();
					String member_name = str.getString("member_name");
					String nickname = str.getString("nickname");
					String avatar = str.getString("avatar");
					String password = str.getString("password");
					if(str.getString("gender") != "null"){
						int gender = Integer.parseInt(str.getString("gender"));
						vuser.setGender(gender);
					}
					String c = str.getString("city");
					if(c != "null"){
						int city = Integer.parseInt(str.getString("city"));
						vuser.setAreaId(city);
						VolArea carea = new VolArea();
						carea.setParentAreaId(city);
						List<VolArea> area = areaDao.findByDto(carea);
						carea = area.get(0);
						vuser.setCityName(carea.getAreaName());
					}
					String mobile = str.getString("mobile");
					
					if(member_name != null){
						suser.setUserCode(member_name);
						suser.setUserPhone(member_name);
					}
					if(password != null){
						suser.setUserPwd(password);
					}
					if(StringUnit.isNullOrEmpty(member_name) && StringUnit.isNullOrEmpty(password)){
						suser.setUserPwd(member_unionid);
					}
					suser.setUserStatus(1);
					suser.setUserTypeId(2);
					int userId = userDao.insert(suser);
					if(userId>0){
						vuser.setUserId(suser.getId());
						vuser.setFullName(nickname);
						vuser.setOnlySign(member_unionid);
						if(avatar != null){
							vuser.setHeadPortrait(avatar);
						}
						if(mobile != null){
							vuser.setTelphone(mobile);
						}
						if(nickname != null){
							vuser.setFullName(nickname);
						}
						num = vvuserDao.insert(vuser);
						vuser.setUser(suser);
					}
					if(num > 0){
						return new ReturnJsonObject(vuser);
					}else{
						return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_010"));
					}
				}
			}else{
				return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_010"));
			}
		}
	}
}
