package com.himanshu.google;

import java.util.*;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 0, 0, 0, 0, 1, 0 }, 
						 { 0, 0, 0, 0, 0, 1, 1, 1 } };
		int ans = maxAreaOfIsland(grid);
		System.out.println(ans);

	}
	// checkout leet code solution it is a good DFS format, return 1  + all-sides, 1 as this was already 1 , all sites will return their best
	public static int maxAreaOfIsland(int[][] grid) {
		int ans = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int count = 0;
					grid[i][j] = 0;
					Queue<Integer> q = new LinkedList<Integer>();
					q.add(i * cols + j);
					while (!q.isEmpty()) {
						int id = q.poll();
						int r = id / cols;
						int c = id % cols;
						count++;

						if (r - 1 >= 0 && grid[r - 1][c] == 1) {
							grid[r - 1][c] = 0; // mark it aas visited
							q.add((r - 1) * cols + c);
						}

						if (r + 1 < rows && grid[r + 1][c] == 1) {
							grid[r + 1][c] = 0;
							q.add((r + 1) * cols + c);
						}

						if (c - 1 >= 0 && grid[r][c - 1] == 1) {
							grid[r][c - 1] = 0;
							q.add(r * cols + (c - 1));
						}

						if (c + 1 < cols && grid[r][c + 1] == 1) {
							grid[r][c + 1] = 0;
							q.add(r * cols + (c + 1));
						}
					}
					ans = Math.max(ans, count);
				}
			}
		}
		return ans;
	}

}
