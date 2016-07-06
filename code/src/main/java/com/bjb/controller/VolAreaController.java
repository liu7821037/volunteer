package com.bjb.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.bean.VolAreaBean;
import com.bjb.common.bean.ReturnJsonObject;
import com.bjb.common.controller.BaseController;
import com.bjb.dao.VolAreaDao;
import com.bjb.entity.VolArea;
import com.bjb.util.MessageSettings;
import com.bjb.util.StringUnit;

@RestController
@RequestMapping("/area")
public class VolAreaController extends BaseController{

	@Resource
	VolAreaDao areaDao;
	@Resource
	HttpServletRequest request;
	@Resource
	HttpServletResponse response;
	
	//根据父Id查list
	@RequestMapping("/findListByParentId/{id}")
	public ReturnJsonObject findListByParentId(@PathVariable("id") int id) throws SQLException{
		VolArea area = new VolArea();
		area.setParentAreaId(id);
		List<VolArea> list = areaDao.findByDto(area);
		if(list.size() > 0){
			return new ReturnJsonObject(list);
		}else{
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_005"));
		}
	}
	
	//获取所有城市（首字母排序）
	@RequestMapping("/getAllCityList1")
	public ReturnJsonObject getAllCityList(VolArea area) throws SQLException{
		List<VolArea> list = areaDao.getAllCityList(area);
		if(list.size()>0)
			return new ReturnJsonObject(list);
		else
			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_005"));
	}
	
	//获取所有城市（首字母排序）
	@RequestMapping("/getAllCityList")
	public ReturnJsonObject getAllCityList1(VolArea area) throws SQLException{
		List<VolArea> list = areaDao.getAllCityList(area);
		if(StringUnit.isNotEmpty(list)){
			List<VolAreaBean> data = new ArrayList<VolAreaBean>();
			String strtmp = list.get(0).getFirstLetter();
			List<VolArea> list2 = new ArrayList<VolArea>();
			for(VolArea v: list){
				if(strtmp.equals(v.getFirstLetter())){
					list2.add(v);
				}else{
					VolAreaBean vb = new VolAreaBean();
					vb.setFirst_letter(strtmp);
					vb.setVolAreas(list2);
					strtmp = v.getFirstLetter();
					list2 = new ArrayList<VolArea>();
					list2.add(v);
					data.add(vb);
				}
			}
			VolAreaBean vb = new VolAreaBean();
			vb.setFirst_letter(strtmp);
			vb.setVolAreas(list2);
			data.add(vb);
			if(data.size() > 0){
				return new ReturnJsonObject(data);
			}
		}
		return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_005"));
//		Map<String, List<VolArea>> map = new LinkedHashMap<String, List<VolArea>>();
// 		String[] a = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
// 		if(area.getFirstLetter()!=null&&!area.getFirstLetter().equals("")){
// 			List<VolArea> list = areaDao.getAllCityList(area);
// 			map.put(area.getFirstLetter(), list);
// 		}else{
// 			for(int i = 0;i<a.length;i++){
// 				area.setFirstLetter(a[i]);
// 				List<VolArea> list = areaDao.getAllCityList(area);
// 				map.put(a[i], list);
// 			}
// 		}
//		if(map.size()>0)
//			return new ReturnJsonObject(map);
//		else
//			return new ReturnJsonObject(MessageSettings.getValue("MSG_INFO_005"));
	}
}
