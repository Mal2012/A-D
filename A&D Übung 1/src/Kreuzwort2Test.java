/**
 * @author muma1204
 * 
 */
public class Kreuzwort2Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Kreuzwort2Test().start();
	}

	/**
	 * 
	 */
	private void start() {
		char[][] kreuzwortEntries = new char[4][4];

		// 1. Zeile
		kreuzwortEntries[0][0] = 't';
		kreuzwortEntries[0][1] = 'h';
		kreuzwortEntries[0][2] = 'i';
		kreuzwortEntries[0][3] = 's';

		// 2. Zeile
		kreuzwortEntries[1][0] = 'w';
		kreuzwortEntries[1][1] = 'a';
		kreuzwortEntries[1][2] = 't';
		kreuzwortEntries[1][3] = 's';

		// 3. Zeile
		kreuzwortEntries[2][0] = 'o';
		kreuzwortEntries[2][1] = 'a';
		kreuzwortEntries[2][2] = 'h';
		kreuzwortEntries[2][3] = 'g';

		// 4. Zeile
		kreuzwortEntries[3][0] = 'f';
		kreuzwortEntries[3][1] = 'g';
		kreuzwortEntries[3][2] = 'd';
		kreuzwortEntries[3][3] = 't';

		Kreuzwort2 kreuzwort = new Kreuzwort2(kreuzwortEntries, "this",
				"where", "who", "two", "hello", "fat");

		kreuzwort.printMatches();
	}
}