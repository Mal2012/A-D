
import java.util.ArrayList;
import java.util.List;

/**
 * @author muma1204
 * 
 */
public class Kreuzwort2 {

	private char[][] kreuzwort;
	private List<String> wordlist;

	/**
*
*/
	public Kreuzwort2(String... wordlist) {
		this.setWordlist(wordlist);
	}

	/**
	 * @param kreuzwort
	 * @param wordlist
	 */
	public Kreuzwort2(char[][] kreuzwort, String... wordlist) {
		this.setWordlist(wordlist);
		this.setKreuzwort(kreuzwort);
	}

	/**
*
*/
	public void printMatches() {
		for (String match : this.getMatches()) {
			System.out.println(match);
		}
	}

	/**
*
*/
	public void setKreuzwort(char[][] kreuzwort) {
		this.kreuzwort = new char[kreuzwort.length][kreuzwort[kreuzwort.length - 1].length];

		for (int i = 0; i < this.kreuzwort.length; i++) {
			for (int j = 0; j < this.kreuzwort[0].length; j++) {
				this.kreuzwort[i][j] = kreuzwort[i][j];
			}
		}
	}

	/**
	 * @param words
	 */
	private void setWordlist(String... words) {
		this.wordlist = new ArrayList<String>();
		for (String word : words) {
			this.wordlist.add(word);
		}
	}

	/**
	 * @return O-Komplexität: O(n)
	 */
	private List<String> getMatches() {
		long startTime = System.nanoTime();

		StringBuilder fullMatchString = new StringBuilder();

		// kompletten String aus allem bauen und dann prüfen

		for (int i = 0; i < this.kreuzwort.length; i++) {
			for (int j = 0; j < this.kreuzwort[0].length; j++) {
				// Horizontale Treffer suchen
				fullMatchString.append(this.kreuzwort[i][j]);
			}
		}

		for (int i = 0; i < this.kreuzwort[0].length; i++) {
			for (int j = 0; j < this.kreuzwort.length; j++) {
				// Vertikale Treffer suchen
				fullMatchString.append(this.kreuzwort[j][i]);
			}
		}

		// Diagonale Treffer suchen
		for (int i = 0; i < this.kreuzwort.length; i++) {
			for (int j = i, k = 0; j < this.kreuzwort.length
					&& k < this.kreuzwort[0].length; j++, k++) {
				fullMatchString.append(this.kreuzwort[j][k]);
			}

			for (int j = i, k = 0; j > -1 && k < this.kreuzwort[0].length; j--, k++) {
				fullMatchString.append(this.kreuzwort[j][k]);
			}

			for (int j = 0, k = i; j < this.kreuzwort.length
					&& k < this.kreuzwort[0].length; j++, k++) {
				fullMatchString.append(this.kreuzwort[j][k]);
			}

			for (int j = 0, k = i; j < this.kreuzwort.length && k > -1
					&& k < this.kreuzwort[0].length; j++, k--) {
				fullMatchString.append(this.kreuzwort[j][k]);
			}
		}
		System.out.println(System.nanoTime() - startTime);
		return this.checkCharacter(fullMatchString);
	}

	/**
	 * @param fullMatchString
	 * @return
	 */
	private List<String> checkCharacter(StringBuilder fullMatchString) {
		List<String> matches = new ArrayList<String>();
		for (String word : this.wordlist) {
			if (fullMatchString.toString().contains(word)) {
				if (this.notInList(matches, word)) {
					matches.add(word);
				}
			}
			if (this.getStringReversed(fullMatchString.toString()).contains(
					word)) {
				if (this.notInList(matches, word)) {
					matches.add(word);
				}
			}
		}
		return matches;
	}

	/**
	 * @param toReverse
	 * @return
	 */
	private String getStringReversed(String toReverse) {
		StringBuilder reversed = new StringBuilder();
		for (int i = toReverse.length() - 1; i > 0; i--) {
			reversed.append(toReverse.charAt(i));
		}
		return reversed.toString();
	}

	/**
	 * @param matches
	 * @param word
	 * @return
	 */
	private boolean notInList(List<String> matches, String word) {
		for (String match : matches) {
			if (match.equals(word)) {
				return false;
			}
		}
		return true;
	}
}