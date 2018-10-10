package com.himanshu.generics;

import java.util.*;

public class GenericClassDemo<T>{
	private T t;
	private List<T> list = new ArrayList<T>();

	T get() {
		return this.t;
	}

	void  set(T t) {
		this.t = t;
	}
	
	List<T> getList() {
		return this.list;
	}

	public static void main(String[] args) {
		// String Type
		GenericClassDemo<String> obj1 = new GenericClassDemo<String>();
		obj1.set("Himanshu");
		//String Integer type
		GenericClassDemo<Integer> obj2 = new GenericClassDemo<Integer>();
		obj2.set(12);
		/**
		 * Raw type or generic type is actually decided by the reference type and not the object
		 */
		//Raw Type
		GenericClassDemo obj3 = new GenericClassDemo<>();
		obj3.set(122);
		obj3.set("Hello");

		//User defined type
		GenericClassDemo<Demo1> demo = new GenericClassDemo<Demo1>();
		demo.set(new Demo1());
		int val = demo.get().getValue();
		
		// A generic List
		demo.getList().add(new Demo1());
		demo.getList().add(new Demo1());
		
		GenericClassDemo<Object> o = new GenericClassDemo<>();
		GenericClassDemo<String> s = new GenericClassDemo<>();
		// cannot perform o = s
	}
}

class Demo1{
	private int a = 10;

	int getValue() {
		return this.a;
	}
}

