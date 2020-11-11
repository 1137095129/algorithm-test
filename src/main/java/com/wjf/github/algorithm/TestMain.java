package com.wjf.github.algorithm;

import com.wjf.github.algorithm.struct.AbstractArrayQueue;

public class TestMain {
	public static void main(String[] args) {
		AbstractArrayQueue<Integer> queue = new AbstractArrayQueue<Integer>(100){} ;
		for (int i = 0; i < 101; i++) {
			try {
				queue.enqueue(i);
			}catch (Exception e){
				System.out.println(i);
			}
		}
		System.out.println("---------");
		while (!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}
}
