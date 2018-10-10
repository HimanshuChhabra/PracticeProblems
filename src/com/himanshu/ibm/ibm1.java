package com.himanshu.ibm;
import java.util.*;
import java.io.*;

// div OUT , Contains is THINK , Both OUTTHINK
public class ibm1 {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		
		String input[] = line.split(" ");
		int n = Integer.parseInt(input[0]);
		int p = Integer.parseInt(input[1]);
		int q = Integer.parseInt(input[2]);
		
		for(int i = 1 ; i <= n ; i++) {
			if(contains(p,q,i) && isDivisible(p,q,i)) {
				if(i == n )
				System.out.print("OUTTHINK");
				else
					System.out.print("OUTTHINK,");
			}
			else if(isDivisible(p,q,i)) {
				if(i == n)
					System.out.print("OUT");
				else
				 System.out.print("OUT,");
			}
			else if(contains(p,q,i)) {
				if(i == n)
					System.out.print("THINK");
				else
				System.out.print("THINK,");
			}else {
				if(i == n)
					System.out.print(i);
				else
				System.out.print(i+",");
			}
		}
	}

	public static boolean contains(int p , int q , int number) {
		String pstr = Integer.toString(p);
		String qstr = Integer.toString(q);
		String numberstr = Integer.toString(number);
		
		if(numberstr.contains(pstr) || numberstr.contains(qstr))
			 return true;
		
		return false;
	}
	
	public static boolean isDivisible(int p , int q , int number) {
		if(number % p == 0 || number % q == 0)
			return true;
		
		return false;
	}
}
