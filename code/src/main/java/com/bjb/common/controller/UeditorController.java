package com.bjb.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.ueditor.ActionEnter;
import com.oss.OSSConfigure;

@EnableAutoConfiguration
@RestController
@RequestMapping("/ueditor")
public class UeditorController {

	@Autowired
	private OSSConfigure OSSConfigure;
	
	@RequestMapping(value = "/controller")
	public void controller(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");

		String rootPath =request.getSession().getServletContext().getRealPath("/");

		PrintWriter out = response.getWriter(); 
		
		String str = new ActionEnter(request, rootPath, OSSConfigure).exec();

		out.write(str);
	}
}
