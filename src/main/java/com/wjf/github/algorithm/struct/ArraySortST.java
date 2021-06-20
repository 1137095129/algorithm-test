package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.SortST;

public class ArraySortST<K extends Comparable<K>, V> implements SortST<K, V> {

    private K[] keys;
    private V[] vals;

    private int len = 0;

    private double incremental = 0.75;
    private int initialLength = 10;

    public ArraySortST() {
        this.keys = (K[]) new Comparable[this.initialLength];
        this.vals = (V[]) new Object[this.initialLength];
    }

    public ArraySortST(double incremental, int initialLength) {
        this.incremental = incremental;
        this.initialLength = initialLength;
        this.keys = (K[]) new Comparable[this.initialLength];
        this.vals = (V[]) new Object[this.initialLength];
    }

    final void expansion() {
        initialLength = initialLength + (int) (initialLength * incremental);
        K[] ks = (K[]) new Comparable[this.initialLength];
        V[] vs = (V[]) new Object[this.initialLength];
        System.arraycopy(keys, 0, ks, 0, keys.length);
        System.arraycopy(vals, 0, vs, 0, vals.length);
        this.keys = ks;
        this.vals = vs;
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public void put(K key, V value) {
        if (this.keys.length == this.len || this.vals.length == this.len) {
            expansion();
        }
        int i = rank(key);
        if (i < len && this.keys[i].compareTo(key) == 0) {
            this.vals[i] = value;
            return;
        }
        for (int j = this.len; i < j; j--) {
            this.keys[j] = this.keys[j - 1];
            this.vals[j] = this.vals[j - 1];
        }
        this.keys[i] = key;
        this.vals[i] = value;
        len++;
    }

    @Override
    public V get(K key) {
        if (this.len == 0) {
            return null;
        }
        int i = rank(key);
        if (i < len && this.keys[i].compareTo(key) == 0) {
            return this.vals[i];
        }
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        int i = rank(key);
        return i < this.len && this.keys[i].compareTo(key) == 0;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public K max() {
        if (this.len == 0) {
            return null;
        }
        return this.keys[this.len - 1];
    }

    @Override
    public K min() {
        if (this.len == 0) {
            return null;
        }
        return this.keys[0];
    }

    @Override
    public int rank(K key) {
        if (this.len == 0) {
            return 0;
        }
        if (key.compareTo(this.keys[0]) < 0) {
            return 0;
        }
        if (key.compareTo(this.keys[this.len - 1]) > 0) {
            return this.len;
        }
        int start = 0, end = this.len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int compare = this.keys[mid].compareTo(key);
            if (compare > 0) {
                end = mid - 1;
            } else if (compare < 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    @Override
    public K select(int rank) {
        return null;
    }
}
