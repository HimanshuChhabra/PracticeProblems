package com.himanshu.google;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		String ans = removeKdigits(num, k);
		System.out.println(ans);
	}
/*
	public static String removeKdigits(String num, int k) {
		StringBuilder sb = new StringBuilder(num);
		int i = 0;
		while (i < sb.length() - 1 && k > 0) {
			if (sb.charAt(i) > sb.charAt(i + 1)) {
				while(i >=0 && sb.charAt(i) > sb.charAt(i + 1)) {
					sb.deleteCharAt(i);
					i--;
					k--;
				}
			} else {
				i++;
			}
		}
		
		i = sb.length() - 1;
		// handle cases like 1111 , 123456
		while (i >= 0 && k > 0) {
			sb.deleteCharAt(i);
			i--;
			k--;
		}
		
		i = 0;
		// remove leading 0's
		while (i < sb.length() - 1 && sb.charAt(i) == '0') {
			sb.deleteCharAt(i);		
		}
		
		if(sb.length() == 0)
			return "0";
		
		return sb.toString();
	}
	*/
	
	public static String removeKdigits(String num, int k) {
        int len = num.length();
        
        //corner case
        if(k==len)        
            return "0";
            
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }

}
