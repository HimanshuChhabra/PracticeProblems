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
		int value[] = { 2, 4, 5, 7, 8, 9 };
		int target = 9;
		int[] result = findTwoSum(value, target);
		if (result != null)
			System.out.println(result[0] + "," + result[1]);
	}

	public static int[] findTwoSum(int[] values, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < values.length; i++) {

			int fval = values[i];
			Integer indexOfSecondValue = map.get(target - fval);
			if (indexOfSecondValue != null) {
				return new int[] { i, indexOfSecondValue };
			}
			map.put(fval, i);
		}

		return null;
	}

	

}
