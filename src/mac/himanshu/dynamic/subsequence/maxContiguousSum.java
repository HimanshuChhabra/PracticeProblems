package mac.himanshu.dynamic.subsequence;
/**
 * Find max contiguous sum subsequence.
 * Contiguous with regards to the indices and not the values.
 * DP approach : S[i] will save the sum with ith element being the last element in the sequence
 * Update function:
 * O(n) approach
 * S[i] = Max{S[i-1] + A[i], A[i]}
 * 
 * @author himanshuchhabra
 *
 */
public class maxContiguousSum {
	
	static int arr[] = {6,2,4,-1,3};
	static int  path[] = null;					// path holds the index value of the state from which the result set was made.
	static int maxIndex ;
	public static void main(String[] args) {
		path = new int[arr.length];	
		int maxSum = maxContiSubSeq();
		System.out.println(maxSum);
		getPath();
	}

	private static void getPath() {
		while(maxIndex != path[maxIndex]) {
			System.out.println("Val: " + arr[maxIndex]);
			maxIndex = path[maxIndex];
		}
		System.out.println("Val: " + arr[maxIndex]);
	}

	private static int maxContiSubSeq() {
		int maxSum = arr[0];
		int S[] = new int[arr.length];
				
		S[0] = arr[0];
		path[0] = 0;
		maxIndex = 0;
		
		//O(n) approach
		for(int i = 1; i < arr.length ; i ++ ){
			S[i] = Math.max(S[i-1] +arr[i], arr[i]);
			
			if(S[i] == S[i-1] + arr[i])
				path[i] = i-1;
			else
				path[i] = i;
			
			maxSum = Math.max(maxSum, S[i]);			//since its  contiguous we compare current element with its prev element
			if(maxSum == S[i])
				maxIndex = i;
		}

		return maxSum;
	}

}
