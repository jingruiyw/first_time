/**
 * @(#)CarService.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��13��
 */
package com.service;

import java.util.List;

import com.dao.CarDao;
import com.domain.Car;

/**
 * TODO ��д����˵��
 * @author ����
 */
public class CarService {

	private CarDao dao= new CarDao();
	//����һ������
	public List<Car> findCarAll(){
		return dao.findCarAll();
	}
	
	public void save(Car car){
		dao.save(car);
	}
}
