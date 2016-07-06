package com.bjb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.entity.Page;
import com.bjb.entity.VolReport;
import com.bjb.service.VolCheckReportService;

@RestController
@RequestMapping("/checkreport")
public class VolCheckReportController {
	
	@Resource
	private VolCheckReportService reportService;
	@Resource
	HttpServletResponse response;
	@Resource
	HttpServletRequest request;
	
	//获取列表
	@RequestMapping("/getList")
	public Page<VolReport> getList() throws SQLException{
		String name = request.getParameter("name");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return reportService.getList(name, currentPage, pageSize);
	}
	
	//获得所有举报
	@RequestMapping("/getAllReport")
	public List<VolReport> getAllReport() throws SQLException{
		return reportService.findList();
	}
	
	//根据Id改变Report和elegant状态值（置1）
	@RequestMapping("/updateT/{id}/{userid}")
	public boolean updateT(@PathVariable("id")  int id,@PathVariable("userid") int userId ) throws SQLException{
		//处理跨域访问
		response.addHeader("Access-Control-Allow-Origin:","*");
		return  reportService.updateTrue(id,userId);
	}
	
	
	//根据Id改变Report和elegant状态值（置2）
	@RequestMapping("/updateF/{id}/{userid}")
	public boolean updateF(@PathVariable("id")  int id,@PathVariable("userid") int userId) throws SQLException{
		//处理跨域访问
		response.addHeader("Access-Control-Allow-Origin:","*");
		return  reportService.updateFalse(id,userId);
	}
	
}