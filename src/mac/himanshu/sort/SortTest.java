package mac.himanshu.sort;

public class SortTest {
	static int input[] ={64,25,12,22,11,13,5,57,14};// {9,7,6,15,16,5,10,11};
	public static void main(String[] args) {
		
		SortIntegers sortIt = new SelectionSort();
		sort(sortIt);
		
		for(int i : input)
		System.out.print(i+" ");
	}
	private static void sort(SortIntegers sortIt){
		sortIt.sort(input);
	}

}
