package com.springThread;

public class MyRunnable implements Runnable {

	private Object m_Sys;

	public MyRunnable(Object p_Sys) {
		m_Sys = p_Sys;
	}

	@Override
	public void run() {

		try {
			System.out.println("before new Thread sleep!");
			Thread.sleep(5000);
			System.out.println("after new Thread sleep!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("before new Thread notify!");
			synchronized (m_Sys) {
				//m_Sys.notifyAll();
				m_Sys.notify();//注意,执行完这句后并不会马上释放锁,而需要执行完notify()后面的代码后才释放
				System.out.println("after new Thread notify 1!");
				try {
					Thread.sleep(2000);//等待两秒,此时notify()的效果还未显现
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		}
	}

}
