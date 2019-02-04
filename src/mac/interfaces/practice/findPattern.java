package mac.interfaces.practice;

import java.util.HashMap;


public class findPattern {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2,2);
		Integer i = map.get(1);
		i = 10;
		System.out.println(map.get(1));
		
		HashMap<Integer, StringBuilder> map2 = new HashMap<Integer, StringBuilder>();
		StringBuilder ss = new StringBuilder("hello");
		map2.put(1, ss);
		StringBuilder i1 = map2.get(1);
		i1.append(" lll");
		System.out.println(map2.get(1)); 
		
		HashMap<Integer, Test> map1 = new HashMap<Integer, Test	>();
		Test t = new Test();
		t.value = 5;
		map1.put(1, t);
		Test g = map1.get(1);
		g.value = 10;
		
		Test x = map1.get(1);
		System.out.println(x.value);
	}

}


class Test{
	public int value = 10;
}