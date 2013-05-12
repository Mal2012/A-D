package rekursion;

public class BinarySearchTreeNode {

	protected int key;
	protected BinarySearchTreeNode left;
	protected BinarySearchTreeNode right;

	public BinarySearchTreeNode(int key) {
		this.setKey(key);
	}

	@Override
	public String toString() {
		return "" + key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

}
