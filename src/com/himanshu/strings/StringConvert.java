package com.himanshu.strings;

/**
 * can you convert string T to String S, I have reduced string S to match to String T, if String S becomes shorter than t, I return false;
 * If T is entirely traversed this means that it can be converted
 *
 */
public class StringConvert {

	public static void main(String[] args) {
		/*String T = "abd";
		StringBuilder S = new StringBuilder("abcd");
		boolean flag = true;
		
		for (int i = 0; i < T.length(); i++) {

			if (S.length() - 1 < i) {
				flag = false;
				break;
			}

			if (T.charAt(i) != S.charAt(i)) {
				S.deleteCharAt(i);
				i--;
			}
			
			
		}

		if (flag)
			System.out.println("1");
		else
			System.out.println("0");*/
		
		System.out.println(solution("abcdeflk","abdf"));
	}
	
	
	public static int solution(String S, String T) {
		
			if(S == null || T == null)
				return 0;
			
	       StringBuilder str = new StringBuilder(S);
	       boolean flag = true;
	       
	       for(int i = 0; i< T.length() ; i++){
	           
	           if(str.length() -1 < i){
	               flag = false;
	               break;
	           }
	           
	           if(T.charAt(i) != str.charAt(i)){
	               str.deleteCharAt(i);
	               i--;
	           }
	       }
	       
	       if(flag)
	            return 1;
	        else
	            return 0;
	    }
}
