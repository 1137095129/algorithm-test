package com.wjf.github.algorithm.struct;

import com.wjf.github.algorithm.core.Scalable;

public abstract class AbstractScalableArrayStack<T> extends AbstractArrayStack<T> implements Scalable {
	private final double coefficient = 0.75;

	public AbstractScalableArrayStack() {
		super(10);
	}

	public AbstractScalableArrayStack(int i) {
		super(i);
	}

	@Override
	public void push(T t) {
		if (isFull()) {
			expand();
		}
		super.push(t);
	}

	@Override
	public boolean expand() {
		T[] data = (T[]) new Object[(int) (this.data.length + this.data.length * coefficient)];
		if (this.right >= 0) System.arraycopy(this.data, 0, data, 0, this.right);
		this.data = data;
		return true;
	}
}
