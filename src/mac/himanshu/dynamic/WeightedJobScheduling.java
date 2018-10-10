package mac.himanshu.dynamic;

import java.util.*;

public class WeightedJobScheduling {
	static int start[] = { 1, 3, 6, 2 };
	static int end[] = { 2, 5, 19, 100 };
	static int profit[] = { 50, 20, 100, 200 };
	static int path[] = null;
	static int maxProfitIndex;

	public static void main(String[] args) {
		path = new int[end.length];
		sortWithEndTime();
		int maxLength = calMaxProfit(end);
		System.out.println(maxLength);
		getPath();
	}

	private static void sortWithEndTime() {
		for (int i = 0; i < end.length; i++) {
			for (int j = 0; j < end.length - 1; j++) {
				if (end[j] > end[j + 1]) {
					int temp = end[j];
					end[j] = end[j + 1];
					end[j + 1] = temp;

					temp = start[j];
					start[j] = start[j + 1];
					start[j + 1] = temp;

					temp = profit[j];
					profit[j] = profit[j + 1];
					profit[j + 1] = temp;
				}
			}
		}
	}

	private static void getPath() {
		List<Integer> resultSet = new ArrayList<Integer>();
		while (path[maxProfitIndex] != -1 && maxProfitIndex != path[maxProfitIndex]) {
			resultSet.add(profit[maxProfitIndex]);
			maxProfitIndex = path[maxProfitIndex];
		}
		if (path[maxProfitIndex] != -1 || maxProfitIndex == 0)
			resultSet.add(profit[maxProfitIndex]);
		Collections.reverse(resultSet);
		System.out.println(resultSet);
	}

	private static int calMaxProfit(int[] end) {
		int maxProfit = Integer.MIN_VALUE;
		// L[i] is max profit for the i'th job in the sequence.
		int L[] = new int[end.length];
		path[0] = 0;
		maxProfitIndex = 0;
		for (int i = 0; i < profit.length; i++)
			L[i] = profit[i];

		for (int i = 0; i < path.length; i++)
			path[i] = -1;

		for (int i = 1; i < end.length; i++) {
			for (int j = 0; j < i; j++) {
				L[i] = (end[j] <= start[i] && L[i] < L[j] + profit[i]) ? L[j] + profit[i] : L[i];

				path[i] = (L[i] == L[j] + profit[i]) ? j : path[i];

				maxProfit = Math.max(maxProfit, L[i]);
			}

			if (maxProfit == L[i])
				maxProfitIndex = i;

		}
		return maxProfit;
	}

}
