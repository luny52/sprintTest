package com.springTest.aop;

import org.springframework.stereotype.Service;

/**
 * @author zblin
 * @version 2015年6月3日 上午11:50:41
 * @copyright (C)2015 , GRGBanking Equipment Co., Ltd
 */

public class AopTestBean implements AopTestInterface {

	@Override
	public void save(String name) {

		System.out.println("我是save方法");
		// throw new RuntimeException();
	}

	@Override
	public void update(String name, Integer id) {

		System.out.println("我是update()方法");
	}

	@Override
	public String getPersonName(Integer id) {

		System.out.println("我是getPersonName()方法");
		return "xxx";
	}

}
