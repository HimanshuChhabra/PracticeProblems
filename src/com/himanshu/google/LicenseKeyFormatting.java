package com.himanshu.google;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		String S = "2-4A0r7-4k" ; int K = 2; 					// "24A0R74K"
		
		System.out.println(licenseKeyFormatting(S, K));
	}
	
	public static String licenseKeyFormatting(String S, int K) {
        int count = S.length() - 1;
        StringBuilder sb = new StringBuilder(S);
        
        while(count >= 0){
            int temp = K;
            
            while(temp > 0 && count >= 0){
                
                if(sb.charAt(count) != '-'){
                	char ch = sb.charAt(count);
                	sb.replace(count, count+1, Character.toUpperCase(ch) + "");
                    temp--;
                    count --;
                }else{
                	sb.deleteCharAt(count);
                	count--;
                }
                
            }
            
        }
        
        count = sb.length();
        while(count > 0) {
        	count = count - K;
            if(count > 0)
        	sb.insert(count, '-');
        }

        return sb.toString();
    }

}
