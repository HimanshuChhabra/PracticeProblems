package mac.himanshu.sort;
/**For ascending order
 * Pick smaller values than the pivot and push them to the left, when all the values are traversed, shift the pivot to the next smallest
 * position, such that left values are smaller than the pivot and the right values are larger than the pivot
 * 
 * pivot can be any random value, in this case it is taken as the last element of the array.
 * @author himanshuchhabra
 *
 */
public class QuickSort implements SortIntegers{

	@Override
	public void sort(int[] input) {
		quickSort(input,0,input.length - 1);
	}

	private void quickSort(int[] input, int low, int high) {
		if(low < high){
			int part = partition(input,low,high);
			
			quickSort(input, low, part-1);
			quickSort(input, part+1, high);
		
		}
	}
//{9,17,6,15,16,5,10,11};	
	private int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int i = low - 1;
		for(int j = low ; j <= high - 1 ; j++){
			if(input[j] <= pivot ){//<= pivot){ % 2 !=0 
				i++;
				swap(input,i,j);
			}
		}
		
		swap(input,i+1,high);
		
		return i+1;
	}
	
	private void swap(int input[],int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
