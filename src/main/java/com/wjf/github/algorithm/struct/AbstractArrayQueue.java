package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.exception.FullException;
import com.wjf.github.algorithm.util.ObjectUtils;

/**
 * 最基础的队列功能
 *
 * @param <T>
 */
public abstract class AbstractArrayQueue<T> implements Queue<T> {
	protected T[] data;
	private int left = 0;
	private int right = 0;

	public AbstractArrayQueue(int i) {
		data = (T[]) new Object[i];
	}

	public void enqueue(T t) {
		//存储数据的数组必须先初始化
		ObjectUtils.requireObjectNotNull(data);
		if ((right > left && (right - left) >= (data.length - 1))
				|| (left > right && (right + (data.length - left)) >= (data.length - 1))) {
			System.out.println(left+"---"+right);
			throw new FullException();
		}
		data[right++ % data.length] = t;
		if (right >= data.length) {
			right = right % data.length;
		}
	}

	public T dequeue() {
		if (right == left) {
			throw new NullPointerException();
		}
		T res = data[left++ % data.length];
		if (left >= data.length) {
			left = left % data.length;
		}
		return res;
	}

	public boolean isEmpty() {
		return right == left;
	}

	public int size() {
		if (right > left) {
			return right - left;
		}
		return right + (data.length - left);
	}
}
