package mac.interfaces.practice;

import java.util.*;
public class UpdateArray {

	public static void main(String[] args) {

		int input[] = {1,2,3,4,5};
		int size = input.length;
		int sum = 0;
		for(int i : input)
			sum+=i;
		int mul = 1 ;
		int ans = 0;
		while(true) {
			
		ans = mul * size;
		if(ans > sum)
			break;
		mul++;
		
		}
		
		System.out.println(mul);
		
	}
	
	
}
