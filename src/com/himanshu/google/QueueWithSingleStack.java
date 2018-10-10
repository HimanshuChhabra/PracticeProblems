package com.himanshu.google;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueWithSingleStack<T> {

	Stack<T> stack = new Stack<T>();

	public T deQueue() {
		if(stack.isEmpty())
			throw new EmptyStackException();
		
		if (stack.size() == 1)
			return stack.pop();
	
		T currValue = stack.pop();
		
		T result = deQueue();
		
		stack.push(currValue);
		
		return result;
	}
	
	public void enQueue(T value) {
		stack.push(value);
	}

	public static void main(String[] args) {

		QueueWithSingleStack<Integer> queue = new QueueWithSingleStack<Integer>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		int val = queue.deQueue();
		System.out.println(val);
		val = queue.deQueue();
		System.out.println(val);
		val = queue.deQueue();
		System.out.println(val);
		val = queue.deQueue();
		System.out.println(val);

	}

}
