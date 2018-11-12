package mac.himanshu.dynamic;

import java.util.*;

/**
 * All the permutations to make a coin Coin Change where order matters which
 * means 1,3 and 3,1 are different , NON DISTINCT SOLUTION Given an infinite
 * supply of certain denominations of coins , determine in how many ways can you
 * get a change of 6 dollars
 * 
 * DP Solution: 1. Let T[i] denote the total number of ways to form i'th dollar
 * 2. Update function : T[i] = summation ( T[i - Ci ]) where Ci is the ith coin
 * , where (i - Ci ) > 0 3. As this is not a continuous series, its not a
 * fibonacci like staircase, so make a check if i'th dollar can simply be
 * obtained by using the single coin from the set of given coins , if yes then
 * increment by 1.
 * 
 * @author himanshuchhabra
 *
 */
public class CoinChange1 {

	public static void main(String[] args) {
		// Denominations available
		int coins[] = { 1, 3 };
		// doing this int coins[] = { 1, 2}; will give you the same ans as staircase
		// problem

		// Target Change to create
		int target = 7;

		int T[] = new int[target + 1];

		T[0] = 1;

		for (int i = 1; i <= target; i++) {

			for (int j = 0; j < coins.length; j++) {

				if (i - coins[j] >= 0) {

					T[i] += T[i - coins[j]];

				}

			}
		}

		System.out.println(T[T.length - 1] % (1000000007));

		System.out.println(numberOfWays(7));
	}

	public static int numberOfWays(int n) {
		// Denominations available
		int ways[] = { 1, 3 };

		if (n < 3)
			return 1;
		if (n == 3)
			return 2;

		int target = n;
		Integer sum = 0;
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);

		for (int i = 1; i <= target; i++) {

			for (int j = 0; j < ways.length; j++) {

				if (i - ways[j] >= 0) {
					sum += list.get(i - ways[j]);
				}

			}
			list.add(sum);
			sum = 0;
		}

		return list.get(list.size() - 1) % (1000000007);

	}
	
	/**
	 * def multiply(dp, dpM):
    result = [ [0,0,0],[0,0,0],[0,0,0] ]
  
    for i in range(0, 3):
        for j in range(0, 3):
            result[i][j] = 0
            for k in range(0, 3):
                temp = (dp[i][k] * dpM[k][j]) % 1000000007
                result[i][j] = (result[i][j] + temp) % 1000000007

    for i in range(0, 3):
        for j in range(0, 3):
            dp[i][j] = result[i][j]


def power(dp, n):
    if (n == 0 or n == 1):
        return
    
    dpM = [[0, 0, 1], [1, 0, 0], [0, 1, 1]]
    power(dp, n//2)
    multiply(dp, dp)
    if (n % 2 != 0):
        multiply(dp, dpM)


def numberOfWays(n):
    if (n < 3):
        return 1
    n += 1
    dp = [[0, 0, 1], [1, 0, 0], [0, 1, 1]]
    if (n == 0):
        return 0
    power(dp, n-1)
    for i in range(0, 3):
        for j in range(0, 3):
            print(dp[i][j], " ")

    return dp[2][2]

# def numberOfWays(n):
#     # Write your code here
#     if n < 3:
#         return 1

	public static int numberOfWays1(int n) {

		if (n < 3)
			return 1;
		
		Integer dpM[][] = {{0,0,1},{1,0,},{0,1,1}};
		if(n == 0)
			return 0;
		power()
		
		return list.get(list.size() - 1) % (1000000007);

	}
		 */
}
