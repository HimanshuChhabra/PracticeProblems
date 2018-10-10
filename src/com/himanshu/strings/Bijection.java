package com.himanshu.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Example: 1. cololo <=> banana returns true. 2. apple => grape return false.
 * 
 * 
 * @author himanshuchhabra
 *
 */
public class Bijection {

	public static void main(String[] args) {

		Map<Character, Character> map = new HashMap<Character, Character>();
		String str1 = "abcdb";
		String str2 = "pqrsq";

		boolean flag = true;

		if (str1.length() != str2.length()) {
			flag = false;
		} else {
			for (int i = 0; i < str1.length(); i++) {
				char ch = str1.charAt(i);

				if (map.containsKey(ch)) {
					if (map.get(ch) != str2.charAt(i)) {
						flag = false;
						break;
					}
				} else {
					map.put(ch, str2.charAt(i));
				}
			}
		}

		if (flag)
			System.out.println("True");
		else
			System.out.println("False");
	}

}
