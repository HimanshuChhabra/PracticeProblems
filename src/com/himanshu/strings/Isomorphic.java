package com.himanshu.strings;

import java.util.*;

// a = a ; b = a;
public class Isomorphic {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		String[] l1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] l2 = { "Tapioca Express", "Shogun", "Burger King" };
		String str[] = findRestaurant(l1, l2);
		for (String val : str)
			System.out.println(val);
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			if (!map.containsKey(ch1) && !map.containsValue(t.charAt(i))) {
				map.put(ch1, t.charAt(i));
			}
		}

		StringBuffer str = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {

			if (!map.containsKey(s.charAt(i)))
				return false;

			char mapedChar = map.get(s.charAt(i));
			str.append(mapedChar);
		}

		return str.toString().equals(t);
	}

	public static String[] findRestaurant(String[] list1, String[] list2) {

		List<String> result = new ArrayList<String>();
		
		int minSum = Integer.MAX_VALUE;
		String res = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
	
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}

		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {

				int indexVal = map.get(list2[i]);

				if ((indexVal + i) < minSum) {
					minSum = indexVal + i;
					res = list2[i];
				}
			}
		}

		result.add(res);

		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {

				int indexVal = map.get(list2[i]);

				if ((indexVal + i) == minSum) {
					if (!result.contains(list2[i]))
						result.add(list2[i]);
				}
			}
		}

		String[] ans = new String[result.size()];
		int i = 0;
		for (String val : result) {
			ans[i] = val;
			i++;
		}
		return ans;
	}
}
