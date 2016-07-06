package com.bjb.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUnit {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	/**
//	 * 将二进制数据编码为BASE64字符串
//	 * 
//	 * @param binaryData
//	 * @return
//	 */
//	public static String encode(byte[] binaryData) {
//		try {
//			return new String(Base64.encodeBase64(binaryData), "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * 将BASE64字符串恢复为二进制数据
//	 * 
//	 * @param base64String
//	 * @return
//	 */
//	public static byte[] decode(String base64String) {
//		try {
//			return Base64.decodeBase64(base64String.getBytes("UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			return null;
//		}
//	}

	/**
	 * 是否为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(Object param) {
		// 经常用这种方法来判断对象是不是空
		return !StringUnit.isNullOrEmpty(param);
	}

	/**
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof String) {
			if ("".equals((String) obj)) {
				return true;
			}
		}

		if (obj instanceof Integer) {
			if ("".equals((Integer) obj) || ((Integer) obj) == 0) {
				return true;
			}
		}

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		return false;
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static Date DateTime() {
		// 当前时间
		return new Date();
	}

	/**
	 * 时间并格式化
	 * 
	 * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(date);
		return dateString;
	}

	/**
	 * 时间并格式化
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(date);
		return dateString;
	}

	/**
	 * 时间并格式化
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getTimeShort(Date date) {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		String dateString = format.format(date);
		return dateString;
	}

	/**
	 * 字符串类型转日期类型
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date timeFormat(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 字符串类型转日期类型
	 * 
	 * @param dateString :yyyy-MM-dd
	 * @return
	 */
	public static Date timeFormatYYMMDD(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date getReserveDate(String reserve_date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(1900
					+ new Date().getYear() + "-" + reserve_date);
		} catch (ParseException e) {
			// 转换日期失败
			System.err.println("获取日期失败");
			e.printStackTrace();
			return null;
		}
	}



	/**
	 * 获得当天之后的N天日期
	 * 
	 * @return
	 */
	public static List<Date> getNextDays(int num) {
		List<Date> list = new ArrayList<Date>();
		for (int i = 0; i < num; i++) {
			list.add(getAfterDate(i));
		}
		return list;
	}

	/**
	 * 获取当前日期n天后的日期
	 * 
	 * @param n
	 *            :返回当天后的第N天
	 * @return 返回的日期
	 */
	public static Date getAfterDate(int n) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, n);
		return c.getTime();
	}

	/**
	 * 获得日期所对应的月日
	 * 
	 * @return
	 */
	public static String findMonthDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String monthDay = (month < 10 ? "0" + month : month) + "-"
				+ (day < 10 ? "0" + day : day);
		return monthDay;
	}


	/**
	 * 将 以8:00形式的字符串转换成日期类型
	 * 
	 * @param time
	 * @return
	 */
	public static Date getHourMin(String time) {
		try {
			return new SimpleDateFormat("HH:mm").parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将Int类型转成Boolean类型
	 * 
	 * @param status
	 * @return
	 */
	public static boolean getBooleanByInt(int status) {
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 将String类型转成Boolean类型
	 * 
	 * @param status
	 * @return
	 */
	public static boolean getBooleanByString(String status) {
		if ("0".equals(status)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 取得图片途径
	 * @param contentStr
	 * @return
	 */
	public static String getImgSrcByHtml(String contentStr){
        String regexImage = "<img.+?src=\"(.+?)\".+?/?>";       
        String ImageStr="";  
        String ImageSrcStr="";  
          
        Pattern p = Pattern.compile(regexImage,Pattern.CASE_INSENSITIVE);  
        Matcher m = p.matcher(contentStr);  
          
        if(m.find()){  
            ImageStr = m.group();  
            ImageSrcStr = m.group(1);  
        }  
        return ImageSrcStr;
	}
//	/**
//	 * 存入数据库转码
//	 * @param html
//	 * @return
//	 */
//	public static String escapeHtml(String html){
//		return StringEscapeUtils.escapeHtml(html);
//	}
//	/**
//	 * 返回前端前解码码
//	 * @param html
//	 * @return
//	 */
//	public static String unescapeHtml(String html){
//		return StringEscapeUtils.unescapeHtml(html);
//	}
}
