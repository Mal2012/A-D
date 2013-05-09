package uebungsblatt2;

public class PowAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powrek(5, 3));
		System.out.println(powit(5, 3));
		System.out.println(Math.pow(5, 3));
	}

	public static long powrek(long x, int n) {
		if (n == 1) {
			return x;
		} else {
			return x * powrek(x, n - 1);
		}
	}

	public static long powit(long x, int n) {
		long result = 1;
		for (int i = n; i > 0; i--) {
			result *= x;
		}
		return result;
	}
}
