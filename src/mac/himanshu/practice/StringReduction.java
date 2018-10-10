package mac.himanshu.practice;

import java.util.Scanner;

public class StringReduction {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		StringBuilder str  = new StringBuilder(input);

		for(int i = 0 ; i < str.length() -1 ; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				str.deleteCharAt(i);
				str.deleteCharAt(i);
				i = -1;
			}
		}

		if(str.toString().equals(""))
			System.out.println("Empty String");
		else
			System.out.println(str);
	}
}
