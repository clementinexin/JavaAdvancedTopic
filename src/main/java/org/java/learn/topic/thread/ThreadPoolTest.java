package org.java.learn.topic.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
//		ExecutorService executor = Executors.newFixedThreadPool(3);
//		ExecutorService executor = Executors.newCachedThreadPool();
		final ExecutorService executor = Executors.newSingleThreadExecutor();
//		final ExecutorService executor = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 10; i++) {
			final int task = i;
			executor.execute(new Runnable() {
				
				public void run() {
					for (int j = 0; j < 10; j++) {
						//							Thread.currentThread().sleep(1);
//						Thread.currentThread().destroy();
						System.out.println(Thread.currentThread().getName() + " loop of " + j + " in task " + task );

					}
					
				}
			});
		}
//		executor.shutdown();
//		executor.shutdownNow();
		System.out.println("10 tasks are commited ");
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("kicked");
			}
		}, 3, 2, TimeUnit.SECONDS);
	}

}
