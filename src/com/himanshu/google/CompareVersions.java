package com.himanshu.google;

public class CompareVersions {

	public static void main(String[] args) {
		// String version1 =
		// "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		// String version2 =
		// "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		String version1 = "1.0.0.0";
		String version2 = "1";
		//int ans = compareVersion2(version1, version2);
		//System.out.println(ans);
		System.out.println(convertToTitle(909373));

	}

	public static String convertToTitle(int n) {

		StringBuilder res = new StringBuilder();

		while (n > 0) {
			n--;
			res.append((char) (n % 26 + 'A'));
			n = n / 26;
		}

		return res.reverse().toString();
	}

	public static int compareVersion2(String version1, String version2) {

		if (version1.length() == 0 && version2.length() == 0)
			return 0;
		if (version1.length() == 0)
			return -1;
		if (version2.length() == 0)
			return 1;

		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int i = 0, j = 0;
		for (; i < arr1.length && j < arr2.length; i++, j++) {

			int num1 = Integer.parseInt(arr1[i]);
			int num2 = Integer.parseInt(arr2[j]);

			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
		}
		// both out of bounds means equal
		if (i >= arr1.length && j >= arr2.length) {
			return 0;
		} else if (i >= arr1.length) {
			// if I went OOB , then ensure if all the remaining elem pointed by j are not 0
			// if yes then both are same else j is bigger.
			while (j < arr2.length && Integer.parseInt(arr2[j]) == 0)
				j++;

			if (j == arr2.length)
				return 0;

			return -1;
		} else {
			// if I went OOB , then ensure if all the remaining elem pointed by i are not 0
			// if yes then both are same else i is bigger.
			while (i < arr1.length && Integer.parseInt(arr1[i]) == 0)
				i++;

			if (i == arr1.length)
				return 0;

			return 1;
		}

	}

}
