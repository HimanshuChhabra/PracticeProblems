package com.himanshu.google;

public class MergeKSorted {

	// this will be n log k , with O(n) as aux space, where n is the max size of res
	// array in the mergerArrays
	public static int[] mergeKArrays(int[][] arrays, int size) {
		int n = size;

		while (n > 1) {
			int k = 0;
			int i = 0;
			// log k times
			for (i = 0; i < n - 1; i += 2) {
				arrays[k++] = mergeArrays(arrays[i], arrays[i + 1]);
			}

			if (i == n - 1)
				arrays[k++] = arrays[i];
			n = k;
		}

		return arrays[0];
	}

	// O(n) say , n be the total elements in the merged array
	private static int[] mergeArrays(int[] arr1, int[] arr2) {

		int i = 0, j = 0, k = 0;
		int[] res = new int[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				res[k] = arr1[i];
				k++;
				i++;
			} else {
				res[k] = arr2[j];
				k++;
				j++;
			}
		}

		while (i < arr1.length) {
			res[k] = arr1[i];
			k++;
			i++;
		}

		while (j < arr2.length) {
			res[k] = arr2[j];
			k++;
			j++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 4, 5 }, { 3, 6, 7 }, { 2, 3, 8 } };
		int res[] = mergeKArrays(input, 3);

		for (int i : res)
			System.out.print(i + " ");

	}

}
/**
 * Another way is to make use of a priority queue which hold at most K elements,
 * one from each array This means insertion will be Logk , and nk elements
 * meanining nk log k runtime Aux space is O (k) , for priority queue
 * https://www.youtube.com/watch?v=6bvnZzwiKzs
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA
 */

/*
 struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2)
{
	if (l2 == NULL) return l1;
	if (l1 == NULL) return l2;
	if (l1->val < l2->val) { l1->next = mergeTwoLists(l1->next, l2); return l1; }
	else { l2->next = mergeTwoLists(l1, l2->next); return l2; }
} 

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize)
{
	if (listsSize == 0) return NULL;
	int i, k, n = listsSize;
	while (n > 1)
	{
		k = 0;
		for (i = 0; i < n - 1; i+=2)
			lists[k++] =  mergeTwoLists(lists[i], lists[i + 1]);
        if(i == n - 1) lists[k++] = lists[i];
		n = k;
	}
	return lists[0];
}*/
