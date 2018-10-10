package com.himanshu.ibm;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ibm3 {

	static TreeMap<String,Integer> datetoQty  = new TreeMap<String,Integer>();
	static TreeMap<String,List<String>> datetoItem  = new TreeMap<String,List<String>>();

	public static void main(String[] args) throws IOException {

		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(reader);
		String line;

		while ((line = buffer.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			String input[] = line.split(",");
			String date = input[0];
			int qty = Integer.parseInt(input[1]);
			String item = input[2];

			// preparing maps
			if(datetoQty.containsKey(date)) {
				datetoQty.put(date,datetoQty.get(date) + qty);
				if(!datetoItem.get(date).contains(item)) {
					datetoItem.get(date).add(item);
				}
			}else {
				datetoQty.put(date,qty);
				List<String> list = new ArrayList<String>();
				list.add(item);
				datetoItem.put(date, list);
			}
		}
		
		display();
	}

	private static void display() {
		
		for(Map.Entry<String, Integer> entry : datetoQty.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			int numOfItems = datetoItem.get(key).size();
			double average = (double)value / numOfItems; 
			average = Double.valueOf(String.format ("%.2f", average));
			
			System.out.println(key+","+value+","+average+","+numOfItems);
		}
	}	
}



/*
 * 2016-04-03,2,apples
2016-04-12,2,peaches
2016-04-03,2,apples

 */
