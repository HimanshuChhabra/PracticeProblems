package com.himanshu.bloomberg;

public class TrapWater {

	public static void main(String[] args) {
		int ans = trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
		System.out.println(ans);

	}

	public static int trap(int[] height) {
		if (height == null || height.length <= 0)
			return 0;

		int sum = 0;

		for (int i = 0; i < height.length; i++) {
			int value1 = height[i];

			if (value1 > 0) {
				int j = i + 1;
				int max = -1;
				int maxValue = -1;
				boolean flag = false;
				
				while (j < height.length) {
					int temp = height[j];
					if(temp >= value1) {
						maxValue = temp;
						break;
					}else {
						if(maxValue == -1) {
							maxValue = temp;
						}
						else if(temp > maxValue) {
							max = j;
							maxValue = temp;
							flag = true;
						}
					}
					j++;

				}
				
				if(maxValue < value1 && flag)
					j = max;

				if (j != (i + 1) && j < height.length) {

					int value2 = height[j];
					int min = Math.min(value1, value2);
					int ans = (j - i - 1) * min;
					int k = i + 1;

					while (k < j) {
						ans -= height[k];
						k++;
					}

					sum += ans;
					i = j - 1;
				}
			}
		}

		return sum;
	}

}
// if maxvalue is < value1 && flag = true;