public class permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		permute("abcd");
	}

	public static void permute(String s) {
		// StringBuffer str = new StringBuffer(s);
		// permute(str, str.length());

		char[] chr = s.toCharArray();
		permuteChr(chr, chr.length);
	}

	private static void permuteChr(char[] str, int index) {
		if (index == 0)
			System.out.println(str);
		else {
			permuteChr(str, index - 1);
			int currPos = str.length - index;
			for (int i = currPos + 1; i < str.length; i++) {
				swapChr(str, currPos, i);
				permuteChr(str, index - 1);
				swapChr(str, i, currPos);
			}
		}
	}

	private static void swapChr(char[] str, int pos1, int pos2) {
		char t1 = str[pos1];
		str[pos1] = str[pos2];
		str[pos2] = t1;
	}
	/*
	 * private static void permute(StringBuffer str, int index) { if (index ==
	 * 0) System.out.println(str); else { permute(str, index - 1); int currPos =
	 * str.length() - index; for (int i = currPos + 1; i < str.length(); i++) {
	 * swap(str, currPos, i); permute(str, index - 1); swap(str, i, currPos); }
	 * } }
	 * 
	 * private static void swap(StringBuffer str, int pos1, int pos2) { char t1
	 * = str.charAt(pos1); str.setCharAt(pos1, str.charAt(pos2));
	 * str.setCharAt(pos2, t1); }
	 */

}
