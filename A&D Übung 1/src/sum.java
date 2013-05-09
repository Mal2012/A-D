public class sum {
	public static int sum(int n) {
		if (n == 0) {
			System.out.println("n: " + n);
			return 0;
		} else {
			System.out.print("n: " + n + " n-1: ");
			System.out.println(n - 1);
			return n + sum(n - 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(sum(10));
	}
}
