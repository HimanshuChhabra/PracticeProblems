package com.himanshu.bloomberg;

import java.util.*;

public class MergeIntervals {

	public static void main(String args[]) {
		Interval n1 = new Interval(1, 3);
		Interval n2 = new Interval(2, 6);
		Interval n3 = new Interval(8, 10);
		Interval n4 = new Interval(15, 18);

		List<Interval> list = new ArrayList<Interval>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		
		Map<String,Integer> map = new HashMap<>();
		map.put("dd", 1);
		Map<String,Integer> map2 = new HashMap<>(map);
		map2.put("dd", 2);
		
		map.putAll(map2);
		
		System.out.println(map);

		System.out.println(merge(list));

	}
// Creating linkedList will be O(n) , Sort will be nLogn , Remove will be O(1)
	public static List<Interval> merge(List<Interval> intervals) {

		if (intervals != null && intervals.isEmpty() || intervals != null && intervals.size() == 1)
			return intervals;

		// O(n)
		LinkedList<Interval> queue = new LinkedList<Interval>(intervals);

		// (nlogn)
		Collections.sort(queue, new Comparator<Interval>() {

			public int compare(Interval i, Interval j) {
				return i.start - j.start;
			}
		});

		List<Interval> result = new ArrayList<Interval>();

		// O(1)
		Interval int1 = queue.removeFirst();

		while (!queue.isEmpty()) {
			// O(1)
			Interval int2 = queue.removeFirst();

			if (int2 != null) {
				if (int1.end >= int2.start) {
					int1.end = Math.max(int1.end, int2.end);
				} else {
					result.add(int1);
					int1 = int2;
				}
			}
		}

		result.add(int1);

		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

/**
 * 
 * create a priority queue will be nlogn, remove operation will be nlogn , 2 nlogn , above apprraoch is slightly better, 

 * 
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 * 
 * class Solution { public List<Interval> merge(List<Interval> intervals) {
 * 
 * if(intervals != null && intervals.isEmpty() || intervals != null &&
 * intervals.size() == 1) return intervals;
 * 
 * PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new
 * Comparator<Interval>(){
 * 
 * public int compare(Interval i , Interval j){ return i.start - j.start; } });
 * 
 * List<Interval> result = new ArrayList<Interval>(); Interval int1 =
 * queue.poll();
 * 
 * while(!queue.isEmpty()){
 * 
 * Interval int2 = queue.poll();
 * 
 * if(int2 != null){ if(int1.end >= int2.start ){ int1.end = int2.end; } }else{
 * result.add(int1); int1 = int2; } }
 * 
 * return result; } }
 * 
 * /* 1. Sort with respect to the start time, make use of a priotity min heap 2.
 * Compare that if endtime >= start time, merge them
 * 
 * if( they overlap , merge and insert){ }else if(they dont overlap){
 * 
 * put first one into result set put the second one inside the queue so that it
 * can be compared again
 * 
 * repeat until queue is empty }
 */