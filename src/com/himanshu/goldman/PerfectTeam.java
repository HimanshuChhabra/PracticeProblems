package com.himanshu.goldman;

public class PerfectTeam {

	public static void main(String[] args) {
		String input = "pcmbzpcmbz";
		System.out.println(differntTeams(input));
	}
	
	public static int differntTeams(String input) {
		int ans = 0;
		int p =0,c =0,m =0,b =0,z =0;
		
		for(int i  = 0 ; i < input.length() ; i ++) {
			if(input.charAt(i) == 'p')
				p++;
			else if(input.charAt(i) == 'c')
				c++;
			else if(input.charAt(i) == 'm')
				m++;
			else if(input.charAt(i) == 'b')
				b++;
			else if(input.charAt(i) == 'z')
				z++;
		
		}
		
		if( p == 0 || c == 0 || m == 0|| b == 0|| z == 0) {
			return 0;
		}else {
			
			while(p > 0 && c > 0 && m > 0 && b > 0 && z > 0) {
				ans++; p--;c--;m--;b--;z--;
			}
		}
		
		return ans;
	}

}
