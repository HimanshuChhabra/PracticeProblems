package com.himanshu.google;

public class MinimumMatrixPath {

	public static void main(String[] args) {
		int[][] input = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		minPathSum(input);
	}
	 public static int minPathSum(int[][] grid) {
	        
	        int res[][] = new int[grid.length][grid[0].length];
	        
	        for(int i = 0 ; i < grid.length ; i++){
	            for(int j = 0 ; j < grid[0].length ; j++){
	                if(i == 0 && j == 0)
	                    res[i][j] = grid[i][j]; //base case
	                else{                    
	                    if(i == 0 ){
	                      res[i][j] = grid[i][j] + res[i][j-1];
	                    }else if(j == 0 ){
	                      res[i][j] = grid[i][j] + res[i-1][j];
	                    }else{
	                        res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
	                    }   
	                }
	            }          
	        }
	        
	        return res[res.length - 1][res[0].length - 1];
	    }
}
