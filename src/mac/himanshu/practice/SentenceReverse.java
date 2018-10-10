package mac.himanshu.practice;

import java.util.Scanner;

public class SentenceReverse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String split [] = input.split(" ");
		StringBuilder str = new StringBuilder();
		int temp = 0;
		//		for(int i = split.length -1 ; i >= 0 ; i -- ) {
		//			str.append(split[i] + " ");
		//		}
		//		
		//		System.out.println(str.toString().trim());

		for(int i = 0 ; i < input.length() ; i++ ) {
			
			if(input.charAt(i) == ' ' || i== input.length() -1) {
				String ss = " "+input.substring(temp, i);
				str.insert(0, ss);
				temp = i+1;
			}
		}
		
		System.out.println(str.toString().trim());
	}
}
