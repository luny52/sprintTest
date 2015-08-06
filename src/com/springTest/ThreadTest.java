package com.springTest;

import org.aspectj.weaver.NewConstructorTypeMunger;

import com.springThread.MyRunnable;
import com.springThread.TimeRunnable;
import com.springThread.WaitRunnable;

public class ThreadTest {

	public static void main(String[] args) {

		Object m_SysObject = new Object();
		MyRunnable myRunnable = new MyRunnable(m_SysObject);
		TimeRunnable timeRunnable = new TimeRunnable(13);
		WaitRunnable waitRunnable = new WaitRunnable(m_SysObject);

		new Thread(timeRunnable).start();
		new Thread(waitRunnable).start();
		System.out.println("before new Thread start!");
		new Thread(myRunnable).start();
		try {
			System.out.println("before wait!");
			synchronized (m_SysObject) {
				m_SysObject.wait();
			}
			System.out.println("after wait!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
