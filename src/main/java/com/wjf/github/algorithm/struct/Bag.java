package com.wjf.github.algorithm.struct;

/**
 * 背包
 *
 * @param <T>
 */
public interface Bag<T> {
	/**
	 * 向背包中放入数据
	 *
	 * @param t
	 */
	void put(T t);

	/**
	 * 判断背包中是否为空
	 *
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 背包的数据量
	 *
	 * @return
	 */
	int size();
}
