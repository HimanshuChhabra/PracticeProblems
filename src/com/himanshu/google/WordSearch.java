package com.himanshu.google;

import java.util.Arrays;
import java.util.*;

public class WordSearch {

	public static void main(String[] args) {
		/*
		 * char[][] board ={ {'A','B','C','E'}, {'S','C','C','C'}, {'A','D','E','E'} };
		 */

		/*
		 * char[][] board ={ {'a','b'}, {'c','d'}, };
		 */
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word = "ABCES E E E FS";
		boolean found = searchWord(board, word);
		System.out.println(found);
	}

	public static boolean searchWord(char[][] board, String word) {
		// once the first character matches run a DFS in all four direction
		if (word.length() == 0)
			return true;

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == word.charAt(0))
					if (dfs(board, i, j, word, 0))
						return true;
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, int i, int j, String word, int index) {
		// check out of bounce
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;

		char ch = board[i][j];
		// charcter mismatch or already visited
		if (ch != word.charAt(index) || ch == '*')
			return false;

		// last character match : base case
		if (index == word.length() - 1)
			return true;

		// All checks pass mark cell as visited
		board[i][j] = '*';
		boolean ans = dfs(board, i + 1, j, word, index + 1) || dfs(board, i - 1, j, word, index + 1)
				|| dfs(board, i, j + 1, word, index + 1) || dfs(board, i, j - 1, word, index + 1);

		// unmark visited for next iterations as board is passed by refrence, or create
		// and maintain a boolean vector for each iteration
		board[i][j] = ch;
		return ans;
	}

	/*
	 * public static boolean searchWord(char[][] board, String word) { if (word ==
	 * null || word.length() == 0) return true; int numRows = board.length; int
	 * numCols = board[0].length;
	 * 
	 * for (int i = 0; i < numRows; i++) { for (int j = 0; j < numCols; j++) { if
	 * (board[i][j] == word.charAt(0)) { Stack<Integer> stack = new
	 * Stack<Integer>(); boolean[][] visited = new boolean[numRows][numCols]; int id
	 * = i * numCols + j; stack.push(id); int count = 1, index = 0;
	 * 
	 * while (!stack.isEmpty()) { int cell = stack.pop(); int row = cell / numCols;
	 * int col = cell % numCols; count--; visited[row][col] = true;
	 * 
	 * if (board[row][col] == word.charAt(index)) { if (index == word.length() - 1)
	 * return true;
	 * 
	 * count = 0; index++;
	 * 
	 * if ((row - 1) >= 0 && !visited[row - 1][col]) { stack.push((row - 1) *
	 * numCols + col); count++; }
	 * 
	 * if ((row + 1) < numRows && !visited[row + 1][col]) { stack.push((row + 1) *
	 * numCols + col); count++; }
	 * 
	 * if ((col - 1) >= 0 && !visited[row][col - 1]) { stack.push(row * numCols +
	 * (col - 1)); count++; }
	 * 
	 * if ((col + 1) < numCols && !visited[row][col + 1]) { stack.push(row * numCols
	 * + (col + 1)); count++; }
	 * 
	 * } else if (count <= 0 && index > 0) { visited[row][col] = false; index--;
	 * }else { visited[row][col] = false;; } } } } }
	 * 
	 * return false; }
	 */
}
