package mac.interfaces.practice;

public class mulPalin {

	public static void main(String[] args) {
		int num1 = 195;
		int iterations = 0;
		boolean flag = false;
		do{
			int num2 = reverse(num1);
			int add = num1+num2;
			flag = isPlaindrome(add);
			if(flag)
				System.out.println("Oh Yeah " + add);

			num1 = add;
		}while(!flag || iterations == 100);
	}

	//slow approach
	private static int reverse(int num1) {
		int val = 0;
		do{
			val = val*10 + num1%10;
			num1 = num1/10;
			
		}while(num1 > 0);
		
		return val;
	}

	// lot of heap allocations, but faster.
	/*private static int reverse(int num1) {
		
		return Integer.valueOf(new StringBuilder(Integer.toString(num1)).reverse().toString());
	}*/

	
	private static boolean isPlaindrome(int add) {
		return add == reverse(add);
	}
}
