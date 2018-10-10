package com.himanshu.google;

import java.util.*;

public class Solution {
	

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		list.add(1);
		list.add(4);
		list.add(5);
		set.add(1);
		
		System.out.println(list.indexOf(5));
		
		Map<String,Integer> map = new HashMap<>();
		
		map.containsKey("");
		map.containsValue(1);
		
		map.keySet();
		Collection<Integer> ss = map.values();
		
		for(Integer i : ss) {
			
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
		
		
	}
}
