package com.springTest;

import com.springThread.SynRunnable;
import com.springThread.TimeRunnable;

public class ThreadSynTest {

	public static void main(String[] args) {

		SynRunnable synRunnable = new SynRunnable();
		TimeRunnable timeRunnable = new TimeRunnable(20);

		new Thread(timeRunnable).start();
		new Thread(synRunnable).start();
		new Thread(synRunnable).start();
		new Thread(synRunnable).start();
		new Thread(synRunnable).start();
		
		

	}

}
