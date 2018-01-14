/**
 * @(#)CarDao.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��13��
 */
package com.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.domain.Car;

/**
 * TODO ��д����˵��
 * @author ����
 */
//�̳�baseDao����
public class CarDao extends BaseDao{

	public List<Car> findCarAll(){
		String sql="select * from t_car";
		return this.selectForObjects(sql, Car.class);//mvc�ṩ�ķ��� û�д���
		
	}
	
	public void save(Car car ){
		String sql = "insert into t_car (cname,color,price) values(?,?,?)";
		this.insert(sql, car.getCname(),car.getColor(),car.getPrice());
	}
}
