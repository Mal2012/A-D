public class ggt {

	public static void main(String[] args) {
		// TODO Auto-genpuerated method stub
		System.out.println(ggtberechnen(1995, 1492));
	}

	public static int ggtberechnen(int a, int b) {
		int rest = 0;
		do {
			rest = a % b;
			a = b;
			b = rest;

		} while (rest != 0);

		return a;

	}
}
