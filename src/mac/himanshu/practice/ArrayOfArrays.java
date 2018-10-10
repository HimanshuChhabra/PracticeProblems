package mac.himanshu.practice;

public class ArrayOfArrays {
/**
 * strArray.length gave me rows
 * strArray[i].length gave me column
 * @param args
 */
	public static void main(String[] args) {
		
		String strArray[][] = {{"Himanshu 100","string 400"},{"Aditi 200"},{"Dinesh 300"},{"Preeti 400"}};
		int sum = 0;
		for(int i = 0; i < strArray.length ; i++){
			for(int j = 0 ; j < strArray[i].length ; j ++){
				String str[] = strArray[i][j].split(" ");
				sum += Integer.parseInt(str[1]);
			}
		}
System.out.println("Sum : " + sum);
	}

}
