package com.wjf.github.algorithm;

import com.wjf.github.algorithm.struct.AbstractArrayQueue;

import java.util.Arrays;

public class TestMain {
	public static void main(String[] args) {
		AbstractArrayQueue<Integer> queue = new AbstractArrayQueue<Integer>(5){} ;
		for (int i = 0; i < 6; i++) {
			try {
				queue.enqueue(i);
			}catch (Exception e){
				System.out.println(i);
			}
		}

		System.out.println(Arrays.toString(queue.getData()));
		System.out.println("---------");
		if (!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
		System.out.println("---------");
		for (int i = 0; i < 6; i++) {
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

		System.out.println(Arrays.toString(queue.getData()));
	}
}
