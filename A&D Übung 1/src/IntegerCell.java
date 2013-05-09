public class IntegerCell {

	int wert;

	public IntegerCell(int a) {
		this.wert = a;
	}

	public IntegerCell add(IntegerCell b) {
		return new IntegerCell(this.wert + b.wert);
	}

	public IntegerCell multiply(IntegerCell b) {
		return new IntegerCell(this.wert * b.wert);
	}

	public IntegerCell subtract(IntegerCell b) {
		return new IntegerCell(this.wert - b.wert);
	}

	public IntegerCell divison(IntegerCell b) {
		return new IntegerCell(this.wert / b.wert);
	}

	@Override
	public String toString() {
		return "IntegerCell [wert=" + wert + "]";
	}

}
