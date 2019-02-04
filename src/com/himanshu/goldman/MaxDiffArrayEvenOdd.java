package com.himanshu.goldman;

/**
 * We just keep track of the smallest odd number
 */
import java.util.*;
import java.util.stream.Collectors;

public class MaxDiffArrayEvenOdd {

	public static void main(String[] args) {
		int arr[] = { 7, 2, 3, 10, 2, 4, 8, 1 };
		System.out.println(Arrays.asList(arr));

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

			if (a.get(i) % 2 == 0) {					// if even number calc the max difference
				maxDiff = Math.max(maxDiff, a.get(i) - minElem);
			} else if (a.get(i) % 2 != 0 && a.get(i) < minElem) {		// if odd number check if we get a smaller odd value
				minElem = a.get(i);
			}
		}

		if (maxDiff <= 0)
			return -1;
		else
			return maxDiff;
	}
}
