import java.util.Arrays;

public class Collection {
	IntegerCell[] coll;

	public Collection(int a) {
		coll = new IntegerCell[a];
	}

	public boolean isEmpty() {
		for (IntegerCell a : coll) {
			if (a != null) {
				return false;
			}
		}
		return true;
	}

	public void insertCell(IntegerCell aCell) {
		for (int i = 0; i < coll.length; i++) {
			if (coll[i] == null) {
				coll[i] = aCell;
				break;
			}
		}
	}

	public void removeCell(IntegerCell aCell) {
		for (int i = 0; i < coll.length; i++) {
			if (coll[i] == aCell) {
				coll[i] = null;
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Collection [coll=" + Arrays.toString(coll) + "]";
	}
}
