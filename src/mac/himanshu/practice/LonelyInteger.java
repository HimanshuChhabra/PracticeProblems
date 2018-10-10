package mac.himanshu.practice;
import java.util.*;
public class LonelyInteger {

	public static void main(String[] args) {
try{
			
			Scanner s = new Scanner(System.in);
			int n = Integer.parseInt(s.nextLine());
			if(n < 1 || n >100){
				s.close();
				throw new Exception();
			}
			String str[] = s.nextLine().split(" ");
			List<Integer> array = new ArrayList<Integer>();
			for(int i =0;i<n;i++)
			{ 
				int a = Integer.parseInt(str[i]);
				if(a < 0 || a > 100){
					s.close();
					throw new Exception();
				}
				if(!array.contains(a)){
					array.add(a);
				}
				else{
					int index = array.indexOf(a);
					array.remove(index);
				}
			}
	        s.close();
			if(array.size()==1)
			System.out.println(array.get(0));	
		}
		catch(Exception e){
			
		}
	}

}
