package mac.himanshu.dynamic.subsequence;

import java.util.*;

public class increasingContiSubsequence {
	static int arr[] = {3,10,2,-1,0,20,21};
	static int path[] = null;
	static int maxLengthIndex ;
	public static void main(String[] args) {
		int arr[] = {3,10,2,-1,0,20,21};
		path = new int[arr.length];
		int maxLength = incrSubSeq(arr);
		System.out.println(maxLength);
		getPath();
	}

	private static void getPath() {
		List<Integer> resultSet = new ArrayList<Integer>();
		while(maxLengthIndex != path[maxLengthIndex]) {
			resultSet.add(arr[maxLengthIndex]);
			maxLengthIndex = path[maxLengthIndex];
		}
		resultSet.add(arr[maxLengthIndex]);
		Collections.reverse(resultSet);
		System.out.println(resultSet);
	}

	private static int incrSubSeq(int[] arr) {
		int maxLength = 1;
		//L[i] is max increasing subsequence length upto i element.
		int L[] = new int[arr.length];
		L[0] = 1;
		path[0] = 0;
		maxLengthIndex = 0;
		
		for(int i = 1 ; i < arr.length ; i ++){
			L[i] = (arr[i] > arr [i-1]) ? L[i-1]+1 : 1;
			
			path[i] = (L[i] == L[i-1]+1)? i-1 : i;
			
			maxLength = Math.max(maxLength, L[i]);
			
			if(maxLength == L[i]) maxLengthIndex = i;
			
		}
		return maxLength;
	}

}
