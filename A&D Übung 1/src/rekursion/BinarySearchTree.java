package rekursion;

import java.util.Observable;
import java.util.Vector;

public class BinarySearchTree extends Observable {

	BinarySearchTreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(int key) {
		root = new BinarySearchTreeNode(key, null);
	}

	public void initiate() {
		this.insert(34);
		this.insert(33);
		this.insert(2);
		this.insert(1);
		this.insert(3);
		this.insert(66);
		this.insert(78);
		this.insert(89);
		this.insert(90);
		this.insert(99);
	}

	public boolean isEmpty() {
		if (root.getRight() == null && root.getLeft() == null) {
			return true;
		}
		return false;
	}

	public int height(BinarySearchTreeNode p) {
		if (p != null) {
			int links = 0;
			int rechts = 0;
			links = this.height(p.getLeft());
			rechts = this.height(p.getRight());
			if (links >= rechts) {
				return links + 1;
			} else {
				return rechts + 1;
			}
		} else {
			return -1;
		}
	}

	public void insert(int key) {
		insert(root, key);
	}

	private void insert(BinarySearchTreeNode p, int key) {
		if (root == null) {
			root = new BinarySearchTreeNode(key, null);
			this.setChanged();
			this.notifyObservers();
		} else if (key < p.key) {
			if (p.getLeft() == null)
				insertLeft(p, key);
			else
				insert(p.getLeft(), key);
		} else if (key > p.key) {
			if (p.getRight() == null)
				insertRight(p, key);
			else
				insert(p.getRight(), key);
		}

	}

	public String traverseInfix() {
		return traverseInfix(root);

	}

	private String traverseInfix(BinarySearchTreeNode node) {
		String s = "";

		if (node.getLeft() != null)
			s += traverseInfix(node.getLeft());
		s += " " + node.toString();
		if (node.getRight() != null)
			s += traverseInfix(node.getRight());

		s += " ";

		return s;
	}

	private void insertLeft(BinarySearchTreeNode p, int key) {
		p.setLeft(new BinarySearchTreeNode(key, p));
		this.setChanged();
		this.notifyObservers();
	}

	private void insertRight(BinarySearchTreeNode p, int key) {
		p.setRight(new BinarySearchTreeNode(key, p));
		this.setChanged();
		this.notifyObservers();
	}

	public String suche(int key) {
		BinarySearchTreeNode temp = suche(root, key);
		if (temp == null) {
			return "Key Not Found";
		} else {
			return "Found Key: " + temp;
		}

	}

	public Vector<BinarySearchTreeNode> traverse(BinarySearchTreeNode node) {
		Vector<BinarySearchTreeNode> nodes = new Vector<BinarySearchTreeNode>(
				20);

		nodes.add(node);
		if (node.getLeft() != null)
			nodes.addAll(traverse(node.getLeft()));
		if (node.getRight() != null)
			nodes.addAll(traverse(node.getRight()));

		return nodes;
	}

	public void delete(int key) {

		if (suche(root, key) != null) {
			if (suche(root, key) != root) {
				BinarySearchTreeNode temp = suche(root, key);
				if (temp.getLeft() == null && temp.getRight() == null) {
					delHelper(key, temp);
				} else {
					Vector<BinarySearchTreeNode> v = traverse(temp);
					delHelper(key, temp);

					for (BinarySearchTreeNode n : v) {
						if (n.getKey() != key) {
							this.insert(n.getKey());
						}
					}

				}

			} else {
				Vector<BinarySearchTreeNode> v = traverse(root);
				root = null;
				int counter = 0;
				for (BinarySearchTreeNode n : v) {
					if (n.getKey() != key) {
						if (counter == 0) {
							root = n;
						}
						this.insert(n.getKey());
						counter++;
					}

				}
			}

		}
		this.setChanged();
		this.notifyObservers();
	}

	private void delHelper(int key, BinarySearchTreeNode temp) {

		if (temp.getParent().getLeft() == temp)
			temp.getParent().setLeft(null);
		if (temp.getParent().getRight() == temp)
			temp.getParent().setRight(null);

	}

	private BinarySearchTreeNode suche(BinarySearchTreeNode node, int key) {

		if (node == null)
			return null;
		if (key < node.getKey())
			return suche(node.getLeft(), key);
		else if (node.getKey() == key)
			return node;
		else
			return suche(node.getRight(), key);
	}

	@Override
	public String toString() {
		return toString(root);
	}

	private String toString(BinarySearchTreeNode node) {
		String s = "";

		s += "[ " + node.toString();
		if (node.getLeft() != null) {
			s += " l->";
			s += toString(node.getLeft());
		}

		if (node.getRight() != null) {
			s += " r->";
			s += toString(node.getRight());
		}
		s += "  ]";

		return s;
	}

	public boolean isAVL() {
		if (this.height(root.getLeft()) == this.height(root.getRight())) {
			return true;
		} else if (this.height(root.getLeft()) + 1 == this.height(root
				.getRight())) {
			return true;
		} else if (this.height(root.getLeft()) == this.height(root.getRight()) + 1) {
			return true;
		}
		return false;
	}

	public boolean isComplete() {
		return isComplete(root, 0);
	}

	private boolean isComplete(BinarySearchTreeNode node, int stufe) {

		if (stufe != this.height() - 1) {
			if (node.getLeft() != null && node.getRight() != null) {
				return isComplete(node.getLeft(), stufe + 1)
						&& isComplete(node.getRight(), stufe + 1);
			} else {
				return false;
			}
		}
		return true;
	}

	public int height() {
		// TODO Auto-generated method stub
		return height(root) + 1;
	}

}
