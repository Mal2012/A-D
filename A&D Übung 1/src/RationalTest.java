// Test the Rational number class

public class RationalTest {

	public static void main(String[] args) {
		Rational original, right, result = null;
		int numerator, denumerator;
		char operation;

		// create the left operand
		System.out.println("Ersten Bruch eingeben");
		numerator = Console.readInt("Zähler eingeben: ");
		denumerator = Console.readInt("Nenner eingeben: ");

		original = new Rational(numerator, denumerator);

		// choose the operation
		operation = Console.readChar("Operator eingeben +, *, /, -");

		// create the right operand
		System.out.println("Zweiten Bruch eingeben:");
		numerator = Console.readInt("Zähler eingeben: ");
		denumerator = Console.readInt("Nenner eingeben: ");

		right = new Rational(numerator, denumerator);

		// execute the operation
		if (operation == '+')
			result = original.sum(right);
		if (operation == '-')
			result = original.subtract(right);
		if (operation == '/')
			result = original.divide(right);
		if (operation == '*')
			result = original.multiply(right);

		// print the result
		System.out.println(original.toString() + " " + operation + " "
				+ right.toString() + " " + "=" + result.toString());
	} // end main
}
