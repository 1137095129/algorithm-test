package com.wjf.github.algorithm.struct;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractConcurrentLinkListQueue<T> implements Queue<T> {

	private static final Node NODE = new Node();
	private AtomicReference<Node<T>> head = new AtomicReference<>((Node<T>) NODE);
	private AtomicReference<Node<T>> tail = new AtomicReference<>((Node<T>) NODE);

	@Override
	public void enqueue(T t) {
		Node<T> head = this.head.get(), tail = this.tail.get(), node = new Node<>(t);
		if ((head == NODE && tail == NODE) || head == null) {
			if (this.head.compareAndSet(head, node)) {
				this.tail.set(node);
				return;
			}
		}
		tail = this.tail.get();
		while (!this.tail.compareAndSet(tail, node)) {
			tail = this.tail.get();
		}
		node.pre = tail;
		tail.next = node;
	}

	@Override
	public T dequeue() {
		Node<T> head = this.head.get(), next = head == null ? null : head.next;
		while (head == null || !this.head.compareAndSet(head, next)) {
			head = this.head.get();
			next = head == null ? null : head.next;
		}

		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return (head.get() == tail.get() && head.get() == NODE) || head.get() == null;
	}

	@Override
	public int size() {
		return 0;
	}

	final static class Node<T> implements Serializable {
		private static final long serialVersionUID = -2101605356616936512L;
		private volatile Node<T> pre;
		private volatile Node<T> next;
		private volatile T data;

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
