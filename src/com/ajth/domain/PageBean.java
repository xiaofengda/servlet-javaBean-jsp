package com.ajth.domain;

import java.util.List;

/*
 * 分页包装类
 */
public class PageBean<T> {

	private int currentPage;	//当前页，默认显示第一页
	private int pageCount;		//每页显示的条数
	private int totalCount;			//总记录条数
	private int totalPage;			//总页数 = 总记录条数 /每页显示条数
	private List<T> list;				//查询到的数据
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	

	

}
