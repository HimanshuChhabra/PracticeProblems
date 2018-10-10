package mac.himanshu.practice;
import java.util.*;
import java.math.*;

 class Xor1 {
	
   public static void main(String args[]) {
	   try{
		   Scanner s = new Scanner(System.in);
		   BigInteger n1 = new BigInteger(s.nextLine());
		   BigInteger n2 = new BigInteger(s.nextLine());
		   BigInteger incr = new BigInteger("1");
		   BigInteger val1 = n1;
		   BigInteger val2 = n1;
		  int num1 = Integer.parseInt(n1.toString());
		  int num2 = Integer.parseInt(n2.toString());
		  if(num1 > num2|| num1 < 1 || num2 < 1 || num1 > 1000 || num2 > 1000){
			  s.close();
			  throw new Exception();
		  }
		  int diff = num2- num1;
		  int max=0;
		   for(int i = 0 ; i <= diff ;i++)
		   {
			   while(num1<=num2)
			   {   if(max < Integer.parseInt(val1.xor(val2).toString()))
			   {
				   max = Integer.parseInt(val1.xor(val2).toString());
			   }
				   val2= val2.add(incr);
				   num1++;
			   }
			   val1 = val1.add(incr);
			   val2 = val1;
			   num1 = Integer.parseInt(val2.toString());
		   }
		  System.out.println(max);   
	   }
	   catch(Exception e){
		   
	   }
	 
  }
}
