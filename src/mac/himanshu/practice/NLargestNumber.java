package mac.himanshu.practice;

public class NLargestNumber {

	public static void main(String[] args) {
		int a[] = {2,4,7,5,8,20,4,22,21};
		int nLargest = findLargest(a);
		System.out.println(nLargest);

	}

	private static int findLargest(int[] a) {
		if(a.length == 1){
			return a[0];
		}
	   int idx1 = 0;
	   boolean flag = false;
	   boolean itsOne = false;
		int large1;
		int large2;
		large1 = a[idx1];
		large2 = a[idx1+1];
		do{
			large1 = a[idx1];
			
			for(int i = idx1 ; i < a.length ; i ++){
				
				if(large1 < a[i]){
					large2 = large1;
					large1 = a[i];
					flag = true;
				}
			}
			if(idx1 != a.length - 1){
				
				if(!flag){
					idx1++;
					itsOne = true;
				}
			}
			else{
				return large2;
			}
			
		}while(!flag);
		
		if(itsOne)
		return large1;
		else
		return	large2;
	}
}
