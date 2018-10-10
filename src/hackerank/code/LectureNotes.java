package hackerank.code;

import java.util.*;

public class LectureNotes {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		String arr[] = line.split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		String status = s.nextLine();
		List<Integer> friends = new ArrayList<Integer>();
		int num = k;
		while(num>0){
			friends.add(s.nextInt());
			num--;
		}
		int i =0;
		boolean flag = false;
		while(i < k){
			int friend = friends.get(i);
			String value = status.charAt(friend-1)+""; 
			if(value.equals("0")){
				flag = true;
				break;
			}
			i++;
		}
		
		if(flag){
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}

}
