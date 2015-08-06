package com.springThread;

public class WaitRunnable implements Runnable {

	private Object m_Sys;

	public WaitRunnable(Object p_Sys) {
		m_Sys = p_Sys;
	}

	@Override
	public void run() {
		System.out.println("Wait Thread start!");

		synchronized (m_Sys) {
			try {
				System.out.println("before Wait Thread Wait!");
				m_Sys.wait();
				System.out.println("after Wait Thread Wait!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				m_Sys.notify();
				System.out.println("after new Thread notify 2!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
