package com.himanshu.lambda;
/*
 * Lambda expressions are used primarily to define inline implementation of a functional interface, i.e., an interface with a single method only 
 */
public class Calculator {

	public static void main(String[] args) {
		
		CalcInterface addition = (int a, int b) -> a + b;
		
		CalcInterface subraction = (a,b) -> a - b;
		
		CalcInterface multiplication = (a,b) -> a * b;
		
		CalcInterface division = (a,b) -> {return a / b;};
		
		//System.out.println(addition.operation(1, 2));
		calculate(addition);
		calculate(subraction); 
		calculate(multiplication); 
		calculate(division);
		
	}
	
	public static void calculate(CalcInterface c) {
		System.out.println(c.operation(20, 2));
	}
}


interface CalcInterface{
	int operation(int a , int b);
}