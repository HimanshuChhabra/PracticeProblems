package hackerank.code;

public class EvenRight {
/**
 * The logic is same as that of the partition part of the Quick Sort.
 * This logic can be used to create partitions
 * @param args
 */
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,0};
		int i = -1;
		for(int j = 0 ; j < arr.length; j++){
			if(arr[j] % 2 != 0){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		for(int in : arr){
			System.out.print(in+" ");	
		}
		
	}
}
