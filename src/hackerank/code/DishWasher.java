package hackerank.code;
import java.util.*;

public class DishWasher {
	static int current = 0;
	static int k =0;
	static int plates =0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		String arr[] = line.split(" ");
		plates = Integer.parseInt(arr[0]);
		 k = Integer.parseInt(arr[1]);
		int num = plates;
		List<Integer> addPrice = new ArrayList<Integer>();
		List<Integer> subPrice = new ArrayList<Integer>();
		while(num > 0){
			addPrice.add(s.nextInt());
			subPrice.add(s.nextInt());
			num --;
		}
	   int result=0;
		List<Integer> indexList = new ArrayList<Integer>();
	    if(plates-current > k){
	    	int sum=0;
	    	int diff = 0;
	    	int ans =0;
	    indexList = listGenerator(indexList);
	    Iterator<Integer> i = indexList.iterator();
	    
	    while(i.hasNext()){
	    	int val = Integer.parseInt(i.next().toString());
	    	int value = Integer.parseInt(addPrice.get(val).toString());
	    		sum+=value;
	    	
	    }
	    int size=subPrice.size();
	    int itr=0;
	    while(itr<size){
	    	if(!indexList.contains(itr)){
	    	int value = subPrice.get(itr);
	    	diff+=value;
	    	}
	    	itr++;
	    }
	    ans = sum - diff;
	    if(result < ans){
	    	result = ans;
	    }
	    sum = 0;
	    diff =0;
	    ans = 0;
	    }
	    if(result>0){
	    	System.out.println(result);
	    }
	    else{
	    	System.out.println(0);
	    }
	    s.close();
	}

	public static List<Integer> listGenerator(List<Integer> index){
		int itr = 0;
		int nextValue=0;
		if(index.isEmpty()){
			current = 0;
			nextValue=current+1;
			index.add(current);
			while(itr < k-1){
				index.add(nextValue);
				nextValue+=1;
				itr++;
			}
			itr=0;
			return index;
		}
		else if(index.get(k-1).equals(plates-2)){
			
			index.clear();
			current++;
			index.add(current);
			nextValue=current+1;
			while(itr<k-1){
				index.add(nextValue);
				nextValue=+1;
				itr++;
			}
			itr=0;
			return index;
		}
		else{
			 nextValue= Integer.parseInt(index.get(1).toString());
			nextValue+=1;
			index.clear();
			index.add(current);
			while(itr<k-1){
				index.add(nextValue);
				nextValue=+1;
				itr++;
			}
			itr=0;
			return index;
		}
	}
}
