package com.himanshu.google;

public class TicTacToe {

	public static void main(String[] args) {
	
		
		TicTacToe t = new TicTacToe(2);
		t.move(0, 1, 1);
		t.move(1, 1, 2);
		t.move(1, 0, 1);
	}

	/** Initialize your data structure here. */
	int board[][] = null;

	public TicTacToe(int n) {
		board = new int[n][n];

	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		board[row][col] = player;

		int temp = 0;
		boolean found = true;
		// check vertical choices if its a win
		while (temp < board.length) {

			if (board[temp][col] != player) {
				found = false;
				break;
			}
			temp++;
		}

		if (found) {
			return player; // return winner
		} else {
			// check horizontal choices if its a win
			temp = 0;
			found = true;
			while (temp < board.length) {
				if (board[row][temp] != player) {
					found = false;
					break;
				}
				temp++;
			}
			if (found) {
				return player;
			} else if (row == col) {
				// check diagonals
				int i = 0, j = 0;
				found = true;

				while (i < board.length && j < board.length) {
					if (board[i][j] != player) {
						found = false;
						break;
					}
					i++;
					j++;
				}

				if (found) {
					return player;
				} else {
					i = 0;
					j = board.length - 1;
					found = true;

					while (i < board.length && j >= 0) {
						if (board[i][j] != player) {
							found = false;
							break;
						}
						i++;
						j--;
					}

					if (found)
						return player;
					else
						return 0;
				}
			}
		}
		return 0;
	}

	/**
	 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
	 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
	 */

	/*
	 * Let Player 1 X be 1 Let Player 2 0 be 2 By default value is means its no
	 * occupied.
	 * 
	 */
}
