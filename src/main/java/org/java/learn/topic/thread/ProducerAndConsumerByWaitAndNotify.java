package org.java.learn.topic.thread;

import org.java.learn.topic.basic.FIFO;

public class ProducerAndConsumerByWaitAndNotify {
    static FIFO<String> pool = new FIFO();
	
	public static void main(String[] args) {
		producer.start();
		consumer.start();
	}
	
	static Thread producer = new Thread(new Runnable() {
		
		@Override
		public void run() {
			int i = 0;
			while(true) {
				synchronized (pool) {
					if (!pool.isFull()) {
						i++;
						System.out.println("Producer produce a product " + i);
						pool.put("product " + i);
					} else {
//						try {
//							pool.wait();
//						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						pool.notifyAll();
					}
					
					}
				}
			}
		}
	);
	
   static  Thread consumer = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while (true) {
				synchronized (pool) {
					if (!pool.isEmpty()) {
						System.out.println("Consumer consume a " + pool.pop());
					} else {
//						pool.notifyAll();
						try {
							pool.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		}
	});
	
	
}
