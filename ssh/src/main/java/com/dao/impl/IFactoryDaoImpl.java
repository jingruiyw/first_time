/**
 * @(#)IFactoryImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年2月28日
 */
package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.IFactoryDao;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
@Repository
public class IFactoryDaoImpl extends HibernateDaoSupport implements IFactoryDao{

	@Autowired
	public void setFactory(SessionFactory factory){
		super.setSessionFactory(factory);
	}
}















