/**
 * @(#)CarService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月13日
 */
package com.service;

import java.util.List;

import com.dao.CarDao;
import com.domain.Car;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class CarService {

	private CarDao dao= new CarDao();
	//返回一堆汽车
	public List<Car> findCarAll(){
		return dao.findCarAll();
	}
	
	public void save(Car car){
		dao.save(car);
	}
}
