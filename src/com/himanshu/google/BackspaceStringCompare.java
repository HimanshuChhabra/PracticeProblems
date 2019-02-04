package com.himanshu.google;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		String S = "a#c", T = "b";
		System.out.println(backspaceCompare(S, T));
		System.out.println(underscoreToCamelCase2("calculate_sum_and_product"));
	}

	public static boolean backspaceCompare(String S, String T) {
		
		String s1 = buildString(S);
		String s2 = buildString(T);

		return s1.equals(s2);
	}

	private static String buildString(String s) {

		StringBuilder sb = new StringBuilder(s);

		int count = 0;
		while (count < sb.length()) {

			if (sb.charAt(count) == '#') {
				sb.deleteCharAt(count);
				if (--count >= 0) {
					sb.deleteCharAt(count);
				}else {
					count++;
				}
			}else {
				count++;
			}
		}
		return sb.toString();
	}
	
	private static String capitalizeFirstLetter(String str) {
		
		String s = str.toLowerCase();
		String g = Character.toUpperCase(s.charAt(0)) + "" + s.substring(1);
		return g;
		
	}
	
	private static String underscoreToCamelCase(String str) {
		StringBuilder result = new StringBuilder();
		String arr[] = str.split("_");
		result.append(arr[0]);
		for(int i = 1 ; i < arr.length ; i++) {
			result.append(capitalizeFirstLetter(arr[i]));
		}
		
		return result.toString();
	}
	
	private static String underscoreToCamelCase2(String str) {
		StringBuilder result = new StringBuilder(str);
		int count = 0 ;
		
		while(count < result.length()) {
			
			if(result.charAt(count) == '_') {
				result.deleteCharAt(count);
				result.replace(count, count + 1, Character.toUpperCase(result.charAt(count)) + "");
			}
			count++;
		}
		
		return result.toString();
	}
}
