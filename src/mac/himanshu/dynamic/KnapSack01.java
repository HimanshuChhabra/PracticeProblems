package mac.himanshu.dynamic;

/**
 * Classical 0/1 Knapsack problem 
 * 
 * Intuition : to divide the knapsack weight across multiple knapsacks and consider every item and check if that item can fit into that knapsack
 * if yes then take the Max of(the current value excluding the new item , the value of the new item + the value of the remainder weight if any)) 
 * 1. Let T[i][j] store the max value of the i'th weight in the j'th knapsack.																																						
 * 
 * @author himanshuchhabra
 *
 */
public class KnapSack01 {

	public static void main(String[] args) {

		// All Weights
		
		int weights[] = {4,5,1}; 
		int values[] = {1,2,3};

		int target = 60;
		//System.out.println(solution(target, 3, weights, values));
		
		int T[][] = new int[weights.length+1][target + 1];

		for (int i = 0; i <= weights.length; i++) {
			for (int j = 0; j <= target; j++) {

				if (i == 0 || j == 0) {

					T[i][j] = 0;    					// Base case
					
				} else {
					
					if (weights[i-1] <= j) {
						
						T[i][j] = Math.max(T[i - 1][j], values[i-1] + T[i-1][j-weights[i-1]]);
						
					} 
					else {
						T[i][j] = T[i - 1][j];
					}
				}

			}
		}
		
		System.out.println(T[weights.length][target]);
		
		for (int[] i : T) {
			for (int j : i) {
				System.out.print(j + " ,");
			}
			System.out.println();
		}
	}
	
	public static boolean solution(int total_money, int total_damage, int[] costs, int[] damages) {
		if (costs.length <= 0 || damages.length <= 0 || total_money <= 0)
			return false;

		int damageCaused[][] = new int[costs.length + 1][total_money + 1];

		for (int i = 0; i <= costs.length; i++) {
			for (int j = 0; j <= total_money; j++) {

				if (i == 0 || j == 0) {

					damageCaused[i][j] = 0; // Base case

				} else {

					if (costs[i - 1] <= j) {

						damageCaused[i][j] = Math.max(damageCaused[i - 1][j],
								damages[i - 1] + damageCaused[i - 1][j - costs[i - 1]]);

					} else {
						damageCaused[i][j] = damageCaused[i - 1][j];
					}
				}

			}
		}

		int maxDamageCaused = damageCaused[costs.length][total_money];

		if (maxDamageCaused >= total_damage)
			return true;
		else
			return false;
  
    }
}
