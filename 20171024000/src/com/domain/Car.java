package com.domain;

import java.io.Serializable;

public class Car implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cno;
	private String cname;
	private String color;
	private int price;
	public Car(int cno, String cname, String color, int price) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.color = color;
		this.price = price;
	}
	public Car() {
		super();
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
