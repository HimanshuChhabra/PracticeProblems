package com.himanshu.google;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] matrix = { { 5, 1, 9, 11 }, 
						   { 2, 4, 8, 10 },
						   { 13, 3, 6, 7 },
						   { 15, 14, 12, 16 } };
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2 + n % 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int[] tmp = new int[4];
				int row = i;
				int col = j;
				for (int k = 0; k < 4; k++) {
					tmp[k] = matrix[row][col];
					int x = row;
					row = col;
					col = n - 1 - x;
				}
				for (int k = 0; k < 4; k++) {
					matrix[row][col] = tmp[(k + 3) % 4];
					int x = row;
					row = col;
					col = n - 1 - x;
				}
			}
		}
	}

}
