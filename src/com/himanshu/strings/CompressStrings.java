package com.himanshu.strings;

public class CompressStrings {

	public static void main(String[] args) {
		char ch[] = {'a','a','a','a','a','b'};//{'a','a','b','b','c','c','c'};
		int ans = compress(ch);
		System.out.println(ans);

	}

	public static int compress(char[] chars) {
		if (chars == null)
			return 0;

		if (chars.length <= 1)
			return 1;

		int index = 0, count = 0, j = 0;
		int length = chars.length;
		for (int i = 0; i < length; i++) {
			char ch = chars[i];
			count++; // first occurance;
			j = i + 1;
			while (j < length && chars[j] == ch) {
				count++;
				j++;
			}
			i = j - 1;
			if (count == 1) {
				chars[index++] = ch;
			} else if (count < 10) {
				chars[index++] = ch;
				chars[index++] = (char) (count + '0');
			} else {
				String str = ch + String.valueOf(count);
				for (int k = 0; k < str.length(); k++)
					chars[index++] = str.charAt(k);
			}

			count = 0;
		}

		return (index < length) ? index : length;
	}
}
