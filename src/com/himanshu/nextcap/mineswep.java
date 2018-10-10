package com.himanshu.nextcap;

public class mineswep {

	static String[][] input = {{".","m",".","."} , {".",".",".","."} , {".",".",".","m"} , {"m",".",".","."}};
	static int output[][] = new int[input.length][input.length];
	static int size = input.length;

	public static void main(String[] args) {
		rule1();
	}

	private static void rule6() {
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0; j < size ; j++) {
				if(input[i][j].equals("m"))
					output[i][j] = -1;
			}
		}
	}



	private static void rule5() {
		boolean edit[][] = new boolean[size][size];
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0; j < size ; j++) {
				if(input[i][j].equals("m")) {

					if(i-1 >=0 && j+1 < size && !edit[i-1][j+1]) {
						output[i-1][j+1]*=2;
						edit[i-1][j+1] = true;
					}


					if(i+1 < size && j+1 < size && !edit[i+1][j+1]) {
						output[i+1][j+1]*=2;
						edit[i+1][j+1] = true;
					}


					if(i+1 < size && j-1 >= 0 && !edit[i+1][j-1]) {
						output[i+1][j-1]*=2;
						edit[i+1][j-1]=true;
					}


					if(i-1 >=0 && j-1 >=0 && !edit[i-1][j-1]) {
						output[i-1][j-1]*=2;
						edit[i-1][j-1]=true;
					}
				}
			}
		}
		rule6();
	}



	private static void rule4() {
		boolean edit[][] = new boolean[size][size];
		for(int i = 1 ; i < size ; i+=2) {
			for(int j = 0; j < size ; j++) {
				if(input[i][j].equals("m")) {
					for(int k = 0 ; k < size ; k ++) {
						if(!edit[i][k]) {
							output[i][k]*=3;
							edit[i][k] = true;
						}
					}
				}
			}
		}
		rule5();

	}

	private static void rule2_3() {

		for(int i = 0 ; i < size ; i++) {
			for(int j = 0; j < size ; j++) {
				if(input[i][j].equals("m")) {
					if(i+1 < size)
						output[i+1][j] = 2;

					if(j+1 < size ) 
						output[i][j+1] = 0;

				}
			}
		}
		rule4();
	
	}

	private static int[][] rule1() {
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0; j < size ; j++) {
				if(input[i][j].equals("m")) {

					if( i-1 >=0 && j-1 >=0)
						output[i-1][j-1]++;
					if(i-1>=0)
						output[i-1][j]++;
					if(i-1 >= 0 && j+1 < size)
						output[i-1][j+1]++;

					if(j-1>=0)
						output[i][j-1]++;

					if(j+1 < size)
						output[i][j+1]++;

					if(i+1 < size && j-1 >= 0)
						output[i+1][j-1]++;

					if(i+1 < size)
						output[i+1][j]++;

					if(i+1 <size && j+1 < size)
						output[i+1][j+1]++;
				}
			}
		}
		rule2_3();
	return output;
	}
}


