package com.himanshu.google;

import java.util.*;

public class StringToInteger {

	public static void main(String[] args) {
		String str = "-2147483649";
		// System.out.println(myAtoi(str));
		System.out.println(myLetterCombinations("234"));
	}

	public static int myAtoi(String str) {
		boolean found = false;
		boolean isNegative = false;
		int answer = 0;
		LinkedList ll = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ' ') {
				if (found)
					break;

			} else if (str.charAt(i) == '-') {
				if (found)
					return 0;
				isNegative = true;
				found = true;

			} else if (str.charAt(i) == '+') {
				if (found)
					return 0;

				found = true;
			} else if (Character.isDigit(str.charAt(i))) { // str.charAt(i) >= 48 && str.charAt(i) <= 57
				found = true;

				if (!isNegative) {
					if (answer > Integer.MAX_VALUE / 10
							|| answer == Integer.MAX_VALUE / 10 && ((str.charAt(i) - '0') > 7))
						return Integer.MAX_VALUE;
				} else {
					if ((answer * -1) < Integer.MIN_VALUE / 10
							|| (answer * -1) == Integer.MIN_VALUE / 10 && (-(str.charAt(i) - '0') < -8))
						return Integer.MIN_VALUE;
				}

				answer = answer * 10 + (str.charAt(i) - '0');

			} else {
				break;
			}
		}
		return (isNegative) ? (answer * -1) : answer;
	}

	private final static String[] pad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {
		final List<String> ret = new ArrayList<>();
		final int len = digits.length();
		if (len == 0)
			return ret;
		if (len == 1) {
			for (char c : pad[Integer.parseInt(digits.charAt(0) + "")].toCharArray()) {
				ret.add("" + c);
			}
		} else {
			final List<String> tmp = new ArrayList<>();
			tmp.addAll(letterCombinations(digits.substring(1)));
			for (String s : tmp) {
				for (char c : pad[Integer.parseInt(digits.charAt(0) + "")].toCharArray()) {
					ret.add(c + s);
				}
			}
		}
		return ret;
	}

	// 234
	public static List<String> myLetterCombinations(String digits) {
		List<String> result = new ArrayList<String>();

		if (digits.length() == 0)
			return result;
		// populate queue with first combination
		for (char c : pad[Integer.parseInt(digits.charAt(digits.length() - 1) + "")].toCharArray()) {
			result.add(c + "");
		}
		int index = digits.length() - 2;

		while (!result.isEmpty() && index >= 0) {
			String str = pad[Integer.parseInt(digits.charAt(index) + "")];
			index--;
			List<String> children = new ArrayList<String>();

			for (String combi : result) {
				for (char ch : str.toCharArray()) {
					children.add(ch + combi);
				}
			}
			
			result = children;

		}

		return result;
	}
}
