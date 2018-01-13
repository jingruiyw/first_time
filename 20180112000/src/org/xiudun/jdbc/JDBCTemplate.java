/**
 * @(#)JDBCTemplate.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
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
 * TODO ��д����˵��
 * @author ����
 */
public abstract class JDBCTemplate {
	
	private static DataSource ds;
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	
	//��������
	//��ȡ�����ļ�������jdbc.xml�ļ�
	static{
				
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("jdbc.xml");//��ȡ�ļ�
		//����xml
		SAXReader r = new SAXReader();
		try {
			//��ȡ��������
			Document doc = r.read(is);
			
			List<Element> elements ;
			if((elements = doc.selectNodes("jdbc/connection"))!=null && elements.size()==1){
				//��connection��ǩ
				Element  connection = elements.get(0);
				Element url = (Element) connection.selectNodes("url").get(0);//��connection����
				Element driver = (Element) connection.selectNodes("driver").get(0);//��֪��һ��
				Element username = (Element) connection.selectNodes("username").get(0);
				Element password = (Element) connection.selectNodes("password").get(0);//�ҵ���ǩ
				
					//�ѱ�ǩ����ֵ������ǰjdbc������
				JDBCTemplate.driver=driver.getStringValue();
				JDBCTemplate.url=url.getStringValue();
				JDBCTemplate.username=username.getStringValue();
				JDBCTemplate.password=password.getStringValue();		
	
			}else if((elements = doc.selectNodes("jdbc/pool"))!=null && elements.size()==1){
				//��pool��ǩ
				Element pool = elements.get(0);
				//��pool����
				String classpath = pool.attributeValue("class");
				Class clazz = Class.forName(classpath);//����
				ds = (DataSource) clazz.newInstance();//�������ӳض���,���������Ը�ֵ set����
				
				List<Element> es = pool.elements("property");
				for(Element e : es){
					String name = e.attributeValue("name");
					String value = e.attributeValue("value");	
					
					//DI ����ע��
					String methodName = "set"+name.substring(0, 1).toLowerCase()+name.substring(1);
					Method[] ms= clazz.getMethods();//����
					for(Method m :ms){
						//һ������
						if(m.getName().equals(methodName)){//�ҵ�ͬ������
							Class paramType = m.getParameterTypes()[0];//��һ������������
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
				//��jndi����
				Element element = elements.get(0);
				String name = element.attributeValue("name");
				
				InitialContext cxt = new InitialContext();//��TomcatҪ
				ds = (DataSource) cxt.lookup("java:comp/env/"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Object jdbc(String sql,Object[] params) throws Exception{
		try{
		//����jar�ļ�	
		//��������
		this.driverClass();
		//��������
		this.createConnection();
		//����Ԥ�������+����
		this.createStatement(sql, params);
		//ִ��sql
		return this.execute();
		//����
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
	
	private void driverClass(){//������
		if(ds==null){//û�����ӳ�
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void createConnection() throws SQLException{
		if(ds==null){  //��Ҫ�ֶ���������
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



















