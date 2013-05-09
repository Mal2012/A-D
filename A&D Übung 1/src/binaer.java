public class binaer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getBinaryCount(42));
	}

	public static int getBinaryCount(int n) {
		if (n / 2 <= 0) {
			return n % 2;
		} else {
			return n % 2 + getBinaryCount(n / 2);
		}
	}

}
