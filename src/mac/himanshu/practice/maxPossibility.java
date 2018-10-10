package mac.himanshu.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class maxPossibility {
	static int i = 0;
	static ArrayList<Integer> S;
	static int sum = 0;
	static ArrayList<Integer> list;
	static ArrayList<Integer> input;
	static ArrayList<Integer> newList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		input = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
             int n = in.nextInt();
             input.add(n);
        }
		//int n = 1;
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		
		newList.addAll(list);
		S = new ArrayList<Integer>();
		for(int j : input){
			int n = j;
			Collections.sort(list);
			for(int i = 0 ; i < list.get(0) ; i ++){
				S.add(i,0);
			}
			
			S.add(list.get(0), 1); //base case
			i = 1+list.get(0);
			int val = calPossibility(n);
			System.out.println(val);
		}
		
	}

	private static int calPossibility(int n) {
		if(n == 0 )
			return 0;
		do{
			for(int j : list){
				if(i - j > 0 ){
					sum+=S.get(i-j);
					//list.remove(j);
				}
			}
			if(list.contains(i)){
				sum++;
			}
			S.add(i, sum);
			i++;
			sum = 0;
			list.clear();
			list.addAll(newList);
		}while(i <= n);
		
		
		return S.get(n);
	}

}
