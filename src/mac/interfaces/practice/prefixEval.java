package mac.interfaces.practice;

import java.util.*;

public class prefixEval {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//String line = s.nextLine();
		String line = "* + 2 3 4";
		String str[] = line.split(" ");
		String operator = " ";
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		for(int i = str.length -1 ; i >=0;i--){
			
			if(!str[i].equals("*") && !str[i].equals("+") && !str[i].equals("/")){
				stack.addFirst(Integer.parseInt(str[i]));
			}else{
				int num1 = stack.removeFirst();
				int num2 = stack.removeFirst();
				if(str[i].equals("*")){
					stack.addFirst(num1*num2);
				}else if(str[i].equals("+")){
					stack.addFirst(num1+num2);
				}else{
					stack.addFirst(num1/num2);
				}
			}
		}
		System.out.println(stack.getFirst());
	}
}
