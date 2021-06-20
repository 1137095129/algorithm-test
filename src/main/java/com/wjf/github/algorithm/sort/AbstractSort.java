package com.wjf.github.algorithm.sort;

import com.wjf.github.algorithm.core.Sort;

public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {
	protected void exch(T[] a, int x, int y) {
		T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
