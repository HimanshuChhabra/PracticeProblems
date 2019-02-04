package com.himanshu.google;

import java.util.*;

public class ReverseOnlyLetters {

	public static void main(String[] args) {
		String S = "Test1ng-Leet=code-Q!";

		//System.out.println(reverseOnlyLetters(S));
		String para = "Bob hit a ball, the hit BALL bob far after it was ball";
		String[] banned = {"hit"};
		System.out.println(mostCommonWord(para, banned));
	}

	public static String reverseOnlyLetters(String S) {
		if (S == null || S.length() == 0)
			return S;

		StringBuilder sb = new StringBuilder();
		int i = S.length() - 1;

		while (i >= 0) {
			char ch = S.charAt(i);
			if (Character.isLetter(ch)) {
				sb.append(ch);
			}
			i--;
		}

		i = 0;
		while (i < S.length()) {
			char ch = S.charAt(i);
			if (!Character.isLetter(ch)) {
				sb.insert(i, ch);
			}
			i++;
		}

		return sb.toString();
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
	    int i = 0 ;
	    int j = 0 ;
	    Map<String,Integer> map = new HashMap<>();
	    Set<String> set = new HashSet<>();
	    for(String str : banned){
	       set.add(str.toLowerCase());
	    }
	    
	    int max = 0;
	    String ans = "";
	    while(i < paragraph.length() && j < paragraph.length()){
	        char ch = paragraph.charAt(j);
	        if(!Character.isLetter(ch) || j == paragraph.length() - 1){
	            
	            if(j == paragraph.length() - 1 && Character.isLetter(ch))
	                j++;
	            
	          String subs = paragraph.substring(i,j).toLowerCase();
	          if(!set.contains(subs) && subs.length() !=0){
	              if(map.containsKey(subs)){
	                int value = map.get(subs) + 1;
	                map.put(subs,value);
	                max = Math.max(max,value);
	                ans = (max > value)? ans : subs;
	            }else{
	                map.put(subs,1);
	                max = Math.max(max,1);
	                ans = (max > 1)? ans : subs;
	            }
	          }
	            j++;
	            i = j;
	            
	        }else{
	            j++;
	        }        
	    }
	    return ans;
	}

}

// Ans : "Qedo1ct-eeLg=ntse-T!"