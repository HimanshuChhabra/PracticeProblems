package mac.himanshu.practice;

import java.math.BigInteger;
import java.util.*;

public class FlippingBIts {

	public static void main(String[] args) {
		try{
			Scanner s = new Scanner(System.in);
			String list = s.nextLine();
			int lists = Integer.parseInt(list);
			List<BigInteger> arr = new ArrayList<BigInteger>();
			while(lists > 0)
			{    
				BigInteger b = new BigInteger(s.nextLine());
				String temp = b.toString(2);
				String binary ="";
				if(temp.length() < 32){
					int len = 32 - temp.length();
					while(len > 0){
					temp = "0"+temp;
					len--;
					}
				}
				int i = 0;
				while(i < temp.length()){
					if(temp.charAt(i)=='0'){
						binary+="1";
					}
					else{
						binary+="0";
					}
					i++;
				}

				BigInteger inte = new BigInteger(binary,2);
				arr.add(inte);
						lists--;
			}
			
			Iterator i = arr.iterator();
			while(i.hasNext()){
				System.out.println(i.next());
			}
		}
		catch(Exception e){
			
		}

	}

}
