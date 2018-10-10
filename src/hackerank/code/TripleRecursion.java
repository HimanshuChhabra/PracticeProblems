package hackerank.code;

import java.util.*;

public class TripleRecursion {

	static void tripleRecursion(int n, int m, int k) {
		int values[][] = new int[n][n];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i == 0 && j == 0){
					values[i][j] = m;
				}else if(i == j){
					values[i][j] = values[i-1][j-1] + k;
				}else if(i > j){
					values[i][j] = values[i-1][j] - 1;
				}else if(i < j){
					values[i][j] = values[i][j-1] -1;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				System.out.print(values[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		tripleRecursion(n, m, k);
		in.close();
	}

}
