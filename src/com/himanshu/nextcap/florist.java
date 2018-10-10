package com.himanshu.nextcap;

public class florist {

	public static void main(String[] args) {
		int florists[][] = {{0,1},{0,1},{0,1},{1,2},{1,2},{1,2}};//{{1,10} , {1,6} , {2,8} , {3,5}}; //{{0,5},{0,5},{0,5},{0,5},{0,5},{5,6},{6,7}};
		int path = 6;

		int result = calcFlorist(path,florists);
		System.out.println(result);

	}

	private static int calcFlorist(int path, int[][] florists) {
		int flag[] = new int[path]; 	// 0 - 0-1 , 1 - 1-2 , n - n - n+1
	
		int result = 0;
		
		for(int i = 0 ; i< florists.length ; i++) {
			boolean invalid = false;
			invalid = false;
			int low = florists[i][0];
			if(low >=path) {
				invalid = true;
			}
			int high = florists[i][1];
			if(high >= path)
				high = path - 1;
			else
				high--;
			
			for(int j = low ; j <=high ;j++ ) {
				if(flag[j] >= 3) {
					invalid = true;
					break;
				}
	
			}
			if(!invalid) {
				for(int j = low ; j <=high ;j++ ) {
					flag[j]++;
				}
				result++;
			}
		}
		
		return result;
	}
}
