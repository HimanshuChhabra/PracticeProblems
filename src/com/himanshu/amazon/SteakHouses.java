package com.himanshu.amazon;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SteakHouses {

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		result.add(l1);

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		result.add(l2);

		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(-1);
		result.add(l3);

		System.out.println(nearestXSteakHouses(3, result, 2));

	}
// allLocations.stream().distinct().collect(Collectors.toList())
	public static List<List<Integer>> nearestXSteakHouses(int totalSteakHouses, List<List<Integer>> allLocations,
			int numSteakHouses) {

		if (totalSteakHouses < numSteakHouses || allLocations == null || allLocations.size() <= 0)
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				double distance1 = Math.sqrt((l1.get(0) * l1.get(0)) + (l1.get(1) * l1.get(1)));
				double distance2 = Math.sqrt((l2.get(0) * l2.get(0)) + (l2.get(1) * l2.get(1)));

				if (distance1 < distance2) {
					return -1;
				} else if(distance1 > distance2){
					return 1;
				}else {
					return 0;
				}
			}
		});
		// O (n Logn)
		for (List<Integer> list : allLocations) {
			queue.add(list);
		}

		while (numSteakHouses > 0) {
			result.add(queue.poll());
			if (queue.isEmpty())
				break;

			numSteakHouses--;
		}

		return result;
	}
	
	/**
	 * 
	 * I have made use of a priority queue which internally acts like a min-max heap
	 * The comparator passed to the priority queue makes it function like a min-heap
	 * Min  heaps maintain the min value as the root node, insert time is O (log n) and removal or poll time is also O (log n) 
	 * Overall complexity is O (n Logn) , as we need to add all the elements into the priority queue / heap before
	 * 
	 */
}
