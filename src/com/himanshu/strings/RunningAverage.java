package com.himanshu.strings;

/*
 * Example: 1 2 3 4 5 6 and range 3
 * output:  2 3 4 5
 */
public class RunningAverage {

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 4, 5, 6 };
		int range = 3;

		for (int i = 0; i < input.length; i++) {
			if(input.length < i + range )
				break;
			int index = i;
			int count = 0;
			int sum = 0;
			while(count < range) {
				sum+=input[index];
				index++;
				count++;
			}
			
			System.out.println(sum/range);
		}
	}

}
