/**
 * @(#)Car.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月13日
 */
package com.domain;

import java.io.Serializable;

/**
 * TODO 汽车实体
 * @author 荆蕊
 */
public class Car implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer cno;
	private String cname;
	private String color;
	private String price;
	public Car() {
		super();
	}
	public Car(Integer cno, String cname, String color, String price) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.color = color;
		this.price = price;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
