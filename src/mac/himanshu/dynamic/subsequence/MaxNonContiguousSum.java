package mac.himanshu.dynamic.subsequence;
/**
 * Find max non - contiguous sum subsequence.
 * For all incoming edges , select the one which has the max sum value say S[j] offers best sum
 * Compare , Max(S[j]+A[i] , A[i] ) this is S[i]; j < i
 * 
 * @author himanshuchhabra
 *
 */
public class MaxNonContiguousSum {

	public static void main(String[] args) {
		int arr[] = {-6,2,-4,1,3};
		int maxLength = maxNonContiSubSeq(arr);
		System.out.println(maxLength);
	}

	private static int maxNonContiSubSeq(int[] arr) {
		int maxSum = arr[0];
		int S[] = new int[arr.length];
		
		for(int i = 0 ; i <arr.length ; i++)
			S[i] = arr[i];
		
		//O(n2)
		for(int i = 1; i < arr.length ; i ++){
			for(int j = 0 ; j < i ; j++){				//all previous values are the incoming edges.
				S[i] = Math.max(S[j]+arr[i] , S[i]);
			}
			maxSum = Math.max(maxSum, S[i]);
		}
		
		
		return maxSum;
	}

}
