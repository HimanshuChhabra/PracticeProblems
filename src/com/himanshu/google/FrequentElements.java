package com.himanshu.google;

import java.util.*;

public class FrequentElements {

	/**
	 * Kth frequent element to be located. O(nlogn) solution , Better can be
	 * achieved using heaps Main purpose is to understand how you can sort a Map
	 * based on values. if it was sorting with regards to keys, I would have used
	 * Tree Map.
	 * 
	 * 1.What if you are using a class which is not implementing Comparable interface , what if it is a third party library.
	 * you need a mechanism to specify your custom sort.
	 * 2.It allows you to provide more than one sorting strategy or some other parameter.maybe now sort using price , previously was ram.
	 * 3. Use multiple anonymous inner classes to sort using different parameters/Strategies
	 * @param args
	 */

	public static void main(String[] args) {

		String input[] = {"hello","hello","hello","hdldp","hdldp","hdldp","hdldp","hdldp","d","d","d","d","d","d","d"};
		calcFrquent(input, 2);

	}

	private static void calcFrquent(String[] strings, int k) {

		HashMap<String, Integer> frequencyTable = new HashMap<String, Integer>();

		for (String inp : strings) {

			Integer val = frequencyTable.get(inp);
			if (val == null)
				val = 0;
			frequencyTable.put(inp, ++val);
		}
		
		// this is how you can sort a map , basically get the list if Map.EntrySet and then sort it using a comparator
		// sorted in ascending order
		
		List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(frequencyTable.entrySet());
		
		Collections.sort(entries, new Comparator<Object>() {
			
			public int compare(Object o1 , Object o2) {
				Integer v1 = (Integer)((Map.Entry) o1).getValue();
				
				Integer v2 = (Integer)((Map.Entry)o2).getValue();
				
				return v1.compareTo(v2);
			}
		});
	
	
	}
}
