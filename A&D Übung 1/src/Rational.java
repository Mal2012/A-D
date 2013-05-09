// Definition of class Rational

public class Rational {
	private int numerator; // Zähler
	private int denominator; // Nenner

	// Initialize numerator to 0 and denominator to 1
	public Rational() {
		numerator = 0;
		denominator = 1;
	}

	// Initialize numerator part to n and denominator part to 1
	public Rational(int n) {
		numerator = n;
		denominator = 1;
	}

	// Initialize numerator part to n and denominator part to d
	public Rational(int n, int d) {
		assert(d != 0);

		numerator = n;
		denominator = d;
		reduce();
	}

	// Add two Rational numbers
	public Rational sum(Rational right) {
		int cd = denominator * right.denominator;
		int numer = numerator * right.denominator + right.numerator
				* denominator;

		return new Rational(numer, cd);
	}

	// Subtract two Rational numbers
	// return a Rational result object
	public Rational subtract(Rational right) {
		int cd = denominator * right.denominator;
		int numer = numerator * right.denominator - right.numerator
				* denominator;

		return new Rational(numer, cd);
	}

	public void toScreen() {
		System.out.println("Wert" + numerator + "/" + denominator);
	}

	// Multiply two Rational numbers
	// return a Rational result object
	public Rational multiply(Rational right) {
		return new Rational(numerator * right.numerator, denominator
				* right.denominator);
	}

	// Divide two Rational numbers
	// return a Rational result object
	public Rational divide(Rational right) {
		return new Rational(numerator * right.denominator, denominator
				* right.numerator);
	}

	// Reduce the fraction
	private void reduce() {
		assert(denominator != 0);
		int gcd = 0;
		int smaller = Math.min(numerator, denominator);

		for (int x = 2; x <= smaller; x++)
			if (numerator % x == 0 && denominator % x == 0)
				gcd = x;

		if (gcd != 0) {
			numerator /= gcd;
			denominator /= gcd;
		}
		assert(denominator != 0);
	}

	// Return String representation of a Rational number
	public String toString() {
		return numerator + "/" + denominator;
	}

}
