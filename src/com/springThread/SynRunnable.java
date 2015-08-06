package com.springThread;

public class SynRunnable implements Runnable {

	@Override
	public void run() {

		System.out.println("Thread id :" + Thread.currentThread().getId()
				+ " start run!");

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread id :" + Thread.currentThread().getId()
				+ " wait to enter synchronized!");
		//synchronized (new Object()) {//同步的锁如果为不同对象则synchronized不会起作用
		//synchronized (this) {//同步的锁如果为相同对象或者类型,则synchronized起作用
		
		synchronized (this.getClass()) {
			System.out.println("Thread id :" + Thread.currentThread().getId()
					+ " enter synchronized!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread id :" + Thread.currentThread().getId()
					+ " leave synchronized!");
		}

	}

}
