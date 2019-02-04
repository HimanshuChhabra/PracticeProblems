package com.himanshu.bloomberg;

/**
 * Merge two sorted arrays into a thirs array in O(n) time. Strategy is simple
 * to go by both the arrays with two pointers and select which one should be
 * merged into the result array when smaller array gets exhausted, just copy the
 * contents of the larger array
 * 
 * @author himanshuchhabra
 *
 */
public class MergeArrays {

	public static void main(String[] args) {
		int arr1[] = {4,5,6,0,0,0};//{ 1, 3, 5, 7, 9,9 };
		int arr2[] = {1,2,3};//{ 2, 4, 6, 8, 10, 12, 14 };
		
		merge(arr1, 3, arr2, 3);
		/*int result[] = mergeArrays(arr1, arr2);
		
		for (int i : result) {
			System.out.println(i);
		}*/
	}

	private static int[] mergeArrays(int[] arr1, int[] arr2) {

		int i = 0;	// arr1 ptr
		int j = 0;	// arr2 ptr
		int k = 0;	// arr3 ptr
		
		int result[] = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if(arr1[i] <= arr2[j]) {
				result[k] = arr1[i];
				i++;
				k++;
			}else {
				result[k] = arr2[j];
				k++;
				j++;
			}
		}
		
		// if arr1 is the larger array copy remaining
		while( i < arr1.length) {
			result[k] = arr1[i];
			k++;
			i++;
		}
		
		// if arr2 is the larger array copy remaining
		while( j < arr2.length) {
			result[k] = arr2[j];
			k++;
			j++;
		}

		
		return result;
	}
	//{4,5,6,0,0,0}  {1,2,3}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int i = m - 1;
        int j = n - 1;
        for (int l = length -1; l >=0 ; l--) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[l] = nums1[i];
                    i--;
                } else {
                    nums1[l] = nums2[j];
                    j--;
                }
            } else if (j >=0) {
                nums1[l] = nums2[j];
                j--;
            }
        }
    }

}
