package mac.himanshu.practice;
import java.util.*;


public class ComparatorsPractice {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		LinkedList<String> ll = new LinkedList<String>(al);
		
		al.add("ab");
		al.add("c");
		al.add("bc");
		al.add("aa");
		al.add("bb");  
		al.add("ba");
		System.out.println("Not sorted "+ al);
		Collections.sort(al, new SortLength()); // sorts wrt to length
		System.out.println("Sort by length "+al);
		Collections.sort(al, new SortString()); // sorts wrt to alphabets after length 
		System.out.println("Sort by alpha "+al);
		
		
		Comparator<Integer> comp = Collections.reverseOrder();
		Integer a[] = {5,2,3,4};
		Arrays.sort(a, (i , j) -> {
		return (i - j);	
		});
		
		Arrays.sort(a, (i,j) -> i -j);
		
		System.out.println(Arrays.deepToString(a));
		
		Collections.sort(al,new Comparator<String>(){

            public int compare(String i , String j){
                return 0;
            }
        });

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

