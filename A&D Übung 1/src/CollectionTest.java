public class CollectionTest {
	public static void main(String[] args) {

		Collection c = new Collection(10);
		System.out.println(c.coll.length);
		System.out.println(c.isEmpty());
		IntegerCell aCell = new IntegerCell(1);
		c.insertCell(aCell);
		System.out.println(c.isEmpty());
		System.out.println(c);
		c.removeCell(aCell);
		System.out.println(c);
	}
}
