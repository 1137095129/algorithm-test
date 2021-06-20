package com.wjf.github.algorithm.sort;

/**
 * 插入排序
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends AbstractSort<T> {
	@Override
	public T[] sortAsc(T[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = i; j > 0 && less(list[j], list[j - 1]); j--) {
				exch(list, j, j - 1);
			}
		}
		return list;
	}

	@Override
	public T[] sortDesc(T[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = i; j > 0 && more(list[j], list[j - 1]); j--) {
				exch(list, j, j - 1);
			}
		}
		return list;
	}
}
