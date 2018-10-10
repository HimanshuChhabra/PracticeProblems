package com.himanshu.google;

public class DetectCycleArray {

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 1,4 };

		boolean flag = false;
		int i = 0, j = 0;
		int count = 0;
		while (true) {

			if (i < 0 || i >= input.length || j < 0 || j >= input.length)
				break;

			if (count < 2) {
				j = input[j];
				if (i == j) {
					flag = true;
					break;
				}
				count++;
			}else {
				count = 0;
				i = input[i];
				if (i == j) {
					flag = true;
					break;
				}
			}

		}

		if (flag)
			System.out.println("Cycle detected");
		else
			System.out.println("Cycle not detected");

	}

}
