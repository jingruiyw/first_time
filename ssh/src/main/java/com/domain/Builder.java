/**
 * @(#)Builder.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年2月28日
 */
package com.domain;

import java.io.Serializable;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class Builder implements Serializable{

	/**
	 * TODO 填写注释
	 */
	private static final long serialVersionUID = 1L;
	private String bid;
	private String bname;
	private String fid;
	
	private Factory factory;

	public Builder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Builder(String bid, String bname, String pid, Factory factory) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.fid = fid;
		this.factory = factory;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String pid) {
		this.fid = fid;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	
	
}
