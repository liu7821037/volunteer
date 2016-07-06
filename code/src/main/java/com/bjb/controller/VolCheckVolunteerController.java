package com.bjb.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.entity.VolVolunteerUser;
import com.bjb.service.VolCheckVolunteerUserService;

@RestController
@RequestMapping("/checkvolunteeruser")
public class VolCheckVolunteerController {
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	@Resource
	private VolCheckVolunteerUserService volvolunteeruserservice;

	
	
	//测试
	@RequestMapping("/demo")
	public String demo() throws SQLException{
	
		return  "volunteer";
	}
	
	
	//根据userId获得信息
	@RequestMapping("/getVolunteerUserById/{id}")
	public VolVolunteerUser getVolunteerUserById(@PathVariable("id")  int id) throws SQLException{
		//处理跨域访问
		response.addHeader("Access-Control-Allow-Origin:","*");
		return volvolunteeruserservice.findUserById(id);
		
	}
	//根据Id改变Report和elegant状态值（置1）
		@RequestMapping("/updateT/{id}/{userid}")
		public boolean updateT(@PathVariable("id")  int id,@PathVariable("userid") int userId ) throws SQLException{
			//处理跨域访问
			response.addHeader("Access-Control-Allow-Origin:","*");
			return  volvolunteeruserservice.updateTrue(id,userId);
		}
		
		//根据Id改变Report和elegant状态值（置2）
		@RequestMapping("/updateF/{id}/{userid}")
		public boolean updateF(@PathVariable("id")  int id,@PathVariable("userid") int userId) throws SQLException{
			//处理跨域访问
			response.addHeader("Access-Control-Allow-Origin:","*");
			return  volvolunteeruserservice.updateFalse(id,userId);
		}
	
}
