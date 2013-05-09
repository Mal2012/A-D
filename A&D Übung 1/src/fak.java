public class fak {

	public static int fauk(int n) {
		if (n == 1) {
			return 1;
		}
		return n * fauk(n - 1);

	}

	public static void main(String[] args) {
		System.out.println(fauk(10));
	}
}
