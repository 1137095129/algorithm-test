package com.wjf.github.algorithm.struct;

/**
 * 队列
 *
 * @param <T>
 */
public interface Queue<T> {
	/**
	 * 向队列中添加数据
	 *
	 * @param t
	 */
	void enqueue(T t);

	/**
	 * 弹出最先进入队列的数据
	 *
	 * @return
	 */
	T dequeue();

	/**
	 * 判断队列是否为空
	 *
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 队列中存在的元素个数
	 *
	 * @return
	 */
	int size();
}
