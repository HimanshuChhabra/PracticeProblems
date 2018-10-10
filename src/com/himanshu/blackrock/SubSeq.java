package com.himanshu.blackrock;

import java.io.*;
import java.util.ArrayList;

public class SubSeq {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		String st = "";
		for(int i = 0 ; i < line.length() ; i++) {
			 if(line.charAt(i) != ',' && line.charAt(i) != ' ') {
				 st+=line.charAt(i)+"";
			 }
			 else {
				 st = "";
			 }
		}
		
		String inputArr [] = line.split(", ");
		if(inputArr.length == 1)
			inputArr = line.split(",");
		
		int arr[] = new int[inputArr.length];

		for(int i = 0; i < inputArr.length ; i++) {
			arr[i] = Integer.parseInt(inputArr[i]);
		}
		System.out.println(largestContiSum(arr));
		ArrayList<Integer>  ll = new ArrayList<Integer>();
		ll.add(2);
		ll.indexOf(0);
	
	}

	
	
	
	  private static int largestContiSum(int inputArr[]){
		    int maxSum = inputArr[0];
		    int S[] = new int[inputArr.length];
		    S[0] = inputArr[0];
		    
		    for(int i = 1 ; i < inputArr.length ; i++){
		      S[i] = Math.max(S[i-1] + inputArr[i], inputArr[i]);
		      maxSum = Math.max(maxSum,S[i]);
		    }
		    return maxSum;
		  }




}
