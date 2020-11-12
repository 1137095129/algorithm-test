package com.wjf.github.algorithm;

import com.wjf.github.algorithm.struct.AbstractConcurrentLinkListQueue;
import com.wjf.github.algorithm.struct.AbstractScalableArrayStack;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class TestMain {
	public static void main(String[] args) throws InterruptedException {
		AbstractScalableArrayStack<Integer> stack = new AbstractScalableArrayStack<Integer>(10) {
		};
		for (int i = 0; i < 20; i++) {
			stack.push(i);
		}
		System.out.println(Arrays.toString(stack.getData()));
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	public static void concurrentLinkListTest() throws InterruptedException {
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
