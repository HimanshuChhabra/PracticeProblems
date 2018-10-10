package com.himanshu.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<Integer> uniformWeightSet = new HashSet<Integer>();
		
		String str = scan.nextLine();
		scan.close();
		
		int weight = 0;
		
		for(int i =  0 ; i< str.length() ; i++) {
			if(i != 0) {
				if(str.charAt(i) == str.charAt(i-1)) {
					weight += str.charAt(i) - 96;
					uniformWeightSet.add(weight);
				}else {
					uniformWeightSet.add(weight);
					weight = str.charAt(i) - 96;
					uniformWeightSet.add(weight);
				}
			}else {
				weight += str.charAt(i) - 96;
				uniformWeightSet.add(weight);
			}
		}
		uniformWeightSet.add(weight);
		System.out.println(uniformWeightSet);
	}

}


