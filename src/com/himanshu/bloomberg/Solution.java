package com.himanshu.bloomberg;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String input = "AAABCC";  //"AAA"        // BBCCC
        if(input == null || input.length() <=0)
                return;
                
        int counter = 0;
        StringBuilder str = new StringBuilder(input);
        boolean flag= false;
        for(int i = 0 ; i < str.length() ;){
            char ch = str.charAt(i);
            counter++;  
            int index = i+1 ;
            while(index < str.length() && str.charAt(index) == ch){
                counter++;
                index++;
            }
            if(counter >= 3){
                str.delete(i, index); // check start , end -1 , 2  , 5  , 2 - 4 
                flag = true;
            }
            counter = 0;
            
            if(flag){

                if(i - 2 <= 0){
                i = 0 ;
                }
                else{
                i -=2;
                 }
                 flag = false;
            }else{
                i = index;
            }
            
               index = 0;
        }
        System.out.println(str);
    }
}
