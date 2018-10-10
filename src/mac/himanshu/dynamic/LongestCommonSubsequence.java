package mac.himanshu.dynamic;

/**
 * if character matches , copy from diagonal and add 1 , else take max of upper cell and left cell
 * @author himanshuchhabra
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "abcvdefgh";
		String str2 = "bqdrcvefgh";

		int L[][] = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <=str1.length(); i++) {
			for (int j = 0; j <=str2.length(); j++) {

				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else {
					char ch = str1.charAt(i-1);

					if (ch == str2.charAt(j-1)) {
						L[i][j] = L[i - 1][j - 1] + 1;
					} else {
						L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
					}
				}
			}
		}

	System.out.println(L[str1.length()][str2.length()]);
	}
}
