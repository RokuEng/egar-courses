package com.RokuEng.springrest.util;

@FunctionalInterface
public interface TriConsumer<T, U, V> {
	void accept(T t, U u, V v);
}
