package com.bjb.entity;

import java.io.Serializable;
import java.util.List;

import com.bjb.entity.BasicDto;

public class Page<T extends BasicDto> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int currentPage;//当前页
	
	private int pageSize;//每页大小
	
	private int pages;//总页数
	
	private long total;//总条数
	
	private List<T> dataList;//数据列表

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
}
