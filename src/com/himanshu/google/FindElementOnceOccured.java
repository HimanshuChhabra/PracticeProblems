package com.himanshu.google;

//https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/

/**
 * Works for both sorted and unsorted arrays. Essentially can be used to find
 * the odd occurring element
 */
public class FindElementOnceOccured {

	public static void main(String[] args) {
		int[] input = { 1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8 };// { 1, 1, 2, 2, 1, 1, 2, 2, 13, 1, 1, 40, 40, 13, 13 };
		System.out.println(search(input));
		System.out.println(searchExor(input));

		int a[] = { 1, 2, 4, 5, 6 };
		System.out.println(missingNumber(a, 6));
	}

	// O Logn - Find element that is occurring odd times , Find element in sorted array that is occurring odd times
	public static int search(int input[]) {

		int low = 0;
		int high = input.length - 1;

		while (low < high) {

			int mid = (low + high) / 2;

			if (mid % 2 == 0) {
				if (input[mid] == input[mid + 1])
					low = mid + 2;
				else
					high = mid - 1;

			} else {
				if (input[mid] == input[mid - 1])
					low = mid + 1;
				else {
					high = mid - 1;
				}
			}
		}

		return input[low];
	}

	// O n using Exor
	public static int searchExor(int input[]) {

		int res = 0;

		for (int val : input) {
			res = res ^ val;
		}

		return res;
	}

	// Missing number : Exor all the elements of the arr, exor 1 - n , then exor
	// both results
	// https://www.geeksforgeeks.org/find-the-missing-number/
	public static int missingNumber(int input[], int n) {

		int x1 = input[0];
		int x2 = 1;

		for (int i = 1; i < input.length; i++)
			x1 = x1 ^ input[i];

		for (int i = 2; i <= n; i++)
			x2 = x2 ^ i;

		return x1 ^ x2;

	}
}
