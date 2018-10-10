package com.himanshu.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
			List<Integer> list = Arrays.asList(1,2,2,3,4,5);
			Predicate<Integer> p = i -> (i % 2 ==  0) ? true : false;

			// Predicate tests the test method and returns true or false 
			
			// allMatch takes predicate and returns true if all the elements satisfy the predicate
			System.out.println(list.stream().allMatch(p));
			
			// anyMatch takes predicate and returns true even if one method satisfies the predicate
			//  can use this as contains
			list.stream().anyMatch(value -> (value == 5) ? true : false);
			

   			System.out.println(list.stream().filter(p).map(i -> i +2).distinct().
   					collect(Collectors.toList()));
   			
   		
			
		Optional<Integer> max = list.stream().max(new Comparator<Integer>() {
				
				public int compare(Integer i , Integer j) {
					if( i < j)
						return -1;
					else if(i == j)
						return 1;
					else
						return 0; 
				}
		});
		
		System.out.println(max.get());
		
		Optional<Integer> o = checkIt(2);
		System.out.println(o.get());
	}
	
	public static Optional<Integer> checkIt(int i){
		if(i % 2 == 0)
			return Optional.of(i);
		else 
			return Optional.ofNullable(null);
	}

}
