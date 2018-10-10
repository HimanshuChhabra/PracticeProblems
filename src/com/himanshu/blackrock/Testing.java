package com.himanshu.blackrock;

import java.util.*;

public class Testing {

  public static void main(String[] args) {
	Map<String,Integer> map = new TreeMap<String,Integer>();
	map.put("X", 1);
	map.put("Ac", 4);
	map.put("Ab", 0);
	
	for(Map.Entry<String, Integer> maps : map.entrySet()) {
		System.out.println(maps.getKey() +  " - " + maps.getValue());
	}
  }
}
