/**
 * @(#)QueryTemplate.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
 */
package org.xiudun.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO ��д����˵��
 * @author ����
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
