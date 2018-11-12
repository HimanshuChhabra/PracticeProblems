package com.himanshu.goldman;

public class FootballProbability {

	public static void main(String[] args) {
		int input[] = { 1, 3, 4, 2 ,3};
		float result = findProbability(input);
		System.out.println(result);

	}

	private static float findProbability(int[] input) {
		
		if (input == null || input.length < 2)
			return 0;

		int totalGamesPlayed = (input.length * (input.length - 1)) / 2;
		int highScoreGames = 0;
		int max = input[0];
		int maxSum = input[0] + input[1];

		for (int i = 1; i < input.length; i++) {
			if(max + input[i] > maxSum) {
				maxSum = max + input[i];
				highScoreGames = 1;
			}else if(max + input[i] == maxSum) {
				highScoreGames++;
			}
			
			if(input[i] > max)
				max = input[i];
		}

		return (float) highScoreGames / totalGamesPlayed;
	}

}
