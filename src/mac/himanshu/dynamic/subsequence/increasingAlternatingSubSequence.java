package mac.himanshu.dynamic.subsequence;
/**
 * Max alternating increasing sequenece
 * This is similar to max increasing contiguous sub sequence
 * 
 * @author himanshuchhabra
 *
 */

public class increasingAlternatingSubSequence {

	public static void main(String[] args) {
		int arr[] = {3,10,2,-1,4,0,7};
		int maxLength = incrSubSeq(arr);
		System.out.println(maxLength);
	}
	
	private static int incrSubSeq(int[] arr) {
		int maxLength = 1;
		//L[i] is max increasing subsequence length upto i element.
		int L[] = new int[arr.length];
		//Every element is a subSeq of length 1
		for(int i = 0 ; i < arr.length ; i++){
			L[i] = 1;
		}
		
		for(int i = 2 ; i < arr.length ; i ++){
				if(arr[i] > arr [i-2]){
					L[i] = L[i-2]+1;
				}
			maxLength = Math.max(maxLength, L[i]);
		}
		
		return maxLength;
	}

}
