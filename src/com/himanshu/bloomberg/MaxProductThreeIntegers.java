package com.himanshu.bloomberg;

public class MaxProductThreeIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {-4,-3,-2,-1,60}; //{1,2,5,4,6,3};
		int ans = maximumProduct(input);
		System.out.println(ans);
	}

    public static int maximumProduct(int[] nums) {
        
        if(nums != null && nums.length < 3)
            return 0;
        
        if(nums.length == 3)
            return nums[0] * nums[1] * nums[2];
        
        int max1 = Integer.MIN_VALUE;       // largest number
        int max2 = Integer.MIN_VALUE;       // second largest number
        int max3 = Integer.MIN_VALUE;       // third largest number
        
        int min1 = Integer.MAX_VALUE;       // smallest number
        int min2 = Integer.MAX_VALUE;        // second smallest number
        
        // find max three numbers and Min 2 numbers in O(n) and O(1) auxiliary space
        for(int i = 0 ; i < nums.length ; i++){
            
            if(nums[i] <= min1){
                 min2 = min1;
                 min1 = nums[i];
             }else if(nums[i]  <= min2){
                 min2 = nums[i];
             }
            
             if(nums[i] > max1){
                 max3 = max2;
                 max2 = max1;
                 max1 = nums[i];
             }else if(nums[i] > max2){
                 max3 = max2;
                 max2 = nums[i];
             }else if(nums[i]  > max3){
                 max3 = nums[i];
             }
        }
        
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}

/*
input [1,2,5,4,6,3] ; sort [6,5,4,3,2,1]
appraoches 
1. sort it in decending order and multipy first 3 numbers  nlogn
2. Use a Max heap and poll first three number and multiply it  nlogn , n auxiliary space
3. Find the Max three numbers in a single scan O(n)


Implmented appraoch :
Finding max 3 numbers will only give you the ans if all are positive
But Since we have negative numbers also we can have the smallest two negative intergers
eg: -4,-3,-2,-1,60 
-4*-2 to be bigger than -2*-1 when multiplied with 60.

Thus max of (num1 * num2 * num3) and (num1* min1 * min3)
If you re doing sorting, if its ascending order,  index 0 and 1 will be smallest and last three indices will be largest.
*/
