package com.wjf.github.algorithm.struct;

public class DefaultArrayQueue<T> extends AbstractArrayQueue<T> {

	public DefaultArrayQueue(int i) {
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
