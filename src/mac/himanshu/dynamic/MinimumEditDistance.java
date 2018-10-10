package mac.himanshu.dynamic;

public class MinimumEditDistance {

	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "aab";

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

		for (int i[] : cache) {
			for (int j : i)
				System.out.print(j+" ");
			System.out.println();
		}
	}

}
