package com.himanshu.linkedin;

public class MaxDiffArray {

	public static void main(String[] args) {

		int arr[] = {8,4,5};// { 7, 2, 3, 10, 2, 4, 8, 1 };
		// 1,2,2,3,4,7,8,10
		System.out.println(maxDiff(arr));
		// System.out.println(maxDifference(null));

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

	//O(n)
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

}
