/**
 * @(#)UpdataTemplate.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
 */
package org.xiudun.jdbc;

/**
 * TODO ��ɾ��
 * @author ����
 */
public class UpdateTemplate extends JDBCTemplate{

	
	@Override
	protected Integer execute() throws Exception {
		
		return stmt.executeUpdate();
	}

}
