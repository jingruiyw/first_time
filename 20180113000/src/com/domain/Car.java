/**
 * @(#)Car.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��13��
 */
package com.domain;

import java.io.Serializable;

/**
 * TODO ����ʵ��
 * @author ����
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
