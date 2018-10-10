package mac.himanshu.dynamic;

/** All the permutations to make a coin
 * Coin Change where order matters which means 1,3 and 3,1 are different , NON DISTINCT SOLUTION
 * Given an infinite supply of certain denominations of coins , determine in how many ways can you get a change of 6 dollars

 * DP Solution:
 * 1. Let T[i] denote the total number of ways to form i'th dollar
 * 2. Update function : T[i] = summation ( T[i - Ci ]) where Ci is the ith coin , where (i - Ci ) > 0 
 * 3. As this is not a continuous series, its not a fibonacci like staircase, so make a check if i'th dollar can simply be obtained by using the single coin 
 * from the set of given coins , if yes then increment by 1.
 *  
 * @author himanshuchhabra
 *
 */
public class CoinChange1 {

	public static void main(String[] args) {
		// Denominations available
		int coins[] = { 1, 2,3};
		// doing this int coins[] = { 1, 2}; will give you the same ans as staircase
		// problem

		// Target Change to create
		int target = 3;

		int T[] = new int[target + 1];
		
		T[0] = 1;

		for (int i = 1; i <= target; i++) {

			for (int j = 0; j < coins.length; j++) {

				if (i - coins[j] >=0) {

					T[i] += T[i - coins[j]];

				}

			}
		}

		for (int i : T)
			System.out.println(i);
	}
}
