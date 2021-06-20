package com.wjf.github.algorithm.struct;

import java.io.Serializable;

public class LinkListST<K extends Comparable<K>, V> extends AbstractST<K, V> {

    private Node<K, V> first;
    private int length = 0;

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public V get(K key) {
        for (Node<K, V> node = first; node != null; node = node.next) {
            if (node.key.compareTo(key) == 0) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        for (Node<K, V> node = first; node != null; node = node.next) {
            if (node.next != null && node.next.key.compareTo(key) == 0) {
                node.next = node.next.next;
                length--;
            } else if (first.key.compareTo(key) == 0) {
                Node<K, V> next = first.next;
                first.next = null;
                first = next;
                length--;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        for (Node<K, V> node = first; node != null; node = node.next) {
            if (node.key.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    void putVal(K key, V value) {
        for (Node<K, V> node = first; node != null; node = node.next) {
            if (node.key.compareTo(key) == 0) {
                node.value = value;
                return;
            }
            if (node.next == null) {
                node.next = new Node<>(key, value);
                length++;
            }
        }

    }

    static class Node<K extends Comparable<K>, V> implements Serializable {
        private static final long serialVersionUID = -3463159985233740192L;
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            if (key == null) {
                throw new NullPointerException();
            }
            if (value == null) {
                throw new NullPointerException();
            }
            this.key = key;
            this.value = value;
        }
    }
}
