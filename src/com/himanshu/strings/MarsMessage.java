package com.himanshu.strings;

import java.util.Scanner;

public class MarsMessage {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		scan.close();
		int count = 0;
		int words = message.length() / 3;
		for (int i = 0; i < words; i++) {
			String substr = message.substring(3*i, (3*i+3));
			for (int j = 0; j < 3; j++) {
				if (j % 2 == 0) {
					if (substr.charAt(j) != 'S')
						count++;
				} else {
					if (substr.charAt(j) != 'O')
						count++;
				}
			}
		}

		System.out.println(count);
	}

}
