package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.ArrayFull;
import com.wjf.github.algorithm.util.ObjectUtils;

public abstract class AbstractConcurrentArrayQueue<T> implements Queue<T>, ArrayFull {

	protected final T[] data;
	protected volatile int right = 0;
	protected volatile int left = 0;
	protected final Object lock = new Object();

	public AbstractConcurrentArrayQueue(int i) {
		data = (T[]) new Object[i];
	}

	public void enqueue(T t) {
		synchronized (lock) {
			ObjectUtils.requireObjectNotNull(t);
			if (isFull()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			data[right++ % data.length] = t;
			lock.notifyAll();
		}
	}

	public T dequeue() {
		synchronized (lock) {
			if (isEmpty()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lock.notifyAll();
			return data[left++ % data.length];
		}
	}

}
