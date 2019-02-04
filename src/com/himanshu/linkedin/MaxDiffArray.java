package com.himanshu.linkedin;

import java.util.*;

public class MaxDiffArray {

	public static void main(String[] args) {

		int arr[] = { 7, 2, 3, 10, 2, 4, 8, 1 };
		// 1,2,2,3,4,7,8,10
		// System.out.println(maxDiff(arr));
		System.out.println(maxDiff1(arr));

	}

	// O(n2)
	static int maxDifference(int[] a) {
		int max = -1;

		if (a == null || a.length <= 0)
			return max;

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					max = Math.max(max, a[i] - a[j]);
				}
			}
		}

		return max;
	}

	// O(n2)
	static int maxDifference2(int[] a) {
		int max = -1;

		if (a == null || a.length <= 0)
			return max;

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && a[i] % 2 == 0 && a[j] % 2 != 0) {
					max = Math.max(max, a[i] - a[j]);
				}
			}
		}

		return max;
	}

	// O(n) 1,2,3,6,4 // keeping track of the minimum element
	static int maxDiff(int a[]) {
		if (a == null || a.length <= 1)
			return -1;

		int maxDiff = a[1] - a[0];
		int minElem = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] - minElem > maxDiff)
				maxDiff = a[i] - minElem;
			if (a[i] < minElem)
				minElem = a[i];
		}
		if (maxDiff <= 0)
			return -1;
		else
			return maxDiff;
	}

	// even odd
	static int maxDiff1(int a[]) {

		if (a == null || a.length <= 1)
			return -1;

		int minElem = 0;
		int minIndex = 0;
		int maxDiff = Integer.MIN_VALUE;
		boolean foundMinOdd = false;

		// find first odd number
		for (int i = 0; i < a.length; i++) {

			if (a[i] % 2 != 0) {
				minElem = a[i];
				foundMinOdd = true;
				minIndex = i;
				break;
			}
		}
		
		// if no odd number return -1
		if (!foundMinOdd)
			return -1;

		// check from next index of first odd number
		for (int i = minIndex + 1; i < a.length; i++) {

			if (a[i] % 2 == 0) {
				maxDiff = Math.max(maxDiff, a[i] - minElem);
			} else if (a[i] % 2 != 0 && a[i] < minElem) {
				minElem = a[i];
			}
		}
		
		if (maxDiff <= 0)
			return -1;
		else
			return maxDiff;
	}
	
	static int maxDiff2(List<Integer> a) {
		
		if (a == null || a.size() <= 1)
			return -1;

		int minElem = 0;
		int minIndex = 0;
		int maxDiff = Integer.MIN_VALUE;
		boolean foundMinOdd = false;

		// find first odd number
		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) % 2 != 0) {
				minElem = a.get(i);
				foundMinOdd = true;
				minIndex = i;
				break;
			}
		}
		
		// if no odd number return -1
		if (!foundMinOdd)
			return -1;

		// check from next index of first odd number
		for (int i = minIndex + 1; i < a.size(); i++) {

			if (a.get(i) % 2 == 0) {
				maxDiff = Math.max(maxDiff, a.get(i) - minElem);
			} else if (a.get(i) % 2 != 0 && a.get(i) < minElem) {
				minElem = a.get(i);
			}
		}
		
		if (maxDiff <= 0)
			return -1;
		else
			return maxDiff;
	}

	
}
