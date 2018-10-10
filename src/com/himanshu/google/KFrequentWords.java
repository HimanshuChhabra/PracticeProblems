package com.himanshu.google;

import java.util.*;

public class KFrequentWords {

	public static void main(String[] args) {
		String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		int k = 4;
		List<String> topK = findKFrequentWords(words, k);
		System.out.println(topK);
	}

	private static List<String> findKFrequentWords(String[] words, int k) {
		Map<String, Integer> freq = new HashMap<String, Integer>();
		List<String> result = new ArrayList<String>();
		
		if (words.length <= 0 || k <= 0)
			return result;

		for (String word : words) {
			if (freq.containsKey(word)) {
				freq.put(word, freq.get(word) + 1);
			} else {
				freq.put(word, 1);
			}
		}
		System.out.println(freq);

		PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (freq.get(s1) > freq.get(s2))
					return -1;
				else if (freq.get(s1) == freq.get(s2))
					return s1.compareTo(s2);
				else
					return 1;
			}

		});

		for (Map.Entry<String, Integer> word : freq.entrySet()) {
			queue.add(word.getKey());
		}

		while (k > 0) {
			result.add(queue.poll());
			if (queue.isEmpty())
				break;
			k--;
		}

		return result;
	}

}
