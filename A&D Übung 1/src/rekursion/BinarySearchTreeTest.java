package rekursion;

public class BinarySearchTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bt = new BinarySearchTree(10);

		bt.insert(12);
		bt.insert(5);
		bt.insert(6);

		System.out.println(bt);
		System.out.println(bt.isComplete());
	}
}
