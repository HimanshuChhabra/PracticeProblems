package mac.interfaces.practice;

import java.util.*;
// find  factors of both and find the common one
public class CommonFactors {

	public static void main(String[] args) {

		int a = 10;
		int b = 15;
		List<Integer> factors1 = getCommonFactors(a);
		List<Integer> factors2 = getCommonFactors(b);
		int result = 0;
		for(int i = 0 ; i < factors1.size() ; i++) {
			if(factors2.contains(factors1.get(i)))
					result++;
		}
     
		
		System.out.println(result);
		
	}

	private static List<Integer> getCommonFactors(int num) {
			List<Integer> factors = new ArrayList<Integer>();
			
			for(int i = 1 ; i <= num ; i++)
			{
				if(num % i == 0)
					factors.add(i);
			}
			
		
		return factors;
	}

}
