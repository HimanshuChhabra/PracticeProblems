package mac.interfaces.practice;
import java.util.*;

public class Stackkk {

	public static void main(String[] args) {
		  Scanner s = new Scanner(System.in);
		  String line = s.nextLine();
		 String str[] = line.split(" ");
		 int input[] = new int[str.length];
		 int i = 0;
		 for(String in : str){
			 input[i] = Integer.parseInt(in);
			 i++;
		 }
		 
		 for(int j = input.length -1 ; j >=0 ; j-=2){
			 System.out.print(input[j]+" ");
		 }
	}

}
