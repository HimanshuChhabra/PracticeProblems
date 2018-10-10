package mac.himanshu.practice;

import java.util.*;

public class Prac {

	public static void main(String[] args) {

		
		String input[][] = {{"ABC","100"}, {"ABC","200"}, {"PQR","50"},{"ABC", "20"}, {"PQR","30"}, {"PQR","100"},
				{"XYZ","120"},{"PQR","50"}};
		
		Map<String,Integer> map1 = new HashMap<String,Integer>();
		Map<String,Integer> map2 = new HashMap<String,Integer>();
		
		for(int i = 0 ; i < input.length ; i ++){
			String val = input[i][0];
			
			if(!map1.containsKey(val)){
				map1.put(val, Integer.parseInt(input[i][1]));
				map2.put(val,1);
			}
			else{
				int newval = map1.get(val);
				newval+=Integer.parseInt(input[i][1]);
				map1.put(val, newval);
				map2.put(val, map2.get(val)+1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : map1.entrySet()){
				int count = map2.get(entry.getKey());
				entry.setValue(entry.getValue()/count);
			}
		
		int max = Integer.MIN_VALUE;
		String key = null;
		
	for(Map.Entry<String, Integer> entry : map1.entrySet()){
		if(entry.getValue() > max){
			max = entry.getValue();
			key = entry.getKey();
		}
	}
	System.out.println("Max : "+ key+ "," + max);
		
			
		/*Map<String,Integer> map = new HashMap<String,Integer>();
		
	int i = 0;
	String val = null;
	int count = 1;
	
	while( i < input.length){
		val = input[i][0];
		if( !map.containsKey(val)){
			map.put(val, Integer.parseInt(input[i][1]));
			for(int j = i+1 ; j < input.length ; j++){
				if(val == input[j][0]){
					int newVal = map.get(val);
					newVal+=Integer.parseInt(input[j][1]);
					map.put(val, newVal);
					count++;
				}
			}
			int avg = map.get(val)/count;
			map.put(val, avg);
			count = 1;
		}
		i++;
	}
		int max = Integer.MIN_VALUE;
		String key = null;
	for(Map.Entry<String, Integer> entry : map.entrySet()){
		if(entry.getValue() > max){
			max = entry.getValue();
			key = entry.getKey();
		}
	}
		int l = Collections.max(map.values());
	System.out.println("Max : "+ key+ "," + max);
		
		
		
		*/
		
		/*Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(12, 10);
		m.put(2, 23);
		m.put(14, 13);
		m.put(6, 16);
		
		int max = Integer.MIN_VALUE;
		int key = 0;
		for(Map.Entry<Integer, Integer> entry : m.entrySet()){
			if(entry.getValue() > max){
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		
		System.out.println("max : " + key + " , " + max);*/
	}

}
