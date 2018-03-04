/**
 * @(#)Factory.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年2月28日
 */
package com.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class Factory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String fid;
	private String fname;
	private String address;
	
	private Set<Builder> builder;

	public Factory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factory(String fid, String fname, String address, Set<Builder> builder) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.address = address;
		this.builder = builder;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Builder> getBuilder() {
		return builder;
	}

	public void setBuilder(Set<Builder> builder) {
		this.builder = builder;
	}
	
	
}
