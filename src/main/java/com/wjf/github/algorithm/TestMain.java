package com.wjf.github.algorithm;

import com.wjf.github.algorithm.struct.AbstractConcurrentLinkListQueue;

import java.util.concurrent.CountDownLatch;

public class TestMain {
	public static void main(String[] args) throws InterruptedException {
		AbstractConcurrentLinkListQueue<String> queue = new AbstractConcurrentLinkListQueue<String>() {
		};

		CountDownLatch latch = new CountDownLatch(4);

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				queue.enqueue("1" + i);
				System.out.println("put 1" + i + " success");
			}
			latch.countDown();
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				queue.enqueue("2" + i);
				System.out.println("put 2" + i + " success");
			}
			latch.countDown();
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				queue.enqueue("3" + i);
				System.out.println("put 3" + i + " success");
			}
			latch.countDown();
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				queue.enqueue("4" + i);
				System.out.println("put 4" + i + " success");
			}
			latch.countDown();
		}).start();


		latch.await();

		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}
