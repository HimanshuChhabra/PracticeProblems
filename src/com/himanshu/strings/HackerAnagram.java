package com.himanshu.strings;

import java.util.Scanner;

public class HackerAnagram {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		int count = 0;
		if (str.length() % 2 == 0) {
			StringBuffer str1 = new StringBuffer(str.substring(0, str.length() / 2));
			String str2 = str.substring(str.length() / 2, str.length());

			for (int i = 0; i < str2.length(); i++) {
				int index = str1.toString().indexOf(str2.charAt(i));

				if (index != -1) {
					str1.deleteCharAt(index);
				} else {
					count++;
				}
			}

		} else {
			System.out.println(-1);
		}
		System.out.println(count);
	}

}
