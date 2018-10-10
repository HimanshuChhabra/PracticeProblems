package com.himanshu.linkedin;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

	public static void main(String[] args) {
		int input[] = { 4, 5, 2, 2, 3, 3, 1, 1, 1 };
		List<Integer> arr = Arrays.stream(input).boxed().collect(Collectors.toList());

		//System.out.println(Arrays.stream(input).mapToObj(val -> val*=2).collect(Collectors.toList()));
		// List<Integer> result = frequencySort3(arr);
		 frequencySort4(arr);
		// System.out.println(result);
	}

	// nlogn solution too

	private static List<Integer> frequencySort2(int[] input) {

		if (input == null || input.length <= 0)
			return null;

		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		List<Integer> result = Arrays.stream(input).boxed().collect(Collectors.toList());

		for (Integer val : input) {
			if (freq.containsKey(val)) {
				freq.put(val, freq.get(val) + 1);
			} else {
				freq.put(val, 1);
			}
		}

		// nlogn
		Collections.sort(result, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				if (freq.get(o1) < freq.get(o2)) {
					return -1;
				} else if (freq.get(o1) > freq.get(o2)) {
					return 1;
				} else {
					if (o1 < o2)
						return -1;
					else {
						return 1;
					}
				}
			}
		});

		return result;
	}

	private static void frequencySort4(List<Integer> arr) {

		if (arr == null || arr.size() <= 0)
			return;

		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

		for (Integer val : arr) {
			if (freq.containsKey(val)) {
				freq.put(val, freq.get(val) + 1);
			} else {
				freq.put(val, 1);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				if (freq.get(o1) < freq.get(o2)) {
					return -1;
				} else if (freq.get(o1) > freq.get(o2)) {
					return 1;
				} else {
					if (o1 < o2)
						return -1;
					else {
						return 1;
					}
				}
			}

		});
		// n values are inserted , logn is insert time for heap, so nlogn
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();

			while (value > 0) {
				pq.add(key);
				value--;
			}
		}

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
