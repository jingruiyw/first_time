/**
 * @(#)CarAction.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��13��
 */
package com.action;

import java.util.List;

import org.xiudun.mvc.ResponseBody;

import com.domain.Car;
import com.service.CarService;

/**
 * TODO ��д����˵��
 * @author ����
 */
public class CarAction {

	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}

	private List<Car> cars;

	public List<Car> getCars() {
		return cars;//�൱��request.attribute("cars",cars);����װ��
	}
	
	private CarService service;
	public String show(){
		cars = service.findCarAll();
		return "show";//ת���ķ�ʽ�������
	}
	@ResponseBody
	public String save(){
		service.save(car);
		return "����ɹ�";
	}
}





























