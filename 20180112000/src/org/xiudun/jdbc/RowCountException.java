/**
 * @(#)RowCountException.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
 */
package org.xiudun.jdbc;

/**
 * TODO ��������¼��ѯ�������˶�����¼���׳����쳣
 * @author ����
 */
public class RowCountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RowCountException(){}
	
	public RowCountException(String msg){
		super(msg);
	}
	
	
}
