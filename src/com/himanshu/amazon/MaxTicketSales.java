package com.himanshu.amazon;

import java.util.*;
import java.util.PriorityQueue;

public class MaxTicketSales {

	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(2, 2, 5);
	
		/*
		long ans = test(list, 4);
		System.out.println(ans);*/
	}

	public static long maximumAmount(List<Integer> a, long k) {
		long ans = 0;

		if (a.size() == 0)
			return ans;

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			public int compare(Integer i, Integer j) {
				return -1 * (i - j);
			}
		});

		// nLogn
		for (int value : a)
			queue.add(value);

		boolean next = false;
		int val = queue.poll();
		while (k > 0 && !queue.isEmpty()) {
			if (next) {
				val = queue.poll();
				next = false;
			}
			ans += val;
			k--;
			val--;
			if (val < queue.peek()) {
				queue.add(val);
				next = true;
			}
		}

		return ans;
	}

	public static long test(List<Integer> a, long k) {

		long ans = 0;

		if (a.size() == 0)
			return ans;
		// nlogn
		Collections.sort(a);

		int maxAvail = a.get(a.size() - 1);
		int[] cache = new int[maxAvail + 1];

		// O(n)
		// count the frequency of the avail tickets
		for (int i = 0; i < a.size(); i++) {
			cache[a.get(i)]++;
		}

		int index = cache.length - 1;

		while (k > 0) {

			if (cache[index] > 0) {
				if( k >= cache[index]) {
					int val = cache[index];
					ans+=(index * val);
					k-=val;
					cache[index] = 0;
					cache[index - 1]+=val;
				}else {
					ans+=(index * k);
					k = 0;
					/*ans += index;
					k--;
					cache[index]--;
					cache[index - 1]++;*/
				}
				
				
			} else {
				index--;
			}
		}

		return ans;
	}
	
	public static long test3(List<Integer> a, long k) {

		long ans = 0;

		if (a.size() == 0)
			return ans;
		// nlogn
		Collections.sort(a);
		

		int maxAvail = a.get(a.size() - 1);
		int[] cache = new int[maxAvail + 1];

		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int key : a) {
			if (freqMap.containsKey(key)) {
				freqMap.put(key, freqMap.get(key) + 1);
			} else
				freqMap.put(key, 1);
		}

		int index = cache.length - 1;

		while (k > 0) {

			if (cache[index] > 0) {
				ans += index;
				k--;
				cache[index]--;
				cache[index - 1]++;
			} else {
				index--;
			}
		}

		return ans;
	}

	public static long test2(List<Integer> a, long k) {
		if (a.size() == 0)
			return 0;

		Collections.sort(a);
		int fact = 1;
		int count = 0;
		long res = 0;
		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int key : a) {
			if (freqMap.containsKey(key)) {
				freqMap.put(key, freqMap.get(key) + 1);
			} else
				freqMap.put(key, 1);
		}

		int keyIndex = a.get(a.size() - 1);

		while (count < k) {
			fact = freqMap.getOrDefault(keyIndex, fact);
			res += keyIndex * fact;
			keyIndex--;
			count += fact;
			if (freqMap.containsKey(keyIndex))
				freqMap.put(keyIndex, freqMap.get(keyIndex) + fact);
		}

		keyIndex++;
		while (count > k) {
			count--;
			res -= keyIndex;
		}

		return res;
	}
	
	
}
