package mac.himanshu.tree;

public class BinarySearch {
	
	static int[] input = {1,2,3,4,5,6,7,8,9,10};
	
	public static void main(String[] args) {
		binarySearch(input, 19);
	}
	
	public static int[] binarySearch(int[] subArr, int pivot){
		int arr1[];
		int size = subArr.length/2;
		int length = subArr.length;
		
		
		if(subArr.length>1){
			
			if(pivot <= subArr[size-1]){
				arr1 = new int[size];
				for(int i=0 ; i < size ; i++ ){
					arr1[i] = subArr[i];
				}
			}
			else{
				arr1 = new int[length - size];
				for(int i=size,j=0 ; i < length ; i++,j++ ){
					arr1[j] = subArr[i];
				}
			}
			
			return binarySearch(arr1, pivot);
			
		}else{
			if(pivot == subArr[0])
				System.out.println("Found");
			else
				System.out.println("Not found");
		}
		
		return null;
	}

}
