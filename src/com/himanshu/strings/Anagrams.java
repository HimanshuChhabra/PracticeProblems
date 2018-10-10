package com.himanshu.strings;

import java.util.*;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(anagram());
		Scanner s = new Scanner(System.in);

		StringBuffer str1 = new StringBuffer(s.nextLine());
		String str2 = s.nextLine();

		s.close();
		boolean flag = true;
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str2.length(); i++) {
				if (str1.length() > 0) {
					int index = str1.toString().indexOf(str2.charAt(i));
					if (index != -1) {
						str1.deleteCharAt(index);
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				System.out.println("Anagram");
			else
				System.out.println("Not Anagram");
		}
	}

private static boolean anagram() {

		String str1 = "Hello";
		String str2 = "lloHe";

		if (str1.length() != str2.length())
			return false;

		Map<Character, Integer> map = new HashMap();

		for (int i = 0; i < str1.length(); i++) {

			Integer val = map.get(str1.charAt(i));
			if (val != null)
				map.put(str1.charAt(i), ++val);
			else
				map.put(str1.charAt(i), 1);

		}

		for (int i = 0; i < str2.length(); i++) {
			Character ch = str2.charAt(i);
			if (map.get(ch) == null)
				return false;
			else {
				int value = map.get(ch);
				if (--value == -1)
					return false;
				else
					map.put(ch, value);
			}
		}
		return true;
	}
}
