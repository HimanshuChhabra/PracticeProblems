package mac.himanshu.practice;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		StringBuilder str = new StringBuilder();
		
		for(int i = input.length() - 1 ; i >=0 ; i --) {
			str.append(input.charAt(i));
		}
		
		System.out.println(str);
	}

}
