package com.himanshu.google;

public class FindAndReplaceString {

	public static void main(String[] args) {
		String S = "vmokgggqzp";			// "vbfrssozp"
		int[] indexes = {3,5,1 };
		String[] sources = { "kg","ggq","mo"};
		String[] targets = { "s","so","bfr"};

		System.out.println(findReplaceString(S, indexes, sources, targets));

	}

	public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		if (S == null || S.length() == 0)
			return S;

		StringBuilder original = new StringBuilder(S);
		int offset = 0;

		for (int i = 0; i < indexes.length; i++) {

			int pos = indexes[i];

			if (i > 0 && indexes[i - 1] < indexes[i]) {
				pos += offset;
	
			}


			String src = sources[i];
			String tar = targets[i];

			// check if the src substring is present in the original string, starting at pos
			if (isValid(original, pos, src)) {
				original.insert(pos, tar);
				int start = pos + tar.length();
				int end = start + src.length();
				original.delete(start, end);

				// adjusting the positions of the characters based on number of new characters
				// added in the previous iteration.
				int temp = Math.abs(src.length() - tar.length());
				temp = (src.length() > tar.length()) ? temp*-1: temp;
				
				offset = offset + temp;

			}

		}

		return original.toString();
	}

	private static boolean isValid(StringBuilder original, int pos, String src) {

		int length = pos + src.length();
		for (int i = pos, j = 0; i < length && j < src.length(); i++, j++) {

			if (i < original.length()) {
				if (src.charAt(j) != original.charAt(i)) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

}
