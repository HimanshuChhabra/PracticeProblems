package com.himanshu.goldman;

public class CapitalizeString {

	public static void main(String[] args) {
		String str = "pqrvalertalohohalkoua";
		StringBuilder result = new StringBuilder();
		boolean capitalise = false;
		
		for (int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) == 'a' || str.charAt(i) == 'A') {
				capitalise = (capitalise)? false : true;
				continue;
			}

			if(capitalise) {
				result.append((str.charAt(i) + "").toUpperCase());
			}else {
				result.append(str.charAt(i));
			}
		}
		System.out.println(result);
		test();
	}
	
	public static void test() {
		// https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java
		String str = "8";
		System.out.println(Integer.MAX_VALUE + " - " + Integer.MIN_VALUE);
		
		if(str.charAt(0) >= 48 && str.charAt(0) <= 57) {
			System.out.println("yes");
		}
	}
}
