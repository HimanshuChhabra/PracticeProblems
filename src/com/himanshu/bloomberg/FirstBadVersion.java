package com.himanshu.bloomberg;

public class FirstBadVersion {

	public static void main(String[] args) {
		firstBadVersion(7);
	}

	public static int firstBadVersion(int n) {
		int low = 1;
		int high = n;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high; // or even low
	}

	private static boolean isBadVersion(int n) {
		// this was an API from leetcode, this method is dummy
		return true;
	}
}
