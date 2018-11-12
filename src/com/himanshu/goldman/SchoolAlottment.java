package com.himanshu.goldman;

import java.util.*;

public class SchoolAlottment {

	public static void main(String[] args) {
		List<Integer> schoolSeatsArray = Arrays.asList(1, 3, 1, 2);
		List<Integer> studentScoreArray = Arrays.asList(990, 780, 830, 860, 920);

		List<Integer> l1 = Arrays.asList(3, 2, 1);
		List<Integer> l2 = Arrays.asList(3, 0, 0);
		List<Integer> l3 = Arrays.asList(2, 0, 1);
		List<Integer> l4 = Arrays.asList(0, 1, 3);
		List<Integer> l5 = Arrays.asList(0, 2, 3);

		List<List<Integer>> studentSchoolPreferencesArray = new ArrayList<List<Integer>>();
		studentSchoolPreferencesArray.add(l1);
		studentSchoolPreferencesArray.add(l2);
		studentSchoolPreferencesArray.add(l3);
		studentSchoolPreferencesArray.add(l4);
		studentSchoolPreferencesArray.add(l5);

		List<Integer> result = allocateSchools(schoolSeatsArray, studentScoreArray, studentSchoolPreferencesArray);
		System.out.println(result);

	}

	//
	static List<Integer> allocateSchools(List<Integer> schoolSeatsArray, List<Integer> studentScoreArray,
			List<List<Integer>> studentSchoolPreferencesArray) {
		
		if(schoolSeatsArray == null || studentScoreArray == null || studentSchoolPreferencesArray == null)
			return null;
		
		if(schoolSeatsArray.size() != studentScoreArray.size() && studentScoreArray.size() != studentSchoolPreferencesArray.size())
			return null;

		List<Integer> result = new ArrayList<Integer>();
		int totalSeats = 0;
		for (Integer seats : schoolSeatsArray) {
			totalSeats += seats;
		}

		int totalStudents = 0;

		Map<Integer, List<Integer>> scoreMap = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return 1;
				else if (o1 > o2)
					return -1;
				else
					return 0;
			}

		});

		for (int i = 0; i < studentScoreArray.size(); i++) {
			scoreMap.put(studentScoreArray.get(i), studentSchoolPreferencesArray.get(i));
		}

		for (Map.Entry<Integer, List<Integer>> students : scoreMap.entrySet()) {
			List<Integer> preferences = students.getValue();
			boolean isAllocated = false;
			for (Integer pref : preferences) {
				int seats = schoolSeatsArray.get(pref);
				if (seats > 0) {
					totalSeats--;
					isAllocated = true;
					seats--;
					schoolSeatsArray.set(pref, seats);
					break;
				}
			}
			
			if(!isAllocated)
				totalStudents++;

		}
		
		result.add(totalSeats);
		result.add(totalStudents);

		return result;
	}

}
