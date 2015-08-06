package com.springThread;

public class TimeRunnable implements Runnable {

	private int m_SecondSecond = 0;

	public TimeRunnable(int p_SecondSecond) {
		m_SecondSecond = p_SecondSecond;
	}

	@Override
	public void run() {

		try {
			int i = 0;
			while (i < m_SecondSecond) {
				System.out.println("Second is:" + i);
				i++;
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
