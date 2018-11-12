package com.himanshu.bloomberg;

public class ReaarangeZeros {

	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 1, 0, 3, 12 });
	}

	public static void moveZeroes(int[] nums) {
		if (nums.length == 0)
			return;

		boolean swap = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int j = i + 1;
				while (j < nums.length) {
					if (nums[j] != 0) {
						swap = true;
						break;
					} else {
						j++;
					}
				}
				if (swap) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
			swap = false;
			System.out.println(nums[i]);
		}
	}

}
