package com.springTest.aop;

/**
 * @author zblin
 * @version 2015年6月3日 上午11:48:39
 * @copyright (C)2015 , GRGBanking Equipment Co., Ltd
 */
public interface AopTestInterface {
	public void save(String name);

	public void update(String name, Integer id);

	public String getPersonName(Integer id);
}
