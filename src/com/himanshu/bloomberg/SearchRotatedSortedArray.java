package com.himanshu.bloomberg;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int ans = search(arr, 2);
		System.out.println(ans);
		
	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] <= nums[high]) { // right half is sorted

				if (target > nums[mid] && target <= nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			} else { 					// left half is sorted

				if (target >= nums[low] && target < nums[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}

		return -1;
	}

}

/*
 * If the last element is > than the first element then the array is sorted but not rotated. This is a good way to check if the array is rotated 
 */
