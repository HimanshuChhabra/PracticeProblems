package com.himanshu.google;

public class TwoFruitBasket {

	public static void main(String[] args) {
		int A [] = {1,2,1,3,4,3,3,5,5,3,5,3,3,5,1};
		int ans = solution(A);
		System.out.println(ans);

	}

	public static int solution(int[] A) {
		int max = Integer.MIN_VALUE;				// initializing max with minimum value
		if (A == null || A.length == 0)
			return 0;

		for (int i = 0; i < A.length; i++) {
			int count = 0;
			int first = A[i]; count++;				
			int second = 0;
			if (i + 1 < A.length) {
				second = A[i + 1];
				count++;
			}
			i+=2;
			
			// incrementing the count each time a number/fruit encountered is same as value stored either in first or second
			while(i < A.length) {
				
				if(A[i] == first || A[i] == second) {
					count++;
					i++;
				}else {
					i-=2;
					break;
				}
			}
			
			max = Math.max(max, count);			// Updating the max variable incase a better count is encountered

		}

		return max;
	}

}
