package mac.himanshu.sort;

public class InsertionSort implements SortIntegers {

	@Override
	public void sort(int[] input) {

		for(int i = 1 ; i < input.length ; i++){
			for(int j = 0 ; j < i ; j ++){
				if(input[j] > input[i]){
					int temp1 = input[i];
					for(int k = i ; k > j ; k--){
						input[k] = input[k-1];
					}
					input[j] = temp1;
					break;
				}
			}
		}
	}
}
