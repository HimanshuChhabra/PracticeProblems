package com.himanshu.goldman;

import java.util.*;

public class CoderFriends {

	public static void main(String[] args) {

		String erica = "EEMEE";
		String bob = "EESSH";

		String winner = findWinner(erica, bob);
		System.out.println(winner);
	}

	private static String findWinner(String input1, String input2) {
		  if(input1 == null || input2 == null || input1.length() == 0 || input2.length() == 0 || input1.length() != input2.length())
	            return null;
		
		Map<Character, Integer> ericaMap = new HashMap<Character, Integer>();
		Map<Character, Integer> bobMap = new HashMap<Character, Integer>();
		int ericaScore = calculate(input1, ericaMap);
		int bobScore = calculate(input2, bobMap);
		if (ericaScore > bobScore)
			return "Erica";
		else if (ericaScore < bobScore)
			return "Bob";
		else {
			
			int er = (ericaMap.containsKey('H'))? ericaMap.get('H') : 0;
			int bob = (bobMap.containsKey('H'))? bobMap.get('H') : 0;
			
			
			if (er > bob)
				return "Erica";
			else if (er < bob)
				return "Bob";
			else {
				er = (ericaMap.containsKey('M'))? ericaMap.get('M') : 0;
				bob = (bobMap.containsKey('M'))? bobMap.get('M') : 0;
				
				if (er > bob)
					return "Erica";
				else if (er < bob)
					return "Bob";
				else {
					er = (ericaMap.containsKey('E'))? ericaMap.get('E') : 0;
					bob = (bobMap.containsKey('E'))? bobMap.get('E') : 0;
					
					if (er > bob)
						return "Erica";
					else if (er< bob)
						return "Bob";
				}
			}
		}

		return "Tie";
	}

	private static int calculate(String input, Map<Character, Integer> map) {
		int score = 0;
		for (int i = 0; i < input.length(); i++) {

			char value = input.charAt(i);

			if (value == 'E') {
				score += 1;
			} else if (value == 'M') {
				score += 3;
			} else if (value == 'H') {
				score += 5;
			}

			if (map.get(value) != null) {
				map.put(value, map.get(value) + 1);
			} else {
				map.put(value, 1);
			}
		}
		return score;
	}

}
