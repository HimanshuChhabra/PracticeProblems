package mac.himanshu.dynamic;

import java.util.*;

/**
 * Value from up is remove, value from left is insert, value from diagonal is replace
 * When we  have i == j also char at these indexes are same, we copy from diagonal of upper cell incurring no cost
 * otherwise we take min of three and add one, incurring 1 cost
 * @author himanshuchhabra
 *
 */
public class MinimumEditDistance {

	public static void main(String[] args) {
		String str1 = "horse";
		String str2 = "ros";

		// cache to store the minimum number of operation of all intermediate
		// considerations
		int cache[][] = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {

				if (i == 0)
					cache[i][j] = j;
				else if (j == 0)
					cache[i][j] = i;
				else if (i == j && str1.charAt(i - 1) == str2.charAt(j - 1)) {
					cache[i][j] = cache[i - 1][j - 1];
				} else {
					cache[i][j] = Math.min(cache[i - 1][j - 1],
							(cache[i - 1][j] < cache[i][j - 1]) ? cache[i - 1][j] : cache[i][j - 1]) + 1;
				}
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		for (int i[] : cache) {
			for (int j : i)
				System.out.print(j+" ");
			System.out.println();
		}
	}

}
