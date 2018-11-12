package com.himanshu.bloomberg;
import java.util.*;

public class Minstack {

	List<Node> stack;

	/** initialize your data structure here. */
	    public Minstack() {
	        stack= new ArrayList<Node>();
	    }

	public void push(int x) {
		Node n = new Node();
		n.val = x;
		if (!stack.isEmpty()) {

			int min = getMin();
			 n.min = (min < x) ? min : x;
		} else {
			n.min = x;
		}

		stack.add(n);
	}

	public void pop() {
		if (!stack.isEmpty())
			stack.remove(stack.size() - 1);
	}

	public int top() {
		// if(!stack.isEmpty())
		return stack.get(stack.size() - 1).val;

	}

	public int getMin() {
		
		if (!stack.isEmpty())
			return stack.get(stack.size() - 1).min;

		return -1;
	}

	public static void main(String[] args) {
		Minstack s = new Minstack();
		s.push(-2);
		s.push(0);
		s.push(-1);
		s.pop();
		
	}

}

class Node {
	int val;
	int min;
}
