package com.himanshu.goldman;

import java.util.*;

public class CSVFormatter {

	public static void main(String[] args) {
		String str[] = { "Name,Age,Location", "Himanshu,24,SU", "Somya,24,TAMU" };
		List<List<String>> columnList = new ArrayList<List<String>>();
		List<Integer> maxWordSize = new ArrayList<Integer>();

		for (String s : str) {
			String[] words = s.split(",");

			for (int i = 0; i < words.length; i++) {

				if (columnList.size() <= i) {
					List<String> newColumn = new ArrayList<String>();
					newColumn.add(words[i]);
					columnList.add(newColumn);
				} else {
					columnList.get(i).add(words[i]);
				}
			}

		}

		for (List<String> column : columnList) {
			int maxStringLength = 0;
			Optional<String> max = column.stream().max(new Comparator<String>() {

				public int compare(String i, String j) {
					return i.length() - j.length();
				}
			});

			maxStringLength = (max.get().length() > maxStringLength) ? max.get().length() : maxStringLength;
			maxWordSize.add(maxStringLength);

		}

		for (String s : str) {
			String words[] = s.split(",");
			for (int i = 0; i < words.length; i++) {
				String res;
				if(i == 0)
				res = String.format("%" + (maxWordSize.get(i)) + "s", words[i]);
				else
				res = String.format("%" + (maxWordSize.get(i) + 1) + "s", words[i]);
				
				if(i != words.length -1)
				System.out.print(res + ",");
				else
					System.out.print(res);
			}

			System.out.println();
		}

	}

}
