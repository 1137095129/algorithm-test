package com.wjf.github.algorithm.struct;

/**
 * 栈
 *
 * @param <T>
 */
public interface Stack<T> {
	/**
	 * 向栈压入元素
	 *
	 * @param t
	 */
	void push(T t);

	/**
	 * 弹出最后压入的元素
	 *
	 * @return
	 */
	T pop();

	/**
	 * 判断栈是否为空
	 *
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 获取栈中的元素数量
	 *
	 * @return
	 */
	int size();
}
