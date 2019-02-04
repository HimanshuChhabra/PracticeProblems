package mac.himanshu.dynamic.subsequence;
/**
 * Find length of Longest Increasing Subsequence problem
 * Compare all in the previous possible solutions and take the best one
 * 
 * Update Function
 * L[i] = Max[L[j] , (i,j) belongs to E , i > j]
 * 
 * @author himanshuchhabra
 *
 */

import java.util.*;

public class IncreasingNonContSubsequence {
	
	static int path[] = null;
	static int arr[] = {10,9,2,5,3,7,101,18};
	static int maxLengthIndex ;
	public static void main(String[] args) {
		path = new int[arr.length];
		int maxLength = incrSubSeq(arr);
		System.out.println(maxLength);
		getPath();
	}

	private static void getPath() {
		List<Integer> sequence = new ArrayList<Integer>();
		
		while(maxLengthIndex != path[maxLengthIndex]) {
			sequence.add(arr[maxLengthIndex]);
			maxLengthIndex = path[maxLengthIndex];
		}
		
		sequence.add(arr[maxLengthIndex]);
		Collections.reverse(sequence);
		System.out.println(sequence);
		
	}

	private static int incrSubSeq(int[] arr) {
		int maxLength = 1;
		//L[i] is max increasing subsequence length upto i element.
		int L[] = new int[arr.length];
		maxLengthIndex = 0;
		//Every element is a subSeq of length 1
		for(int i = 0 ; i < arr.length ; i++){
			L[i] = 1;
			path[i] = i;
		}
		
		for(int i = 1 ; i < arr.length ; i ++){
			for(int j = 0 ; j < i ; j ++){
				if(arr[i] > arr [j]){
					L[i] = Math.max(L[i],L[j]+1);
					
					if(L[i] == L[j]+1) path[i] = j ;
				}
			}
			maxLength = Math.max(maxLength, L[i]);
			if(maxLength == L[i]) maxLengthIndex = i;
		}
		
		return maxLength;
	}

}
