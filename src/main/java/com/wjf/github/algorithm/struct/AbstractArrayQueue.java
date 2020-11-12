package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.ArrayFull;
import com.wjf.github.algorithm.core.exception.FullException;
import com.wjf.github.algorithm.util.ObjectUtils;

/**
 * 最基础的队列功能
 *
 * @param <T>
 */
public abstract class AbstractArrayQueue<T> implements Queue<T>, ArrayFull {
	protected T[] data;
	protected int left = 0;
	protected int right = 0;

	public AbstractArrayQueue(int i) {
		data = (T[]) new Object[i];
	}

	public void enqueue(T t) {
		//存储数据的数组必须先初始化
		ObjectUtils.requireObjectNotNull(data);
		if (isFull()) {
			throw new FullException();
		}
		data[right++ % data.length] = t;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return data[left++ % data.length];
	}

	public T[] getData() {
		return data;
	}
}
