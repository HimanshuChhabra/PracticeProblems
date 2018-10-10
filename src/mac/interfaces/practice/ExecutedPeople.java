package mac.interfaces.practice;

import java.util.*;

public class ExecutedPeople {

	public static void main(String[] args) {
		  Scanner s = new Scanner(System.in);
		  String line = s.nextLine();
		 String str[] = line.split(" ");
		 int size = Integer.parseInt(str[0]);
		 int og = Integer.parseInt(str[0]);
		 ArrayList<Integer> input = new ArrayList<Integer>();
		 
		 for(int i = 0 ; i < size; i++){
			 input.add(i);
		 }
		 
		 int dead[] = new int[size];
		 
		 int count = 0;
		 int i = 0;
		 int m = Integer.parseInt(str[1]);
		 int kill = m;
		 
		 while(count < og){
			 if(kill < size){
				 dead[i] = input.get(kill-1);
				 input.remove(kill-1);
				 kill--;
				 i++;
				 kill+=m;
				 count++;
				 size--;
			 }else{
				 kill = (kill - 1) - (size -1);
			 }
		 }
		 
		 for(i = 0 ; i < dead.length ; i++){
			 System.out.print(dead[i]);
		 }
	}

}
