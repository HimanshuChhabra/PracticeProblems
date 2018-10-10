package com.himanshu.linkedin;

import java.util.*;

public class SocialMedia {

	// index is the user id, values indicate num of people in that group.
	public static void main(String[] args) {
		int input[] = { 2,3, 3, 2,3, 3, 3, 1, 3,};
		printValidGroups(input);

	}

	private static void printValidGroups(int[] input) {
		
		if(input == null || input.length <= 0)
			return;
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		PriorityQueue<List<Integer>> resultQueue = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {

			// Indexes will remain unique.
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				if (o1.get(0) < o2.get(0)) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		// prepare a map of which user, belongs to which group cat. This will by default
		// sort the list
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				List<Integer> list = map.get(input[i]);
				list.add(i);
				map.put(input[i], list);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(input[i], list);
			}
		}

		System.out.println(map);

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int key = entry.getKey();
			List<Integer> value = entry.getValue();
			int noOfGroups = value.size() / key;
			int index = 0;
			boolean flag = true;
			for (int i = 0; i < noOfGroups; i++) {
				List<Integer> validGroup = new ArrayList<Integer>();
				int count = key;
				while (count > 0) {
					if (index >= value.size()) {
						flag = false;
						break;
					}
					validGroup.add(value.get(index)); // safety check
					index++;
					count--;
				}

				if (flag)
					resultQueue.add(validGroup);
				else
					break;
			}
		}

		while (!resultQueue.isEmpty()) {
			System.out.println(resultQueue.poll());
		}
	}
}
