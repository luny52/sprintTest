package com.springTest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.springTest.aop.AopTestBean;
import com.springTest.aop.AopTestInterface;

public class IocTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contest = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Testspring hello=(Testspring) contest.getBean("testspring");
	        System.out.println(hello.Excute());

	        AopTestInterface aoptest=(AopTestInterface) contest.getBean("aopTestBean");
	        aoptest.save("TestAop");
	}

}
