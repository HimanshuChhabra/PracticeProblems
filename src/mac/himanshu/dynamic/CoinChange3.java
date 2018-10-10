package mac.himanshu.dynamic;

/**
 * Given a set of denominations determine the minimum number of coins required to form 6 dollars 
 * @author himanshuchhabra
 *
 *1. The approach is similar to the coinchange1 problem but here instead of finding all the ways for the i'th dollar we will store the
 *   minimum number of coins to form that i'th dollar
 *2. Let F[i] store the minimum number of  coins to form the i'th dollar
 *3. Update Function F[i] = Min [i - Cj] + 1  where Cj are all the denominations.
 */
public class CoinChange3 {

	public static void main(String[] args) {

		int coins[] = { 1,2,3 };
		int target = 6;
		int F[] = new int[target + 1];

		// Base condition
		F[0] = 0;
		for (int i = 1; i <= target; i++) {

			for (int j = 0; j < coins.length; j++) {

				if (i - coins[j] >= 0) {
					if (F[i] == 0) {
						F[i] = F[i - coins[j]] + 1;
					} else {
						F[i] = Math.min(F[i], F[i - coins[j]]) + 1;
					}
				}
			}
		}

		for (int i : F)
			System.out.println(i);
	}
}
