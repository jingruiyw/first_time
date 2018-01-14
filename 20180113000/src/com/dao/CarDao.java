/**
 * @(#)CarDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月13日
 */
package com.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.domain.Car;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
//继承baseDao父类
public class CarDao extends BaseDao{

	public List<Car> findCarAll(){
		String sql="select * from t_car";
		return this.selectForObjects(sql, Car.class);//mvc提供的方法 没有传参
		
	}
	
	public void save(Car car ){
		String sql = "insert into t_car (cname,color,price) values(?,?,?)";
		this.insert(sql, car.getCname(),car.getColor(),car.getPrice());
	}
}
