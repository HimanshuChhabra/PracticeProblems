package com.himanshu.google;

import java.util.*;

public class FourSumProblem {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		
		System.out.println(fourSum(nums, -1));
	}
	
	public List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations, int truckCapacity){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				int x1 = o1.get(0);
				int y1 = o1.get(1);
				
				int x2 = o1.get(0);
				int y2 = o1.get(1);
				
				double dist1 = Math.sqrt(x1*x1 + y1*y1);
				double dist2 = Math.sqrt(x2*x2 + y2*y2);
			  return   (int) (dist1 - dist2);
			}
			
		});
		
		for(List<Integer> lists : allLocations)
			pq.add(lists);
		
		while(truckCapacity > 0) {
			res.add(pq.poll());
			truckCapacity--;
		}
			
		
		return res;
		
	}
	
	// [-4, -1, -1, 0, 1, 2]
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length == 0)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			int first = nums[i];
			if (result.size() != 0 && i > 0 && first == nums[i - 1])
				continue;

			for (int j = i + 1; j < nums.length - 2; j++) {
				int sec = nums[j];
				// so that we do not compare with the i'th value && check duplicates if there is atleast 1 item in result set
				if (j!= i+1 && result.size() != 0 && j > 0 && sec == nums[j - 1])
					continue;

				int left = j + 1, right = nums.length - 1;

				while (left < right) {
					int sum = first + sec + nums[left] + nums[right];
					if (sum == target) {
						result.add(Arrays.asList(first, sec, nums[left], nums[right]));

						left++;
						while (nums[left - 1] == nums[left] && left < right)
							left++;

						right--;
						while (nums[right + 1] == nums[right] && left < right)
							right--;

					} else if (sum < target) {
						left++;
						while (nums[left - 1] == nums[left] && left < right)
							left++;
					} else {
						right--;

						while (nums[right + 1] == nums[right] && left < right)
							right--;
					}
				}
			}
		}

		return result;
	}
	
}
