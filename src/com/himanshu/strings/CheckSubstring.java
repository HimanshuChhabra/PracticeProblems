package com.himanshu.strings;

import java.util.Scanner;

public class CheckSubstring {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		String hack = "hackerrank";
		boolean flag = false;
		int hackIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == hack.charAt(hackIndex)) {
				hackIndex++;
				if (hackIndex == hack.length()) {
					flag = true;
					break;
				}
			}
		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
