package com.wjf.github.algorithm.sort;

/**
 * 选择排序
 *
 * @param <T>
 */
public class Selection<T extends Comparable<T>> extends AbstractSort<T> {
	@Override
	public T[] sortAsc(T[] list) {
		for (int i = 0; i < list.length; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (less(list[min], list[j])) {
					min = j;
				}
			}
			exch(list, i, min);
		}
		return list;
	}

	@Override
	public T[] sortDesc(T[] list) {
		for (int i = 0; i < list.length; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (less(list[j], list[min])) {
					min = j;
				}
			}
			exch(list, i, min);
		}
		return list;
	}
}
