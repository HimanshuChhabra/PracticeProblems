package mac.himanshu.dynamic;

/**
 * StairCase Problem In how many ways can a person climb stairs given the at
 * most possible steps allowed
 * 
 * DP Solution 
 * 1. Let S[i] Store the max/all possible ways to reach step i 
 * 2.Update Function S[i] = S[i - 1] + S[i - 2] + ... S[i - m] , provided (i - m >= 0) where m is the at most steps possible 
 * 3. At every step identify which are the possible second last or previous steps , and add the max possible ways.
 * 4. This is fibonacci series
 * 
 * 
 * @author himanshuchhabra
 *
 */
public class StaircaseProblem {

	public static void main(String[] args) {

		// at most 2 steps allowed , which means either 1 step or 2 steps allowed at a
		// time
		int steps = 2;
		// How many ways to reach step number 6
		int target = 2;

		int S[] = new int[target+1];

		// Base Conditions
		S[0] = 1; // Standing at the ground is possible in 1 way

		for (int i = 1; i <= target; i++) {
			int st = steps;
			while (st > 0) {
				if (i - st >= 0) {
					S[i] += S[i - st];
				}
				st--;
			}
		}
		
		System.out.println(S[target]);
	}
}
