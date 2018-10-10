package mac.himanshu.practice;

import java.util.*;

public class NimGame {
public static void main(String args[]) {
	try {
		Scanner s = new Scanner(System.in);
		int testCases = Integer.parseInt(s.nextLine());
		while (testCases != 0) {
			s = new Scanner(System.in);
			String line1 = s.nextLine();
			String values[] = line1.split(" ");
			int heaps = Integer.parseInt(values[0]);
			String player = values[1];
			if(testCases <1 || testCases >50 || heaps <1 || heaps > 50)
			{
				throw new Exception();
			}
			List arr = new ArrayList();
			for(int i =0 ;i<heaps;i++)
			{
				int val = s.nextInt();
				if(val < 1 || val > 50)
				{
					throw new Exception();
				}
				arr.add(val);
				
			}
			Collections.sort(arr);
			while(heaps!=0)
			{
				int index = 0;
				boolean flag = true;
				if(player.equalsIgnoreCase("Dee"))
				{
				   while(index<arr.size())
					{
					   if(Integer.parseInt(arr.get(index).toString()) == 0)
					   {
						   arr.remove(index);
					   }
						if(Integer.parseInt(arr.get(index).toString())%2 == 0)
						{
							arr.remove(index);
							player = "Dum";
							heaps--;
							flag = false;
							break;
						}
						else
						{
							index++;
						}
					}
				   index = 0;
				   while(index>arr.size())
				   {
					   if(Integer.parseInt(arr.get(index).toString())%2 != 0)
						{
							Integer temp = (Integer)arr.get(index);
							int temp1 = temp - 1;
							temp = temp - temp1;
							arr.remove(index);
							arr.add(index, temp);
							player = "Dum";
							break;
						}
					   else{
						   index++;
					   }
				   }
					if(player!="Dum")
					{
						System.out.println("Dum");	
						break;
					}
					
				}
				else
				{
					while(index<arr.size())
					{
						if(Integer.parseInt(arr.get(index).toString()) == 0)
						   {
							   arr.remove(index);
						   }
						
						if(Integer.parseInt(arr.get(index).toString())%2 != 0)
						{
							arr.remove(index);
							player = "Dee";
							break;
						}
						
						else
						{
							index++;
						}
					}
					index = 0;
					   while(index>arr.size())
					   {
						   if(Integer.parseInt(arr.get(index).toString())%2 == 0)
							{
								Integer temp = (Integer)arr.get(index);
								int temp1 = temp - 1;
								temp = temp - temp1;
								arr.remove(index);
								arr.add(index, temp);
								player = "Dee";
								break;
							}
						   else{
							   index++;
						   }
					   }
					if(player!="Dee")
					{
						System.out.println("Dee");	
						break;
					}
					}
				
				}
			testCases--;
		}
	} catch (Exception e) {
	}
}
}
