package com.himanshu.lambda;

import java.util.ArrayList;
import java.util.List;

/*
 * A method reference can be used to point to different types of methods
 */
public class MethodReference {
	
	public MethodReference() {}
	
	public MethodReference(Integer i) {
		System.out.print(i+" ");
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);list.add(2);list.add(3);

		//method reference of instance methods
		System.out.println("method reference of instance methods");
		MethodReference m = new MethodReference();
		list.forEach(m::display);

		//method reference of static methods
		System.out.println("\nmethod reference of static methods");
		list.forEach(MethodReference::staticDisplay);
		
		//method reference of a constructor
		System.out.println("\nmethod reference of a constructor");
		list.forEach(MethodReference::new);
		
		//forEach using a Lambda
		System.out.println("\nforEach using a Lambda");
		list.forEach(i->System.out.print(i+" "));
		
		
		TestIn t = MethodReference::staticDisplay;
		t.func(2000);
		
		
	}

	public  void display(Integer i) {
		System.out.print(i+" ");
	}

	public static void staticDisplay(Integer i) {
		System.out.print(i+" ");
	}
}

@FunctionalInterface
interface TestIn{
	void func(int i);
}
