package com.himanshu.amazon;

import java.util.*;

public class MinimumDistanceTravel {

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(9);
		l1.add(0);
		result.add(l1);

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(0);
		l2.add(0);
		result.add(l2);

		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(1);
		l3.add(1);
		result.add(l3);

		System.out.println(minimumDistance(3, 3, result));
	}

	private static int minimumDistance(int rows, int columns, List<List<Integer>> area) {
		
		if(area.size() == 0)
			return -1;
		

		int result = -1;
		int size = area.get(0).size();
		int memo[][] = new int[area.size()][area.get(0).size()];
		
		for (int i = 0; i < area.size(); i++) {
			List<Integer> region = area.get(i);

			for (int j = 0; j < region.size(); j++) {
				int val = region.get(j);

				int minimum = Integer.MAX_VALUE;
				if (val == 1 || val == 9) {
					if (j - 1 >= 0 && memo[i][j - 1] > 0) {
						
						minimum = Math.min(minimum, memo[i][j - 1]);
					}
					if (i - 1 >= 0 && memo[i - 1][j] > 0) {
						minimum = Math.min(minimum, memo[i - 1][j]);
					}
					if (j + 1 < size && memo[i][j + 1] > 0) {
						minimum = Math.min(minimum, memo[i][j + 1]);
					}
					if (i + 1 < area.size() && memo[i + 1][j] > 0) {
						minimum = Math.min(minimum, memo[i + 1][j]);
					}
					if(minimum == Integer.MAX_VALUE && val == 9) {
						return -1;
					}
					if(minimum == Integer.MAX_VALUE) {
						minimum = 0;
					}
					minimum += 1;
					memo[i][j] = minimum;
	
					if (val == 9) {
						return memo[i][j] - 1;
					}

				}
			}

		}

		return result;
	}
}
