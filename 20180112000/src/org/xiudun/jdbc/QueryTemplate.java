/**
 * @(#)QueryTemplate.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class QueryTemplate extends JDBCTemplate{

	
	@Override
	protected List<Map<String,Object>> execute() throws Exception {
		ResultSet rs = stmt.executeQuery();
		
		List<Map<String,Object>> rows = new ArrayList<Map<String, Object>>();
		while(rs.next()){
			Map<String,Object> row = new XiudunMap<String,Object>();
			for(int i=1;i<rs.getMetaData().getColumnCount();i++){
				String key = rs.getMetaData().getColumnName(i);
				Object value = rs.getObject(key);
				row.put(key.toLowerCase(), value);
			}
			rows.add(row);
		}
		
		return rows;
	}

}
