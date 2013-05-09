public class kreuzwort {
	public static char[][] textfeld = { { 't', 'h', 'i', 's' },
			{ 'w', 'a', 't', 'g' }, { 'o', 'a', 'h', 'g' },
			{ 'f', 'g', 'd', 't' } };

	public static void getTextfeld() {
		for (int i = 0; i < textfeld.length; i++) {
			for (int j = 0; j < textfeld.length; j++) {
				System.out.print(textfeld[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static String loesekreuzwort(String[] sa) {
		StringBuffer sb = new StringBuffer();
		for (String s : sa) {
			char[] chr = s.toCharArray();

			for (int i = 0; i < textfeld.length; i++) {
				for (int j = 0; j < textfeld.length; j++) {
					if (textfeld[i][j] == chr[chr.length - 1]) {

						if (horizontal(i, j, chr.length - 1, chr)) {
							sb.append(s + " gefunden ");

						} else if (vertikal(i, j, chr.length - 1, chr)) {
							sb.append(s + " gefunden ");
						} else if (diagonalou(i, j, chr.length - 1, chr)) {
							sb.append(s + " gefunden ");
						} else if (diagonaluo(i, j, chr.length - 1, chr)) {
							sb.append(s + " gefunden ");
						}

					}
				}
			}
		}
		return sb.toString();

	}

	public static boolean horizontal(int i, int j, int k, char[] chr) {
		boolean result = false;
		if (j - (chr.length) < textfeld.length) {
			if (k > 0) {
				if (i >= 0 & (j - 1) >= 0) {
					if (textfeld[i][j - 1] == chr[k - 1]) {
						result = true;
						horizontal(i, (j - 1), (k - 1), chr);
					}

				}
			}
		}
		return result;
	}

	public static boolean vertikal(int i, int j, int k, char[] chr) {
		boolean result = false;
		if (i - (chr.length) < textfeld.length) {
			if (k > 0) {
				if (i - 1 >= 0 & j >= 0) {
					if (textfeld[i - 1][j] == chr[k - 1]) {
						result = true;
						vertikal(i - 1, j, (k - 1), chr);
					}

				}
			}
		}
		return result;
	}

	public static boolean diagonalou(int i, int j, int k, char[] chr) {
		boolean result = false;
		if (k > 0) {
			if (i - 1 >= 0 & j - 1 >= 0) {
				if (textfeld[i - 1][j - 1] == chr[k - 1]) {
					result = true;
					diagonalou(i - 1, j - 1, (k - 1), chr);
				}

			}
		}
		return result;
	}

	public static boolean diagonaluo(int i, int j, int k, char[] chr) {
		boolean result = false;
		if (k > 0) {
			if (i + 1 < textfeld.length & j - 1 >= 0) {
				if (textfeld[i + 1][j - 1] == chr[k - 1]) {
					result = true;
					diagonalou(i + 1, j - 1, (k - 1), chr);
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		long t = System.nanoTime();
		getTextfeld();
		String[] s = { "this", "fat", "two", "hello", "where", "his", "aht",
				"gdh", "ahd" };
		System.out.println(loesekreuzwort(s));
		System.out.println(t - System.nanoTime());
	}
}