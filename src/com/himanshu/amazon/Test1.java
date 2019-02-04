package com.himanshu.amazon;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {

	}

	public int[][] kClosest(int[][] points, int K) {

		if (points == null || points.length == 0)
			return points;

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] i, int[] j) {
				int d1 = (int) Math.sqrt(i[0] * i[0] + i[1] * i[1]);
				int d2 = (int) Math.sqrt(j[0] * j[0] + j[1] * j[1]);

				return d2 - d1;
			}
		});

		for (int[] i : points) {
			pq.add(i);
			if (pq.size() > K)
				pq.poll();
		}

		int[][] result = new int[pq.size()][pq.size()];

		int index = 0;
		for (int[] i : pq) {
			result[index]= i;
			index++;
		}
		
		return result;
	}
}
