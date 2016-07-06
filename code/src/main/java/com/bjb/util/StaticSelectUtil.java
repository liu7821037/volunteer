package com.bjb.util;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.bjb.dao.VolAreaDao;
import com.bjb.entity.VolArea;

/**
 ****************************************************************
 * @module	  选择框,静态数据初始化类
 * @describe 描述
 * @author	 zhaoht
 * @date	 2016年3月28日 下午3:43:30 
 ****************************************************************
 */
public class StaticSelectUtil {
	
	private static VolAreaDao areaDao;
	
	public static Map<Integer, String> areaMap = new LinkedHashMap<Integer, String>();  // 省份Map	public static Map<Integer, String> cityMap = null;  	// 城市Map
	
	/**
	 * 静态代码块
	 * 
	 * 在这个类第一次被调用或实例化的时候就会被执行
	 * 静态代码块只会执行一次，一般会用来初始化一些值，并且在所有对象中全局共享
	 * 
	 * 当数据为动态时，当数据变动后，需要调用此类的访问重置map
	 */
	static {
		initDao();
		onloadAreaList();      //加载省份
	}
	public static void initDao() {
		ApplicationContext ctx = GetApplicationContext.getApplicationContext();
		areaDao = (VolAreaDao) ctx.getBean("areaDao"); //加载权限角色
	}
	
	private static void onloadAreaList(){
		areaMap = new LinkedHashMap<Integer, String>();
		try {
			List<VolArea> areaList = areaDao.findAll();
			if(areaList!=null&&areaList.size()>0){
				for(int i=areaList.size()-1;i>-1;i--){
					areaMap.put(areaList.get(i).getId(), areaList.get(i).getAreaName());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断地区是否合法
	 */
	public static boolean containsArea(Integer areaId){
		return (areaMap!=null&&areaId!=null&&areaMap.containsKey(areaId)) ? true : false;
	}
	/**
	 * 判断地区字段是否包含非数字
	 */
	public static boolean judgeAreaIdIsIncludeIntOrString(String areaId){
		try {
		    int a=Integer.valueOf(areaId);//把字符串强制转换为数字
		    return true;//如果是数字，返回True
		   } catch (Exception e) {
		            return false;//如果抛出异常，返回False
		   }
	}
}

