package com.himanshu.google;

import java.util.*;

public class ParenthesisMatching {

	public static boolean isBalanced(String input, Map<String, String> parenthesis) {
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < input.length(); i++) {

			String ch = input.charAt(i) + "";

			if (parenthesis.containsValue(ch)) {
				stack.push(ch);
			} else if (parenthesis.containsKey(ch)) {
				if (stack.isEmpty())
					return false;

				if (!parenthesis.get(ch).equals(stack.pop())) {
					return false;
				}
			}

		} 

		return true;
	}

	public static void main(String[] args) {
		Map<String, String> parenthesis = new HashMap<String, String>();
		
		char ch = (char) 1 + '0';
		System.out.println(ch);
		parenthesis.put(")", "(");
		parenthesis.put("}", "{");
		parenthesis.put("]", "[");

		System.out.println(isBalanced("({[]})", parenthesis));
		
	}

}
