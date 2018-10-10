package hackerank.code;

import java.util.Arrays;
import java.util.TreeSet;

public class Subss {

	public static void main(String[] args) {
		String input = "zacaabc";
		int length = 3;
		TreeSet<String> set = new TreeSet<String>();
		int i = 0;
		
		while(i <= input.length() - length){
			String str = input.substring(i, i+length);
			set.add(str);
			i++;
		}
		String output[] = new String[set.size()];
		i = 0;
		for(String mystr : set){
			output[i] = mystr;
			i++;
		}
		
	}

}
