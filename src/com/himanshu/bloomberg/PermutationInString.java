package com.himanshu.bloomberg;

import java.util.*;

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "abbc";
		String s2 = "ebbca";
		
		System.out.println(checkInclusion(s1, s2));
	}

	public static  boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int i = 0 ;
        int j = len -1 ;
        
        // create a freq map for s1
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(int idx = 0 ; idx < s1.length() ; idx++){
            
            char ch = s1.charAt(idx);
            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }else{
                map.put(ch,1);
            }
        }
        
        while(j < s2.length()){
            int k = i;
            boolean found = true;
            Map<Character,Integer> temp = new HashMap<Character,Integer>();
            
            while(k <= j ){
              char ch = s2.charAt(k);
              Integer count = map.get(ch);
                
              if(count != null){      
                
                if(temp.get(ch) == null){
                    temp.put(ch,count);
              }

                if(count > 0){
                  count --;
                  map.put(ch,count);
                  k++;
                }else{
                    found = false;
                    break;
                }
                  
              }else{
                   found = false;
                  break;
              }    
            }
            if(found)
                return true;
            
            map.putAll(temp);
            
            i = i + 1 ;
            j = i+len -1 ;        
        }
        
     return false;
    }
}
