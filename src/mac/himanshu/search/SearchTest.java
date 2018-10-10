package mac.himanshu.search;

public class SearchTest {
	static int input[] ={64,25,12,22,11,13,5,57,14};
	public static void main(String[] args) {
		SearchElement src = new BinarySearch();
		System.out.println(src.search(input, 25));
	}
}
