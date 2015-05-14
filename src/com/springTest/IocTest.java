package com.springTest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IocTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ClassPathXmlApplicationContext contest = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Testspring hello=(Testspring) contest.getBean("testspring");
	        System.out.println(hello.Excute());

	}

}
