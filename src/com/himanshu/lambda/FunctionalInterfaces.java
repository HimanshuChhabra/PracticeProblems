package com.himanshu.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/*
 * Functional interfaces must only have one method which will be implemented
 * Functional Interfaces can consume Lamdas as well as Method references;
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {
		// a Predicate takes a unary function which could consume the value of type T and return a boolean
		Predicate<Integer> predi = (value) -> {
			if(value % 2 == 0)
				return true;
			else 
				return false;
		};
		
		List<Integer> list = Arrays.asList(0,1,2,3,4,5,6);
		
		list.forEach(value -> {
			if(predi.test(value)) {
				System.out.println("Even Number : " + value);
			}else {
				System.out.println("Odd Number : " + value);
			}
		});
		
		//using method references , A consumer takes a unary function which can consume the type T , integer in this case and returns void
		Consumer<Integer> consume = System.out::println;
		
		list.forEach(value -> consume.accept(value));
		
		//or
		list.forEach(System.out::print);
	}

}
