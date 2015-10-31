package com.entity;

import java.util.List;

public class Page {
	@SuppressWarnings("rawtypes")
	private List list;
	
	private int allRow;
	private int allPage;
	private int currentPage;
	private int pageSize;
	
	@SuppressWarnings("unused")
	private boolean isFirstPage;
	@SuppressWarnings("unused")
	private boolean isLastPage;
	@SuppressWarnings("unused")
	private boolean hasPreviousPage;
	@SuppressWarnings("unused")
	private boolean hasNextPage;
	
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
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
	
	public boolean isFirstPage() {
		return currentPage == 1;
	}
	public boolean isLastPage() {
		return currentPage == allPage;
	}
	public boolean isHasPreviousPage() {
		return currentPage != 1;
	}
	public boolean isHasNextPage() {
		return currentPage != allPage;
	}

	public void init() {
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}
	
	public static int countTotalPage(final int pageSize, final int rows) {
		int totalPage = rows % pageSize == 0 ? rows/pageSize : rows/pageSize + 1;
		return totalPage;
	}
	
	public static int countCurrentPage(int page) {
		final int curPage = (page==0 ? 1 : page);
		return curPage;
	}
}
