/**
 * @(#)XiudunMap.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ï��  2018��1��12��
 */
package org.xiudun.jdbc;

import java.util.HashMap;

/**
 * TODO ��д����˵��
 * @author ����
 */
public class XiudunMap<K,V> extends HashMap<K,V>{

	@Override
	public V get(Object key) {
		key = ((String)key).toUpperCase();//��ɴ�д
		return super.get(key);
	}

	
}
