package mac.himanshu.practice;
import java.util.*;
public class Sticks {

	public static void main(String args[]) {
		try{
			Scanner s = new Scanner(System.in);
			int numberofsticks = Integer.parseInt(s.nextLine());
			String input = s.nextLine();
			String arr[] = input.split(" ");
			int length = arr.length;
			int ii =0;
			List<Integer> values = new ArrayList<Integer>();
			while(ii < length)
			{
				values.add(Integer.parseInt(arr[ii]));
				ii++;
			}
			Collections.sort(values);
			System.out.println(numberofsticks);
			while(values.size()!=1){
				int subs = values.get(0);
				int i = 0;
				while(i < values.size()){
					if(values.get(i)-subs == 0)
					{
						values.remove(i);
					}
					else{
					values.set(i, values.get(i) - subs);
					i ++;
					}
				}
             if(values.size()!=0)
				System.out.println(values.size());
			}
				
		}
		catch(Exception e){
			
		}
		
	}
}
