package mac.himanshu.dynamic;

/**
 * Coin Change problem with DISTINCT SOLUTIONS , where 1,3 and 3,1 are same
 * Given an infinite supply of certain denominations of coins , determine in how many ways can you get a change of 6 dollars
 * 
 * DP Solution:
 *  // All the incoming coins should be sorted.
 * 1. Let T[i][j] represent the maximum possible ways to create the i'th dollar using 0 - j coins.
 * 2. Update Function : 
 * a. Total number of ways by excluding the new coin + Remainder's total number of ways by including the new coin
 * b. if Row < Column then this means that by including the new coins (j) its not going to affect the older one.
 * 
 * @author himanshuchhabra
 *
 */
public class CoinChange2 {

	public static void main(String[] args) {

		// All denominations
		int coins[] = { 1,2,3}; // this should be sorted

		int target = 4;
		int T[][] = new int[coins.length + 1][target + 1];

		for (int i = 0; i <= coins.length; i++) {
			for (int j = 0; j <= target; j++) {

				if (i == 0 && j == 0) {

					T[0][0] = 1;    					// Base case
					
				} else {
					if(i==0)
						continue;
					
					if (coins[i-1] > j) {
						
						T[i][j] = T[i - 1][j];
						
					} 
					else{
						T[i][j] = T[i - 1][j] + T[i][j - coins[i-1]];
					}
				}

			}
		}
		System.out.println(T[coins.length][target]);
		for (int[] i : T) {
			for (int j : i) {
				System.out.print(j + " ,");
			}
			System.out.println();
		}
	}
}

