package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.ArrayFull;
import com.wjf.github.algorithm.core.exception.FullException;

public abstract class AbstractArrayStack<T> implements Stack<T>, ArrayFull {
	protected T[] data;
	protected int right = 0;

	public AbstractArrayStack(int i) {
		data = (T[]) new Object[i];
	}

	@Override
	public void push(T t) {
		if (isFull()) {
			throw new FullException();
		}
		data[right++] = t;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return data[--right];
	}

	@Override
	public boolean isEmpty() {
		return right == 0;
	}

	@Override
	public int size() {
		return right;
	}

	@Override
	public boolean isFull() {
		return right == data.length;
	}

	public T[] getData() {
		return data;
	}

}
