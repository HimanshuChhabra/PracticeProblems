package com.himanshu.bloomberg;

import java.util.Arrays;

/**
 *  1. Count then number of negative/ odd numbers
 *  2. Let i point to the location of the next negative/odd number
 *  3. Run a loop until i equals totals number of negatives/ odd number
 *  4. Each iteration if the a[i] is -ve move i and j ahead
 *  5. else swap i and j and increment j , this will keep updating the current value of i until swapped value is -ve/odd
 * @author himanshuchhabra
 *
 */
public class SegregateProblems {

	public static void main(String[] args) {
		int arr[] = { -12, 11, -13, 4, 6, 7, 7, -5, 6, -7, 5, -3, -6 };
		segregateNegativesPositives(arr);
		System.out.println(Arrays.toString(arr));

		int arr2[] = {1,2,3,4,5,6,7,8 };
		segregateEvenOdd(arr2);
		System.out.println(Arrays.toString(arr2));
		
		StringBuilder s = new StringBuilder();
		

	}

	// for Positives to be on the left, simply switch the comparators
	static void segregateNegativesPositives(int arr[]) {

		int negativeCount = 0; // counting negative numbers
		for (int i = 0; i < arr.length; i++)
			if (arr[i] < 0)
				negativeCount++;

		// Run a loop until all
		// negative numbers are
		// moved to the beginning
		int i = 0, j = i + 1;
		while (i != negativeCount) {

			// This is used to pause at the location which will change
			if (arr[i] < 0) {
				i++;
				j = i + 1;
			}

			// For a positive integer keep moving j until a negative number is found , this
			// will swap to the right place
			// pointed by i and in the next iteration i and j are reset .
			else if (arr[i] > 0 && j < arr.length) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				j++;
			}
		}
	}

	static void segregateEvenOdd(int arr[]) {

		int oddCount = 0; // counting negative numbers
		for (int i = 0; i < arr.length; i++)
			if (arr[i] % 2 != 0)
				oddCount++;

		// Run a loop until all
		// odd numbers are
		// moved to the beginning
		int i = 0, j = i + 1;
		while (i != oddCount) {

			// This is used to pause at the location which will change
			if (arr[i] % 2 != 0) {
				i++;
				j = i + 1;
			}

			// For a positive integer keep moving j until a negative number is found , this
			// will swap to the right place
			// pointed by i and in the next iteration i and j are reset .
			else if (arr[i] % 2 == 0 && j < arr.length) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				j++;
			}
		}
	}
}
