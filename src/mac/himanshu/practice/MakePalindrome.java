package mac.himanshu.practice;

import java.util.Scanner;

public class MakePalindrome {

	public static void main(String args[])
	{
		try
		{
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int match = s.nextInt();
	        String number = s.next();
			StringBuffer input = new StringBuffer(number);
			int expected = input.length();
			int index1 = input.length()/2 - 1;
			int index2  =index1+1;
			s.close();		
			
			if(n < 0 || n > 100000 || match < 0 || match > 100000 || isNumber(number))
			{
				throw new Exception();
			}
			
			if(input.length()%2!=0)
			 {
				if(index1==-1)
					index1=0;
				index2  =index1+2;
				expected --;
			 }
			while(index1 >= 0 && match !=0)
			{ 
				if(input.length()==1)
				{
					input.setCharAt(index1, '9');
					match --;
					break;
				}
				if(input.charAt(index1) == input.charAt(index2) && match!=expected)
					 {
						 expected -= 2;
						 index1 --;
						 index2 ++;
					 }
					 else if(match < expected)
					 {
						 if(Integer.parseInt(input.charAt(index1)+"") >= Integer.parseInt(input.charAt(index2)+""))
						 {
							 input.setCharAt(index2, input.charAt(index1));
						 }
						 if(Integer.parseInt(input.charAt(index1)+"")<Integer.parseInt(input.charAt(index2)+""))
						 {
							 input.setCharAt(index1, input.charAt(index2));
						 }
						 index1 --;
						 index2 ++;
						 match --;
						 expected -=2;
					 }
					 else
					 {
						 if(input.charAt(index1)!='9')
						 {
							 input.setCharAt(index1, '9');
							 input.setCharAt(index2, '9');
							 index1 ++;
							 index2 --;
							 match -= 2;
							 expected -= 2;	 
						 }
						 else
						 {
							 index1++;
							 index2--;
						 }
						 
					 }
			}
		
			String reversed = input.reverse().toString();
			input.reverse();
			if(input.toString().equals(reversed))
			{
				System.out.println(input);
			}
			else
			{
				System.out.println(input + "-1");
			}
				
		}
		catch(Exception e)
		{
		
		}
		 
	}
	public static boolean isNumber(String number)
	{
		int i=0;
		while(i<number.length())
		{
			int val = (int)number.charAt(i);
			if(val < 48 || val >57)
				return false;	
			i++;
		}
		return false;
	}

}
