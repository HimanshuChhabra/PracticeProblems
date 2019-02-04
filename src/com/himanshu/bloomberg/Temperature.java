package com.himanshu.bloomberg;

import java.util.*;

public class Temperature {

	public static void main(String[] args) {
		dailyTemperatures2(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });

	}

	public static int[] dailyTemperatures2(int[] T) {
		int ans[] = new int[T.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int j = T.length - 1;
		for (int i = T.length - 1; i >= 0; i--) {
			int temp = T[i];

			int search = temp + 1;
			while (search <= 100) {
				Integer index = map.get(search);
				if (index != null && index > i) {
					if (ans[j] == 0) {
						ans[j] = index - i;
					} else {
						ans[j] = Math.min(ans[j], index - i);
					}
				}
				search++;
			}
			j--;
			map.put(temp, i);
		}

		return ans;
	}

	public static int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length];
		int[] next = new int[101];
		Arrays.fill(next, Integer.MAX_VALUE);
		for (int i = T.length - 1; i >= 0; --i) {
			int warmer_index = Integer.MAX_VALUE;
			for (int t = T[i] + 1; t <= 100; ++t) {
				if (next[t] < warmer_index)
					warmer_index = next[t];
			}
			if (warmer_index < Integer.MAX_VALUE)
				ans[i] = warmer_index - i;
			next[T[i]] = i;
		}
		return ans;
	}
}
