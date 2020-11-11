package com.wjf.github.algorithm.util;

public class ObjectUtils {
	public static <T> T requireObjectNotNull(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		return t;
	}

	public static <T> T requireObjectNotNull(T t, String msg) {
		if (t == null) {
			throw new NullPointerException(msg);
		}
		return t;
	}
}
