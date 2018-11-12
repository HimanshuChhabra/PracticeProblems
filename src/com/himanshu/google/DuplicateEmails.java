package com.himanshu.google;

import java.util.*;

public class DuplicateEmails {

	public static void main(String[] args) {
		String[] input = { "a......b.+b_cd@example.com", "x@example.com","x@example.com", "x@exa.mple.com", "ab+1@example.com","x+u-_ew@example.com",
				"y@example.com", "y@example.com", "y@example.com","y@example.com","y@example.com", null, null,"" };

		/*StringBuilder s= new StringBuilder("Hello");
		StringBuilder s1= new StringBuilder("Hello");
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s.equals(s1));
		System.out.println(s == s1);*/
		
		int ans = solution(input);
		System.out.println(ans);

	}

	public static int solution(String[] L) {
		
		if(L == null || L.length == 0)
			return 0;
		// count to keep track of total groups with more than one emailIDs.
		int groups = 0;

		// Maintains the count of each email ID ; after Forwarding/editing the email ID
		Map<String, Integer> emailCounts = new HashMap<String, Integer>();

		for (String input : L) {

			if (input == null || input == "")
				continue;

			// StringBuilder is mutable which makes it a performance and memory efficient way to manipulate strings
			// Entire string is not copied to create a new instance on each edit
			StringBuilder email = new StringBuilder(input);

			for (int i = 0; i < email.length(); i++) {

				if (email.charAt(i) == '.') {

					email.deleteCharAt(i);
					i--;

				} else if (email.charAt(i) == '+') {
					int j = i + 1;

					while (email.charAt(j) != '@') {
						j++;
					}
					email.delete(i, j);
					break;

				} else if (email.charAt(i) == '@') {
					break;
				}
			}
			String value = email.toString();
			Integer count = emailCounts.get(value);
			if (count != null) {
				
				if(count == 1)
					groups++;				// incrementing the counter by 1 when the first duplicate email is encountered
				
				emailCounts.put(value, count + 1);
			} else {
				emailCounts.put(value, 1);
			}

		}
		

		return groups;
	}
}

/*
 * 1. if char is . remove it , do this until @ , if + discard every thing
 * uptill @. 2. Maintain a hashset, we dont need to store all the same emails in
 * groups, we can just store a forwarding equivalent I will maintain a hashmap
 * and its count ; if I get it again
 * 
 * I dont really need to maintain lists, I can simply maintain the count
 */
