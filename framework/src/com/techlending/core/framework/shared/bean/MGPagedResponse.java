package com.techlending.core.framework.shared.bean;

import java.util.List;

public class MGPagedResponse<ManagementCompany,T> {

    private ManagementCompany managementCompany;
	private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public MGPagedResponse() {

    }

    public MGPagedResponse(ManagementCompany managementCompany,List<T> content, int page, int size, long totalElements, int totalPages, boolean last) {
        
    	this.managementCompany=managementCompany;
        
    	this.content = content;
        
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    
    public ManagementCompany getManagementCompany() {
		return managementCompany;
	}

	public void setManagementCompany(ManagementCompany managementCompany) {
		this.managementCompany = managementCompany;
	}

	public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

	public Integer getNumber() {
		// TODO Auto-generated method stub
		return 1;
	}
}

