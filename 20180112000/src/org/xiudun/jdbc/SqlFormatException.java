/**
 * @(#)SqlFormatException.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

/**
 * TODO 使用一个不符合sql的方法执行sql时，抛出该异常
 * @author 荆蕊
 */
public class SqlFormatException extends RuntimeException{

	public SqlFormatException(String msg){
		super(msg);
	}
	
	public SqlFormatException(){}
}
