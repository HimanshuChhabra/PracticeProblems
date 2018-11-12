package com.himanshu.bloomberg;

public class ReverseExpression {

	public static void main(String[] args) {
		String str = "30*40-56/45";
		StringBuffer s = new StringBuffer();
		int prev = str.length();
		for (int i = str.length() - 1; i >= 0; i--) {

			if (str.charAt(i) == '*' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '%' || str.charAt(i) == '+') {
				s.append(str.substring(i + 1, prev)).append(str.charAt(i));
				prev = i;
			} else if (i == 0) {
				s.append(str.substring(i, prev));
			}
		}
		System.out.println(s);

	}

}
