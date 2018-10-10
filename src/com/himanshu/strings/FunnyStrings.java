package com.himanshu.strings;

import java.util.Scanner;

public class FunnyStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String s = scan.nextLine();
		StringBuffer r = new StringBuffer(s);
		r.reverse();
		scan.close();
		
		boolean flag = true;

		for (int i = 1; i < s.length(); i++) {
			if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(r.charAt(i) - r.charAt(i - 1))) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("Funny");
		else
			System.out.println("Not Funny");
	}
}