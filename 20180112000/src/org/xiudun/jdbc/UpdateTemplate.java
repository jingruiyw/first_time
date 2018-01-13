/**
 * @(#)UpdataTemplate.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

/**
 * TODO 增删改
 * @author 荆蕊
 */
public class UpdateTemplate extends JDBCTemplate{

	
	@Override
	protected Integer execute() throws Exception {
		
		return stmt.executeUpdate();
	}

}
