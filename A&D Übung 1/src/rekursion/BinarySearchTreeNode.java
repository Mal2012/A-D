package rekursion;

public class BinarySearchTreeNode {

	protected int key;
	protected BinarySearchTreeNode left;
	protected BinarySearchTreeNode right;
	protected BinarySearchTreeNode parent;

	public BinarySearchTreeNode getParent() {
		return parent;
	}

	public void setParent(BinarySearchTreeNode parent) {
		this.parent = parent;
	}

	public BinarySearchTreeNode(int key, BinarySearchTreeNode p) {
		this.setKey(key);
		this.setParent(p);
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
