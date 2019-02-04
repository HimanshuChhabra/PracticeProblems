package com.himanshu.google;

public class ClosestPalindrome {

	public static void main(String[] args) {
		String n = "88";
		String ans = nearestPalindromic(n);
		System.out.println(ans);
	}
	
	 public static String nearestPalindromic1(String n) {
	        if (n.equals("1"))
	            return "0";

	        String a = mirroring(n);
	        long diff1 = Long.MAX_VALUE;
	        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
	        if (diff1 == 0)
	            diff1 = Long.MAX_VALUE;

	        StringBuilder s = new StringBuilder(n);
	        int i = (s.length() - 1) / 2;
	        while (i >= 0 && s.charAt(i) == '0') {
	            s.replace(i, i + 1, "9");
	            i--;
	        }
	        if (i == 0 && s.charAt(i) == '1') {
	            s.delete(0, 1);
	            int mid = (s.length() - 1) / 2;
	            s.replace(mid, mid + 1, "9");
	        } else
	            s.replace(i, i + 1, "" + (char)(s.charAt(i) - 1));
	        String b = mirroring(s.toString());
	        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));


	        s = new StringBuilder(n);
	        i = (s.length() - 1) / 2;
	        while (i >= 0 && s.charAt(i) == '9') {
	            s.replace(i, i + 1, "0");
	            i--;
	        }
	        if (i < 0) {
	            s.insert(0, "1");
	        } else
	            s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
	        String c = mirroring(s.toString());
	        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

	        if (diff2 <= diff1 && diff2 <= diff3)
	            return b;
	        if (diff1 <= diff3 && diff1 <= diff2)
	            return a;
	        else
	            return c;
	    }

	public static String nearestPalindromic(String n) {
		if (n.equals("1"))
			return "0";

		if (n.length() == 1) {
			return (Integer.parseInt(n) - 1) + "";
		}

		// calc if mirrot of the num which is stored in a.
		String a = mirroring(n);
		long diff1 = Long.MAX_VALUE;
		diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
		// if the number itself is a palindrome, set it back to infinity as we dont want
		// that ans.
		if (diff1 == 0)
			diff1 = Long.MAX_VALUE;
		
		// if middle digit is 0 , reduce 1 from the first half and then mirror 
		StringBuilder s = new StringBuilder(n);
		int i = (s.length() - 1) / 2;
		if (s.charAt(i) == '0' && s.length() > 1) {
			String x = s.substring(0, (s.length()) / 2);
			Long num = Long.parseLong(x);
			num--;
			s.replace(0, i + 1, num + "");
		}
		// handle cases one first digit is 1 like in 11, the nearest palin should be smaller
		 if (i == 0 && s.charAt(i) == '1') {
	            s.delete(0, 1);
	            int mid = (s.length() - 1) / 2;
	            s.replace(mid, mid + 1, "9");
	     }
		 
		String b = mirroring(s.toString());
		long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));

		//if middle digit is 9 , increase 1 from the first half and then mirror 
		s = new StringBuilder(n);
		i = (s.length() - 1) / 2;

		if (s.charAt(i) == '9' && s.length() > 1) {
			String x = s.substring(0, (s.length()) / 2);
			Long num = Long.parseLong(x);
			num++;
			s.replace(0, i + 1, num + "");
		}
        if (i < 0) {
            s.insert(0, "1");
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
        
		
		String c = mirroring(s.toString());
		long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

		if (diff2 <= diff1 && diff2 <= diff3)
			return b;
		if (diff1 <= diff3 && diff1 <= diff2)
			return a;
		else
			return c;
	}

	public static String mirroring(String s) {
		String x = s.substring(0, (s.length()) / 2);
		return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse().toString();
	}
}
