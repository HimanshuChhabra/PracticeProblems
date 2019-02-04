package mac.himanshu.dynamic;

public class LargestSquare {
  
	public static void main(String[] args) {
		int input[][] = { 
						{ 1, 0, 1, 0, 0 }, 
						{ 1, 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 1, 0, 1, 1, 1 } 
						};

		int cache[][] = new int[input.length][input[0].length];
		int largestSquareSize = Integer.MIN_VALUE;
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {

				if (i == 0 || j == 0)
					cache[i][j] = input[i][j];
				else {
					if (input[i][j] != 0) {
						cache[i][j] = ((cache[i - 1][j - 1] < cache[i - 1][j])
								? Math.min(cache[i - 1][j - 1], cache[i][j - 1])
								: Math.min(cache[i - 1][j], cache[i][j - 1])) + 1;
						
						largestSquareSize = largestSquareSize < cache[i][j] ? cache[i][j] : largestSquareSize; 
					}
				}
			}
		}

		System.out.println(largestSquareSize);
		
	}
	
}
