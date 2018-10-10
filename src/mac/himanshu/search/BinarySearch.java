package mac.himanshu.search;
//how to send the index, we sort the array.
import java.util.Arrays;

public class BinarySearch implements SearchElement {

	@Override
	public int search(int[] input, int element) {
		Arrays.sort(input);
		return binarySearch(input, element);
	}

	private int binarySearch(int[] input, int element ) {
		int mid = (input.length-1)/2;
		
		if(input[mid] == element){
			return mid;
		}else if(element < input[mid]){
			return binarySearch(Arrays.copyOfRange(input, 0, mid-1),element);
		}else{
			return binarySearch(Arrays.copyOfRange(input, mid+1, input.length-1),element);
		}

	}
	
}
