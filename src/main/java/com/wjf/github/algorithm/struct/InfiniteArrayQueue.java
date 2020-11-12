package com.wjf.github.algorithm.struct;

public class InfiniteArrayQueue<T> extends AbstractArrayQueue<T> {
	private int size;

	public InfiniteArrayQueue(int i) {
		super(i);
	}

	@Override
	public void enqueue(T t) {
		super.enqueue(t);
		size++;
		if (right > data.length) {
			right = right % data.length;
		}
	}

	@Override
	public T dequeue() {
		T t = super.dequeue();
		size--;
		if (left > data.length) {
			left = left % data.length;
		}
		return t;
	}

	public boolean isFull() {
		return size == data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
