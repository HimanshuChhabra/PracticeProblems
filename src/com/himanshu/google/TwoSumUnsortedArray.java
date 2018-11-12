package com.himanshu.google;

import java.util.*;

/**
 * 
 * Given unsorted array of integers find return indexes of two numbers that sum
 * up to the target.
 *
 */
public class TwoSumUnsortedArray {

	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder();
	
		int value[] = { 2, 4, 5, 7, 8, 9 };
		int target = 9;
		// System.out.println(findTwoSum(value, target));

		int sum = 6;
		System.out.println("Count of pairs is " + getPairsCount(arr.length, sum));
	}

	public static List<Integer> findTwoSum(int[] values, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < values.length; i++) {

			int fval = values[i];
			Integer indexOfSecondValue = map.get(target - fval);
			if (indexOfSecondValue != null) {
				// return new int[] { i, indexOfSecondValue };
				list.add(i);
				list.add(indexOfSecondValue);
				count++;
			}
			map.put(fval, i);
		}
		System.out.println(count);
		return list;
	}

	static int arr[] = new int[] {1, 5, 7, -1, 5};

	

	// Returns number of pairs in arr[0..n-1] with sum equal
	// to 'sum'
	static int getPairsCount(int n, int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Store counts of all elements in map hm
		for (int i = 0; i < n; i++) {

			// initializing value to 0, if key not found
			if (!hm.containsKey(arr[i]))
				hm.put(arr[i], 0);

			hm.put(arr[i], hm.get(arr[i]) + 1);
		}
		int twice_count = 0;

		// iterate through each element and increment the
		// count (Notice that every pair is counted twice)
		for (int i = 0; i < n; i++) {
			if (hm.get(sum - arr[i]) != null)
				twice_count += hm.get(sum - arr[i]);

			// if (arr[i], arr[i]) pair satisfies the condition,
			// then we need to ensure that the count is
			// decreased by one such that the (arr[i], arr[i])
			// pair is not considered
			if (sum - arr[i] == arr[i])
				twice_count--;
		}

		// return the half of twice_count
		return twice_count / 2;
	}
	

	//ABBBCCAA -> ACCAA
	//ABCCCBB -> A

	//AABBCCCCCBBAAD
}
