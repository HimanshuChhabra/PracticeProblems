package com.himanshu.google;

import java.util.*;

public class BullsCows {

	public static void main(String[] args) {
		String secret = "1807";
		String guess = "7810";

		System.out.println(getHint(secret, guess));

	}

	public static String getHint(String secret, String guess) {
		Map<Character, HashSet<Integer>> map = new HashMap<>();
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			char ch = secret.charAt(i);
			if (map.containsKey(ch)) {
				map.get(ch).add(i);
				freq.put(ch, freq.get(ch) + 1);
			} else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(i);
				map.put(ch, set);
				freq.put(ch, 1);
			}
		}

		int bull = 0, cow = 0;
		HashSet<Integer> visited = new HashSet<Integer>();

		for (int i = 0; i < guess.length(); i++) {
			char ch = guess.charAt(i);
			if (freq.containsKey(ch) && freq.get(ch) > 0) {
				HashSet<Integer> set = map.get(ch);
				if (set != null) {
					if (set.contains(i)) {
						bull++;
						visited.add(i);
						freq.put(ch, freq.get(ch) - 1);
					}
				}	
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			char ch = guess.charAt(i);
			if (!visited.contains(i) && freq.containsKey(ch) && freq.get(ch) > 0) {
				cow++;
				freq.put(ch, freq.get(ch) - 1);
			}
		}

		return bull + "A" + cow + "B";
	}
}
