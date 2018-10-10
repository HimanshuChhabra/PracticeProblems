package com.himanshu.google;

import java.util.*;

public class findOdd {

	public static void main(String[] args) {
		int input[] = {1,3,1,4,3};
		List<Integer> list = new ArrayList<Integer>();

		for (Integer i : input) {
			if (list.contains(i)) {
				list.remove(i);
			} else {
				list.add(i);
			}
		}
		
		System.out.println(list);
	}
}
