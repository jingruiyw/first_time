/**
 * @(#)BaseDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class BaseDao {

	protected int insert(String sql,Object...params) throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("insert")){
			return (int) new UpdateTemplate().jdbc(sql,params);
		}
		throw new SqlFormatException("not a insert sql ["+sql+"]");
	}
	
	protected int update(String sql,Object...params)throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("update")){
			return (int) new UpdateTemplate().jdbc(sql,params);
		}
		throw new SqlFormatException("not a update sql ["+sql+"]");
	}
	
	protected int delete(String sql,Object...params)throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("delete")){
			return (int) new UpdateTemplate().jdbc(sql,params);
		}
		throw new SqlFormatException("not a delete sql ["+sql+"]");
	}
	
	//------------------------------------------------------------------------
	protected List<Map<String,Object>> selectForList(String sql,Object...params) throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("select")){
			return (List<Map<String, Object>>) new QueryTemplate().jdbc(sql, params);
		}
		throw new SqlFormatException("not a select sql ["+sql+"]");
	}
	
	protected Map<String,Object> selectForMap(String sql,Object...params) throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("select")){
			List<Map<String,Object>> rows = this.selectForList(sql, params);
			if(rows ==null ||rows.size()==0)
				return null;
			if(rows.size()==1){
				return rows.get(0);
			}
			throw new RowCountException("need null or one row ,but return "+rows.size());
		}
		throw new SqlFormatException("not a select sql ["+sql+"]");
	}
	
	protected <T> List<T> selectForObjects(String sql,Class<T> clazz,Object...params) throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("select")){
			List<Map<String,Object>> rows = (List<Map<String, Object>>) new QueryTemplate().jdbc(sql, params);
			List<T> ts = new ArrayList<T>();
			for(Map<String,Object> row :rows){
				T t = clazz.newInstance();
				
				Method[] ms = clazz.getMethods();
				for(Method m:ms){
					String mname = m.getName();
					if(mname.startsWith("set")){
						//set方法，可以接收参数，找到map.key
						Column c = m.getAnnotation(Column.class);
						if(c!=null){
							String key = c.value();
							Object value = row.get(key);
							m.invoke(t, value);
							break;
						}
						mname = mname.substring(3);
						if(mname.length()==1)
							mname = mname.toLowerCase();
						else
							mname = mname.substring(0, 1).toLowerCase()+mname.substring(1);
						
						Object value = row.get(mname);
						m.invoke(t, value);					
					}
				}
				ts.add(t);
			}
			return ts;
		}
		throw new SqlFormatException("not a select sql ["+sql+"]");
		}
	
	protected <T> T  selectForObject(String sql,Class clazz,Object...params) throws Exception{
		if(sql.trim().substring(0, 6).equalsIgnoreCase("select")){
			List<T> rows = this.selectForObjects(sql, clazz, params);
			if(rows ==null || rows.size()==0)
				return null;
			if(rows.size()==1)
				return rows.get(0);
			throw new RowCountException("need null or one row ,but return "+rows.size());
		}
		throw new SqlFormatException("not a select sql ["+sql+"]");
	}	
}


























