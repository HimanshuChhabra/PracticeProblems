package mac.interfaces.practice;

public class multiPalindorme {

	public static void main(String[] args) {
		int num = 195;
		boolean flag = false;
		do{
			StringBuilder str = new StringBuilder(Integer.toString(num));
			str.reverse();
			int addition = num+ Integer.parseInt(str.toString());
			str = new StringBuilder(Integer.toString(addition));
			flag = isPalindrome(str);
			num = addition;
		}while(!flag);
	}

	private static boolean isPalindrome(StringBuilder s1){
		StringBuilder s2 = new StringBuilder(s1).reverse();

		return s1.toString().equals(s2.reverse().toString());
	}
}
