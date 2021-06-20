package com.wjf.github.algorithm.core;

public interface Sort<T extends Comparable<T>> {
	T[] sortAsc(T[] list);

	T[] sortDesc(T[] list);

	default boolean less(T v, T w) {
		return v.compareTo(w) > 0;
	}

	default boolean more(T v, T w) {
		return v.compareTo(w) < 0;
	}

	default boolean isAscSort(T[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (less(list[i + 1], list[i])) {
				return false;
			}
		}
		return true;
	}

	default boolean isDescSort(T[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (less(list[i], list[i + 1])) {
				return false;
			}
		}
		return true;
	}

}
