/**
 * @(#)CarAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月13日
 */
package com.action;

import java.util.List;

import org.xiudun.mvc.ResponseBody;

import com.domain.Car;
import com.service.CarService;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class CarAction {

	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}

	private List<Car> cars;

	public List<Car> getCars() {
		return cars;//相当于request.attribute("cars",cars);数据装载
	}
	
	private CarService service;
	public String show(){
		cars = service.findCarAll();
		return "show";//转发的方式，框架做
	}
	@ResponseBody
	public String save(){
		service.save(car);
		return "保存成功";
	}
}





























