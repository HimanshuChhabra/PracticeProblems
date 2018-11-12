package com.himanshu.google;

import java.util.*;
import java.util.Map.Entry;

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
		
		map.put("ball", 2);
		map.put("apple", 3);
		
		map.keySet();
		Collection<Integer> ss = map.values();
		
		for(Integer i : ss) {
			
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
		
		List<Map.Entry<String, Integer>>  reg = new ArrayList<>(map.entrySet());
		
		System.out.println(reg);
		
		Collections.sort(reg,new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
				
			}

			
		});
		System.out.println(reg);
	}
}
