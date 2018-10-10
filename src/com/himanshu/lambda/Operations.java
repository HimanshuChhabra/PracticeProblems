package com.himanshu.lambda;

@FunctionalInterface
public interface Operations<T> {
	T messageModifier(T msg);
}
