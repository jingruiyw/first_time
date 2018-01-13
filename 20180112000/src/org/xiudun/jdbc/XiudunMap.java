/**
 * @(#)XiudunMap.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年1月12日
 */
package org.xiudun.jdbc;

import java.util.HashMap;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
public class XiudunMap<K,V> extends HashMap<K,V>{

	@Override
	public V get(Object key) {
		key = ((String)key).toUpperCase();//变成大写
		return super.get(key);
	}

	
}
