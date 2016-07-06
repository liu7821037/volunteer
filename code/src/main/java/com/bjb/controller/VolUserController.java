package com.bjb.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.dao.VolUserDao;
import com.bjb.dao.VolUserTypeDao;
import com.bjb.dao.VolVolunteerUserDao;
import com.bjb.entity.Page;
import com.bjb.entity.VolUser;
import com.bjb.entity.VolUserType;
import com.bjb.entity.VolVolunteerUser;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;
import com.tools.HttpRequest;
import com.tools.UniqId;
import com.bjb.service.VolUserService;

@RestController
@RequestMapping("/user")
public class VolUserController {

	@Resource
	private VolUserTypeDao typeDao;
	@Resource
	private VolUserDao userDao;
	@Resource
	private VolVolunteerUserDao vuserDao;
	@Resource
	private VolUserService service;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@Resource
	private VolVolunteerUserDao vvuserDao;
	
	@RequestMapping("/getListByTypeId/{typeId}")
	public List<VolUser> getListByTypeId(@PathVariable("typeId")int typeId) throws SQLException{
		VolUser user = new VolUser();
		user.setUserTypeId(typeId);
		return userDao.findByDto(user);
	}
	
	@RequestMapping("/getList")
	public ReturnJsonObject getList(VolUser user) throws SQLException{
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
		Page<VolUser> page = service.getList(user, currentPage, pageSize);
		return new ReturnJsonObject(page);
	}
	
	@RequestMapping("/addType")
	public int addType(VolUserType dto) throws SQLException{
		typeDao.insert(dto);
		return dto.getId();
	}
	
	//新增
	@RequestMapping("/add")
	public ReturnJsonObject add(VolUser user) throws SQLException{
		return service.adduser(user);
	}
	
	//登录
	@RequestMapping("/login")
	public ReturnJsonObject login() throws SQLException{
		String token = request.getParameter("token");
		String userCode = request.getParameter("userCode");
		String pwd = request.getParameter("userPwd");
		return service.loginuser(token,userCode,pwd);
	}
	
	//根据userCode判断账号是否存在(用于注册时使用)
	@RequestMapping("/findIdByCode/{code}")
	public int findId(@PathVariable("code") String code) throws SQLException{
		VolUser user = new VolUser();
		user.setUserCode(code);
		int id = 0;
		if(userDao.findByDto(user).size()>0){
			id = userDao.findByDto(user).get(0).getId();			
		}
		return id;
	}
	
	//更新
	@RequestMapping("/up")
	public ReturnJsonObject up() throws SQLException{
		VolUser user = userDao.findById(Integer.parseInt(request.getParameter("id")));
		user.setUserPhone(request.getParameter("userPhone"));
		int i = userDao.update(user);
		if(i>0){
			return new ReturnJsonObject();
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
		}
	}
	
	//修改密码
	@RequestMapping("/uppwd")
	@Transactional
	public ReturnJsonObject upPwd() throws SQLException{
		VolUser user = userDao.findById(Integer.parseInt(request.getParameter("id")));
		String pwd = StringUnit.MD5(request.getParameter("userPwd")).toLowerCase();
		user.setUserPwd(pwd);
		int i = userDao.update(user);
		if(i>0){
			VolVolunteerUser vuser = new VolVolunteerUser();
			vuser.setUserId(user.getId());
			List<VolVolunteerUser> list = vuserDao.findByDto(vuser);
			vuser = list.get(0);
			String uniqid = vuser.getOnlySign();
			String cover = vuser.getHeadPortrait();
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
							+"&password="+pwd
							+"&member_unionid="+URLEncoder.encode(uniqid, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String au=HttpRequest.sendGet("http://act.bjbsh.com/B2c/Jlptlogin/modifyUser", pstr);
			}
			return new ReturnJsonObject();
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
		} 
	}
	
	//用户状态修改
	@RequestMapping("/upstatus")
	public ReturnJsonObject upStatus() throws SQLException{
		VolUser user = userDao.findById(Integer.parseInt(request.getParameter("id")));
		user.setUserStatus(Integer.parseInt(request.getParameter("userStatus")));
		int i = userDao.update(user);
		if(i>0){
			return new ReturnJsonObject();
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_ERROR_002"));
		}  
	}
	
	//登录验证
	@RequestMapping("/userCheck")
	public VolUser userCheck(VolUser user) throws SQLException{
		/*user.setUserCode(request.getParameter("userCode"));
		user.setUserPwd(request.getParameter("userPwd"));
		String typeId = request.getParameter("userTypeId");
		if(typeId != null && typeId.equals(""))
			user.setUserTypeId(Integer.parseInt(typeId));*/
		user.setUserStatus(1);
		if(userDao.findByDto(user).size()>0){
			return userDao.findByDto(user).get(0);			
		}else{
			return null;
		}
	}
}
