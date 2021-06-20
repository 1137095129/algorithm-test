package com.wjf.github.algorithm.struct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class AbstractLinkListQueue<T> implements Queue<T>, Iterable<T> {
	private final static Node<Object> NODE = new Node<>();
	private Node<T> head = (Node<T>) NODE;
	private Node<T> tail = (Node<T>) NODE;
	private int size;

	public void enqueue(T t) {
		Node<T> node = new Node<T>(t), head = this.head, tail = this.tail;

		if ((head == tail && head == NODE) || (head == tail && head == null)) {
			this.head = this.tail = node;
		} else {
			this.tail = node;
			node.pre = tail;
			tail.next = node;
		}
		size++;
	}

	public T dequeue() {
		if (isEmpty())
			throw new NullPointerException();
		Node<T> head = this.head;
		this.head = head.next;
		if (head.next == null)
			this.tail = null;
		size--;
		return head.data;
	}

	public boolean isEmpty() {
		return (head == tail && head == NODE) || (head == tail && head == null);
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
//		Iterator<T> iterator = new Node<T>();
		return null;
	}

	@Override
	public void forEach(Consumer<? super T> action) {
	}

	@Override
	public Spliterator<T> spliterator() {
		return null;
	}

	final static class Node<T> implements Serializable {
		private static final long serialVersionUID = -1322231559804809030L;
		private Node<T> pre;
		private Node<T> next;
		private T data;

		public Node() {
		}

		public Node(T data) {
			this.data = data;
		}

		public Node(Node<T> pre, Node<T> next, T data) {
			this.pre = pre;
			this.next = next;
			this.data = data;
		}

	}
}
