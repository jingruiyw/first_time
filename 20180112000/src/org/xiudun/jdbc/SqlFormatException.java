/**
 * @(#)SqlFormatException.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
 */
package org.xiudun.jdbc;

/**
 * TODO ʹ��һ��������sql�ķ���ִ��sqlʱ���׳����쳣
 * @author ����
 */
public class SqlFormatException extends RuntimeException{

	public SqlFormatException(String msg){
		super(msg);
	}
	
	public SqlFormatException(){}
}
