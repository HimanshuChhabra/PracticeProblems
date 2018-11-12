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
	}

}
