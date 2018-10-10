package com.himanshu.strings;

import java.util.Scanner;

public class DeleteOdd {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		StringBuffer str = new StringBuffer(s.nextLine());
		s.close();

		for (int i = 0; i < str.length(); i++) {
			if (i % 2 != 0)
				str.deleteCharAt(i);
		}

		System.out.println(str);
	}

}
