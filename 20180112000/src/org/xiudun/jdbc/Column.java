/**
 * @(#)Column.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
 */
package org.xiudun.jdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO ʵ����������ֶβ�ͬ��ʱ 
 * @Column("cname")
 * public void setCarname(){}
 * @author ����
 */
@Target(ElementType.METHOD)//��ʾĿ��
@Retention(RetentionPolicy.RUNTIME)//��ʾע�����������
public @interface Column {

		String value();
}
