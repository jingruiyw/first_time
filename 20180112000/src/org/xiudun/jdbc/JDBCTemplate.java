/**
 * @(#)JDBCTemplate.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public abstract class JDBCTemplate {
	
	private static DataSource ds;
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	
	//加载驱动
	//读取配置文件，创建jdbc.xml文件
	static{
				
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("jdbc.xml");//读取文件
		//解析xml
		SAXReader r = new SAXReader();
		try {
			//读取所需内容
			Document doc = r.read(is);
			
			List<Element> elements ;
			if((elements = doc.selectNodes("jdbc/connection"))!=null && elements.size()==1){
				//有connection标签
				Element  connection = elements.get(0);
				Element url = (Element) connection.selectNodes("url").get(0);//在connection里找
				Element driver = (Element) connection.selectNodes("driver").get(0);//已知有一个
				Element username = (Element) connection.selectNodes("username").get(0);
				Element password = (Element) connection.selectNodes("password").get(0);//找到标签
				
					//把标签属性值赋给当前jdbc的内容
				JDBCTemplate.driver=driver.getStringValue();
				JDBCTemplate.url=url.getStringValue();
				JDBCTemplate.username=username.getStringValue();
				JDBCTemplate.password=password.getStringValue();		
	
			}else if((elements = doc.selectNodes("jdbc/pool"))!=null && elements.size()==1){
				//有pool标签
				Element pool = elements.get(0);
				//在pool里找
				String classpath = pool.attributeValue("class");
				Class clazz = Class.forName(classpath);//反射
				ds = (DataSource) clazz.newInstance();//创建连接池对象,给对象属性赋值 set方法
				
				List<Element> es = pool.elements("property");
				for(Element e : es){
					String name = e.attributeValue("name");
					String value = e.attributeValue("value");	
					
					//DI 依赖注入
					String methodName = "set"+name.substring(0, 1).toLowerCase()+name.substring(1);
					Method[] ms= clazz.getMethods();//方法
					for(Method m :ms){
						//一个方法
						if(m.getName().equals(methodName)){//找到同名方法
							Class paramType = m.getParameterTypes()[0];//拿一个参数的类型
							if(paramType == String.class){
								m.invoke(ds, value);
								break;
							}
							if(paramType == int.class || paramType == Integer.class){
								m.invoke(ds, Integer.parseInt(value));
								break;
							}
							if(paramType == long.class){
								m.invoke(ds, Long.parseLong(value));
								break;
							}
						}
					}
					
				}				
			}else if((elements = doc.selectNodes("jdbc/jndi"))!=null && elements.size()==1){
				//在jndi里找
				Element element = elements.get(0);
				String name = element.attributeValue("name");
				
				InitialContext cxt = new InitialContext();//向Tomcat要
				ds = (DataSource) cxt.lookup("java:comp/env/"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Object jdbc(String sql,Object[] params) throws Exception{
		try{
		//导入jar文件	
		//加载驱动
		this.driverClass();
		//创建连接
		this.createConnection();
		//创建预处理命令集+传参
		this.createStatement(sql, params);
		//执行sql
		return this.execute();
		//传参
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	
	protected Connection conn;
	protected PreparedStatement stmt;
	
	private void driverClass(){//驱动类
		if(ds==null){//没有连接池
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void createConnection() throws SQLException{
		if(ds==null){  //需要手动创建连接
			conn = DriverManager.getConnection(url,username,password);
		}else{
			conn = ds.getConnection();
		}
	}
	
	private void createStatement(String sql,Object[] params) throws SQLException{
		stmt = conn.prepareStatement(sql);
		for(int i =0;i<params.length;i++){
			stmt.setObject(i+1, params[i]);
		}
	}
	
	protected abstract Object execute() throws Exception;
}



















