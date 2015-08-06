package com.springTest;

import org.aspectj.weaver.NewConstructorTypeMunger;

public class otherTest {

	public static void main(String[] args) {
		String s1 = new String("123");
		String s2 = new String("123");

		String s3 = "123";
		String s4 = "123";
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);

		s3 += "4";
		System.out.println(s3 == s4);

		String s5, s6;
		s5 = s1;
		s6 = s1;

		System.out.println(s5 == s6);

		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);

		Integer i3 = 1;
		Integer i4 = 1;

		System.out.println(i1 == i2);
		System.out.println(i3 == i4);

		Integer i5 = 200;// 超过Integer对象池存放数的范围，即：直接赋给一个Integer对象
		Integer i6 = 200;
		System.out.println(i5 == i6);

		System.out.println(new Exception().getStackTrace()[0].getMethodName());
		System.out.println(new Exception().getStackTrace()[0].getClassName());
		System.out.println(new Exception().getStackTrace()[0].getFileName());
		System.out.println(new Exception().getStackTrace()[0].getLineNumber());
		System.out.println(new Exception().getStackTrace()[0].toString());

		Object i = new String("123");
		func1(i);
		System.out.println(i);

	}

	static void func1(Object p_iInteger) {
		p_iInteger=new String("1234");
	
	}

}
