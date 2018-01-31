package com.neuedu.pojo;

public class PageBean {

	private Integer pageNo=1;
	private Integer pageSize=4;
	private Integer withPage=1;
	private Integer pageStart=0;
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		setPageStart(pageNo, pageSize);
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		setPageStart(pageNo, pageSize);
	}

	public Integer getWithPage() {
		return withPage;
	}

	public void setWithPage(Integer withPage) {
		this.withPage = withPage;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageNo,Integer pageSize) {
		this.pageStart = (pageNo-1)*pageSize;
	}
	
	
	
}
