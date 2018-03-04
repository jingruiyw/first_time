/**
 * @(#)TestMain.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	张茂修  2018年2月28日
 */
package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 填写功能说明
 * @author 荆蕊
 */
@Controller
public class TestMain {

	@RequestMapping("/test.do")
	public void t1(){
		System.out.println("====");
	}
}
