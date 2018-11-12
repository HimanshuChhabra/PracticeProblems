package com.himanshu.google;

public class TwoSumSortedArray {

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 4, 4,6};
		int i = 0, j = input.length - 1;
		int sum = 8;
		boolean flag = true;
		while (j > i) {
			int temp = input[i] + input[j];
			if (temp == sum) {
				System.out.println(input[i] + " and " + input[j]);
				flag = false;
				i++;
				j--;
				//break;
			} else if (temp < sum) {
				i++;
			} else {
				j--;
			}
		}

		if (flag)
			System.out.println("Not Found");

	}

}
