package mac.interfaces.practice;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();

		String str[] = line.split(" ");
		float wt[] = new float[str.length-2];
		int v[] = new int[str.length-2];
		int index[] = new int[str.length-2];

		float W = Float.parseFloat(str[0]);
		//input
		for(int i = 2 ; i < str.length ; i ++){
			String input = str[i].substring(1, str[i].length()-1);
			String str1[] = str[i].split(",");
			String value = str1[2].substring(1,str1[2].length()-1);
			index[i-2] = Integer.parseInt(str1[0].substring(1));
			wt[i-2] = Float.parseFloat(str1[1]);
			v[i-2] = Integer.parseInt(value);
		}

		for(int i= 0 ; i < wt.length ; i ++){
			for(int j = 0 ; j < wt.length - 1 ; j ++){
				
				if(v[j] < v[j+1]){
					float temp = wt[j];
					wt[j] = wt[j+1];
					wt[j+1] = temp;

					int temp1 = v[j];
					v[j] = v[j+1];
					v[j+1] = temp1;
					
					temp1 = index[j];
					index[j] = index[j+1];
					index[j+1] = temp1;
				}
			}
		}
		
		String output = " ";
		int i = 0;
		do{
			if(wt[i] <= W){
				output+=index[i]+",";
				W-=wt[i];
			}
			i++;	
		}while(i < wt.length || W == 0);
		
		System.out.println(output.substring(0, output.length()-1));

	}
}
