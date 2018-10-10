package mac.himanshu.sort;

public class SelectionSort implements SortIntegers {

	@Override
	public void sort(int[] input) {
		int swapThis = 0;
		for(int i = 0 ; i < input.length ; i ++){
			swapThis = i;
			for(int j = i+1 ; j < input.length ; j ++){
				if(input[swapThis] > input[j]){
					swapThis = j;
				}
			}
			
			int temp = input[i];
			input[i] = input[swapThis];
			input[swapThis] = temp;
		}

	}

}
