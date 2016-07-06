package com.bjb.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bjb.entity.BasicDto;
import com.bjb.entity.Page;

@Transactional(rollbackFor = Exception.class)
public class BasicService {

	@SuppressWarnings("rawtypes")
	public <T extends BasicDto> Page<T> findByPage(List<T> list){
		Page<T> page = new Page<T>();
		page.setPages(((com.github.pagehelper.Page)list).getPages());
		page.setTotal(((com.github.pagehelper.Page)list).getTotal());
		page.setCurrentPage(((com.github.pagehelper.Page)list).getPageNum());
		page.setPageSize(((com.github.pagehelper.Page)list).getPageSize());
		page.setDataList(list);
		return page;
	}
}
