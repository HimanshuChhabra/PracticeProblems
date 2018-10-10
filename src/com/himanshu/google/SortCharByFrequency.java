package com.himanshu.google;

import java.util.*;

//451
public class SortCharByFrequency {

	public static void main(String args[]) {
		String s = "Aabb";
		String result = frequencySort(s);
		System.out.println(result);
	}

	public static String frequencySort(String s) {
		
		if(s == null || s.isEmpty())
			return "";

		Map<Character, Integer> freq = new HashMap<Character, Integer>();


		for (int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) + 1);
			} else {
				freq.put(c, 1);
			}
		}

		PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				if (freq.get(c1) > freq.get(c2))
					return -1;
				else if (freq.get(c1) == freq.get(c2))
					return 0;
				else
					return 1;
			}

		});

		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			queue.offer(entry.getKey());
		}

		StringBuffer result = new StringBuffer();
		while (!queue.isEmpty()) {
			char value = queue.poll();
			int occur = freq.get(value);

			while (occur > 0) {
				result.append(value);
				occur--;
			}
		}

		return result.toString();
	}

}
