package com.wjf.github.algorithm.struct;

public class DefaultConcurrentArrayQueue<T> extends AbstractConcurrentArrayQueue<T> {
	public DefaultConcurrentArrayQueue(int i) {
		super(i);
	}

	public boolean isFull() {
		return (right - left) >= data.length;
	}

	public boolean isEmpty() {
		return right == left;
	}

	public int size() {
		return right - left;
	}
}
