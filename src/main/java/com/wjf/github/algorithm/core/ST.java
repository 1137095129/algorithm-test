package com.wjf.github.algorithm.core;

public interface ST<K extends Comparable<K>, V> {
    boolean isEmpty();

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    boolean contains(K key);

    int size();
}
