package com.himanshu.blackrock;

import java.text.DecimalFormat;
import java.io.*;

public class CalcInterest {
		
	 private double rate = 0.0;
	 private double loanAmount = 0.0;
	 private int  numberOfYears = 0;
	 private double downPayment;
	 CalcInterest(String str[]){
		 this.loanAmount = Double.parseDouble(str[0]);
		 this.numberOfYears = Integer.parseInt(str[1])*12;
		 this.rate = (Double.parseDouble(str[2])/100)/12;
		 this.downPayment = Double.parseDouble(str[3]);
	 }
	
	public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in);
	    BufferedReader in = new BufferedReader(reader);
	    String line = in.readLine();
	    String str[] = line.split("~");
	    CalcInterest calc = new CalcInterest(str);
	    double monthlyPayment = calc.calcMonthlyPayment();
	    long interestPayment = calc.calcInterestPayment(monthlyPayment);
	    CalcInterest.display(monthlyPayment,interestPayment);
	  }


	private long calcInterestPayment(double monthlyPayment) {
		
		return Math.round((monthlyPayment*numberOfYears) - (this.loanAmount - this.downPayment));
	}

	private double calcMonthlyPayment() {
		
		double rateCal = Math.pow(1+this.rate, -numberOfYears);
		
		return (this.rate * (this.loanAmount - this.downPayment))/(1 - rateCal);
	}
	
	private static void display(double monthlyPayment, long interestPayment) {
		DecimalFormat dform = new DecimalFormat("#.##"); 
	      System.out.println("$"+Double.valueOf(dform.format(monthlyPayment))+"~$"+interestPayment);
	}
}
