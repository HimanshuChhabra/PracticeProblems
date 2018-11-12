package com.himanshu.google;

import java.util.*;

public class ArrayIntersection {

	// Sorted array
	public static void main(String[] args) {

		int arr1[] = {2,6,9,11,13,17};
		int arr2[] = {3,6,7,10,13,18};
		int arr3[] = {4,5,6,13,26};
		List<Integer> result = new ArrayList<Integer>();

		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length && k < arr3.length) {

			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				result.add(arr1[i]);
				i++;
				j++;
				k++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr3[k]) {
				j++;
			} else {
				k++;
			}
		}
		System.out.println(result);
		
		//code(2437,875);
	}
// Visa question
	public static void code(int a , int b) {
		int x = a ;
		int y = b;
		
		while(x != y){
			if(x > y) {
				x = x -y;
			}else if(x < y) {
				y = y - x;
			}
		}
		
		System.out.println(x);

	}
}
