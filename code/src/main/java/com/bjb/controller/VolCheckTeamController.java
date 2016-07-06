package com.bjb.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.entity.VolTeamUser;
import com.bjb.service.VolCheckTeamUserService;

@RestController
@RequestMapping("/checkteam")
public class VolCheckTeamController {

	@Resource
	private VolCheckTeamUserService volteamuserservice;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("/getTeamById/{id}")
	public VolTeamUser getTeamById(@PathVariable("id")  int id) throws SQLException{
		//处理跨域访问
		response.addHeader("Access-Control-Allow-Origin:","*");
		return volteamuserservice.getTeamUserById(id);
		
	}
	//根据Id改变Report和elegant状态值（置1）
		@RequestMapping("/updateT/{id}/{userid}")
		public boolean updateT(@PathVariable("id")  int id,@PathVariable("userid") int userId ) throws SQLException{
			//处理跨域访问
			response.addHeader("Access-Control-Allow-Origin:","*");
			return  volteamuserservice.updateTrue(id,userId);
		}
		
		//根据Id改变Report和elegant状态值（置2）
		@RequestMapping("/updateF/{id}/{userid}")
		public boolean updateF(@PathVariable("id")  int id,@PathVariable("userid") int userId) throws SQLException{
			//处理跨域访问
			response.addHeader("Access-Control-Allow-Origin:","*");
			return  volteamuserservice.updateFalse(id,userId);
		}
}
