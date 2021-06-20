package com.wjf.github.algorithm.core;

public interface SortST<K extends Comparable<K>, V> extends ST<K, V> {
    K max();

    K min();

    int rank(K key);

    K select(int rank);
}
