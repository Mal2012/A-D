public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printDigits2(100);
	}

	static void printDigits2(int x) {
		if (x >= 10)
			printDigits2(x / 10);
		System.out.println(x % 10);
	}
}
