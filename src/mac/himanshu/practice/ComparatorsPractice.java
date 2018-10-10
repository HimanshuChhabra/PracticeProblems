package mac.himanshu.practice;
import java.util.*;


public class ComparatorsPractice {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abcd");
		al.add("c");
		al.add("aa");
		al.add("bc");
		al.add("bb");  
		al.add("ba");
		System.out.println("Not sorted "+ al);
		Collections.sort(al, new SortLength()); // sorts wrt to length
		System.out.println("Sort by length "+al);
		Collections.sort(al, new SortString()); // sorts wrt to alphabets after length 
		System.out.println("Sort by alpha "+al);

	}
}
class SortString implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// first preference of sorting to length, if alphabet is same then sort according to the alphabets
		if(o1.charAt(0) == o2.charAt(0)){
			return o1.compareTo(o2);
		}
		return 0;
	}
	
}

class SortLength implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
}

