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
public class CuttingRodProblem {

	public static void main(String[] args) {

		// All Weights
		int rodLengths[] = {1,2,3,4}; // this should be sorted
		int values[] = {2,5,9,6};

		int target = 5;
		
		int T[][] = new int[rodLengths.length+1][target + 1];

		for (int i = 0; i <= rodLengths.length; i++) {
			for (int j = 0; j <= target; j++) {

				if (i == 0 || j == 0) {

					T[i][j] = 0;    					// Base case
					
				} else {
					
					if (rodLengths[i-1] <= j) {
						
						T[i][j] = Math.max(T[i - 1][j], values[i-1] + T[i][j-rodLengths[i-1]]);
						
					} 
					else {
						T[i][j] = T[i - 1][j];
					}
				}

			}
		}
		
		System.out.println(T[rodLengths.length][target]);
		
		for (int[] i : T) {
			for (int j : i) {
				System.out.print(j + " ,");
			}
			System.out.println();
		}
	}
}
