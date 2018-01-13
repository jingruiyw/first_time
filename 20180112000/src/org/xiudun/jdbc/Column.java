/**
 * @(#)Column.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO 实体属性与表字段不同名时 
 * @Column("cname")
 * public void setCarname(){}
 * @author 荆蕊
 */
@Target(ElementType.METHOD)//表示目标
@Retention(RetentionPolicy.RUNTIME)//表示注解的生命周期
public @interface Column {

		String value();
}
