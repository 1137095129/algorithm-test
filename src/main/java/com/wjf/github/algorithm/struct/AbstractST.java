package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.ST;

public abstract class AbstractST<K extends Comparable<K>, V> implements ST<K, V> {

    @Override
    public void put(K key, V value) {
        if (value == null) {
            delete(key);
            return;
        }
        putVal(key, value);
    }

    abstract void putVal(K key, V value);

}
