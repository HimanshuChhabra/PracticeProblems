package com.himanshu.google;

import java.util.*;

public class MissingRange {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };

		System.out.println(findMissingRanges(nums, 0, 99));

	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

		HashSet set = new HashSet();
		for(Integer i : nums)
			set.add(i);
		
		List<String> list = new ArrayList<String>();
		int index = lower;

		boolean foundFirst = false, foundSecond = false;
		Integer firstValue = null, secondValue = null;
		
		while (index <= upper) {

			if (!set.contains(index) && !foundFirst) {
				foundFirst = true;
				firstValue = index;
			} else if (set.contains(index) && foundFirst) {
				foundSecond = true;
				secondValue = index - 1;
			}

			if (foundFirst && foundSecond) {
				if (firstValue == secondValue)
					list.add(firstValue + "");
				else
					list.add(firstValue + "->" + secondValue);

				foundFirst = false;
				foundSecond = false;

			}else if(foundFirst && !foundSecond && index == upper) {
				list.add(firstValue + "->" + index);
				foundFirst = false;
				foundSecond = false;
			}

			index++;
		}

		return list;
	}
}
