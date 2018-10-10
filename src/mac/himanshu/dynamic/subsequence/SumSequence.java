/**
* Max contiguous SubSequnece sum
* make a linked list add first value into it
* Add the list into a parent list
* for every new number go through the parent list and check if it can be linked in the sequence
* if the number itself was the first node of a linked list discard it because its already present
* if yes, add it to that linked list
* if not, make a new linked list and add it to the parent list 
* 
* ************Contiguous values
* Not Dynamic Appraoch
*/
package mac.himanshu.dynamic.subsequence;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SumSequence {
	static List<LinkedList<Integer>> parentList = new ArrayList<LinkedList<Integer>>();
	public static void main(String[] args) {
		
		int input[] = {4,8,9,-5,0,3,4,5,6};
		
		int i = 0;
		while(i <= input.length-1){
			int val = input[i];
			if(parentList.isEmpty()){
				checkValue(val);				
			}else{
				if(!makSequence(val)){
					LinkedList<Integer> newSequence = new LinkedList<Integer>();
					newSequence.add(val);
					parentList.add(newSequence);
				}
			}
			
			i++;
		}
			System.out.println(maxSum());
	}
	
	private static int maxSum() {
		int max = 0;
		int sum = 0;
		for(LinkedList<Integer> list: parentList){
			//disallow single sequence answer, you should enable it ideally
			if(!list.isEmpty() && list.size()!=1){
				for(int val : list){
					sum+=val;
				}
			}
			if(sum > max){
				max = sum;
			}
			sum = 0;
		}
		return max;
	}

	private static boolean makSequence(int val) {
		boolean flag = false;
			for(LinkedList<Integer> list : parentList){
				if(!list.isEmpty()){
					if((val - list.getLast()) == 1){
						list.addLast(val);
						flag =  true;
					}
				}
			}
			
			if(flag){
				return true;
			}
			return false;
	}

	private static void checkValue(int val){
		if(parentList.isEmpty()){
			LinkedList<Integer> newSequence = new LinkedList<Integer>();
			newSequence.add(val);
			parentList.add(newSequence);
		}
	}

}
