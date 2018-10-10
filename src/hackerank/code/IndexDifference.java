package hackerank.code;

import java.util.*;

public class IndexDifference {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();

		for(int i =0;i<n;i++){
			a.add(s.nextInt());
		}
		for(int i =0;i<n;i++){
			b.add(s.nextInt());
		}
		
        int i =0;
        int value = 0;
        int smallestIndex =100000;
        while(i < n){
        	int num = a.get(i);
        	if(b.contains(num)){
        		int index = b.indexOf(num);
        		int sub = i-index;
        		if(sub<0){
        			sub=sub*-1;
        		}
        		
        		if(smallestIndex > sub){
        			smallestIndex = sub;
        			value = a.get(i);
        		}
        		else if(smallestIndex == sub){
        			int no=a.get(i);
        			if(no<value)
        			value=no;
        		}
        	}
        	i++;
        }
        if(value!=0)
        System.out.println(value);
	}

}
