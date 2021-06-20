package com.wjf.github.algorithm.sort;

/**
 * 希尔排序
 * <p>
 * 将数组元素按照逻辑分组分成了多个子数组，
 * 每个元素在原始的数组中跨度为h，
 * 使用插入排序法对各个逻辑分组中的数据进行排序，
 *
 * </p>
 *
 * @param <T>
 */
public class Sell<T extends Comparable<T>> extends AbstractSort<T> {
	@Override
	public T[] sortAsc(T[] list) {
		int h = 1;
		int length = list.length;
		while (h < length / 3) {
			h = h * 3 + 1;
		}
		return sortAsc(list, h);
	}

	public T[] sortAsc(T[] list, int h) {
		while (h >= 1) {
			for (int i = h; i < list.length; i++) {
				for (int j = i; j >= h && less(list[j], list[j - h]); j -= h) {
					exch(list, j, j - h);
				}
			}
			h /= 3;
		}
		return list;
	}

	@Override
	public T[] sortDesc(T[] list) {
		int h = 1;
		int length = list.length;
		while (h < length / 3) {
			h = h * 3 + 1;
		}
		return sortDesc(list, h);
	}

	public T[] sortDesc(T[] list, int h) {
		while (h >= 1) {
			for (int i = h; i < list.length; i++) {
				for (int j = i; j >= h && less(list[j - h], list[j]); j -= h) {
					exch(list, j, j - h);
				}
			}
			h /= 3;
		}
		return list;
	}
}
