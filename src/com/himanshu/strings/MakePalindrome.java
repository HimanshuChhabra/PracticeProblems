package com.himanshu.strings;

import java.util.Scanner;

public class MakePalindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
		StringBuffer str = new StringBuffer(s);
		
		scan.close();
		boolean flag = false;
		int count = 0;
		for(int i = 0 ; i<str.length() ; i++) {
			
			
			if(str.charAt(i) != str.charAt(str.length() -1 -i)) {
				str.deleteCharAt(i);
				count++;
				flag = true;
				i = 0;
			}
		}
		
		if(flag)
			System.out.println(count);
		else
			System.out.println(-1);
	}

}


/*
aaab
baa
aaa
*/