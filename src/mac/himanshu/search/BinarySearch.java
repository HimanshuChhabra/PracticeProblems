package mac.himanshu.search;

import java.util.*;

public class BinarySearch implements SearchElement {

	@Override
	public int search(int[] input, int element) {
		
		HashSet set = new HashSet();
		Collections.addAll(set, input);
		
		
		return binarySearch2(input, element);
		
	}

	private int binarySearch(int[] input, int element) {
		int mid = (input.length - 1) / 2;

		if (input[mid] == element) {
			return mid;
		} else if (element < input[mid]) {
			return binarySearch(Arrays.copyOfRange(input, 0, mid - 1), element);
		} else {
			return binarySearch(Arrays.copyOfRange(input, mid + 1, input.length - 1), element);
		}

	}

	public int binarySearch2(int[] input, int target) {
		
		int low = 0, high = input.length - 1;
		
		while(low <= high ) {
			int mid = (low + high) / 2;
			
			if(input[mid] == target)
				return mid;
			else if(target < input[mid])
				high = mid - 1;
			else
				low = mid + 1;
			
		}
			
		return -1;
		
	}
	
}
