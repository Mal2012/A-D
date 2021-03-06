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
		this.insert(5);
		this.insert(20);
		this.insert(8);
		// this.insert(10);
		// this.insert(9);
		// this.insert(12);
		// this.insert(7);
		// this.insert(22);
		// this.insert(3);
		// this.insert(14);
		// this.insert(4);
		// this.insert(13);
		// this.insert(6);
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
		if (root != null)
			return traverseInfix(root);
		else
			return null;

	}

	public String traverseReverse() {
		if (root != null)
			return traverseReverse(root);
		else
			return null;

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

	private String traverseReverse(BinarySearchTreeNode node) {
		String s = "";

		if (node.getRight() != null)
			s += traverseReverse(node.getRight());
		s += " " + node.toString();
		if (node.getLeft() != null)
			s += traverseReverse(node.getLeft());

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

	private BinarySearchTreeNode searchMax(BinarySearchTreeNode node) {

		if (node.getRight() == null)
			return node;
		else
			return searchMax(node.getRight());
	}

	public BinarySearchTreeNode searchMax(int key) {

		if (this.suche(root, key).getLeft() != null)
			return searchMax((this.suche(root, key)).getLeft());
		else
			return null;
	}

	private void konstantindelete(BinarySearchTreeNode node) {

		/**
		 * Fall I : Knoten ist die Wurzel [ d.h. parent = null]
		 */
		if (node == this.root) {
			BinarySearchTreeNode tmp = this.root;
			/**
			 * Fall I.a : Wurzel hat keine Bl�tter
			 */
			if (this.root.getLeft() == null && this.root.getRight() == null)
				this.root = null;
			/**
			 * Fall II.a : Wurzel hat nur linkes Blatt
			 */
			else if (this.root.getLeft() != null
					&& this.root.getRight() == null)
				this.root = tmp.getLeft();
			/**
			 * Fall II.b : Wurzel hat nur rechtes Blatt
			 */
			else if (this.root.getLeft() == null
					&& this.root.getRight() != null)
				this.root = tmp.getRight();
			/**
			 * Fall III.a : Wurzel hat zwei Bl�tter
			 */
			else if (this.root.getLeft() != null
					&& this.root.getRight() != null) {
				BinarySearchTreeNode q = searchMax(this.root.getKey());
				konstantindelete(q.getKey());
				this.root.setKey(q.getKey());
			}
		}
		/**
		 * Fall II : Knoten ist keine Wurzel [d.h. hat Elternknoten != null]
		 */
		else if (node != this.root) {
			/**
			 * Fall I.a : Wurzel hat keine Bl�tter
			 */
			if (node.getLeft() == null && node.getRight() == null) {
				if (searchParent(node.getKey()).getKey() < node.getKey())
					searchParent(node.getKey()).setRight(null);
				else if (searchParent(node.getKey()).getKey() > node.getKey())
					searchParent(node.getKey()).setLeft(null);
			}
			/**
			 * Fall II.a : Wurzel hat nur linkes Blatt
			 */
			else if (node.getLeft() != null && node.getRight() == null) {
				if (searchParent(node.getKey()).getKey() < node.getKey())
					searchParent(node.getKey()).setRight(node.getLeft());
				else
					searchParent(node.getKey()).setLeft(node.getLeft());
				/**
				 * Fall II.b : Wurzel hat nur rechtes Blatt
				 */
			} else if (node.getLeft() == null & node.getRight() != null) {
				if (searchParent(node.getKey()).getKey() < node.getKey())
					searchParent(node.getKey()).setRight(node.getRight());
				else
					searchParent(node.getKey()).setLeft(node.getRight());
			}
			/**
			 * Fall III.a : Wurzel hat zwei Bl�tter 1. Suche maxKey im TB d.
			 * l�schenden Knoten [rightChild = null] 2. l�sche d. Knoten aus dem
			 * Baum 3. Ersetze den Wert d. l�schenden Knoten mit maxKey
			 */
			else if (node.getLeft() != null && node.getRight() != null
					&& node != this.root) {
				BinarySearchTreeNode q = searchMax(node.getKey());

				konstantindelete(q.getKey());
				node.setKey(q.getKey());
			}
		}
	}

	public void konstantindelete(int key) {

		if (suche(root, key) != null)
			konstantindelete(suche(root, key));

		this.setChanged();
		this.notifyObservers();
	}

	private BinarySearchTreeNode searchParent(BinarySearchTreeNode node, int key) {

		if (node == null)
			return null;
		else if (key < node.getKey())
			if (node.getLeft().getKey() == key)
				return node;
			else
				return searchParent(node.getLeft(), key);
		else if (key > node.getKey())
			if (node.getRight().getKey() == key)
				return node;
			else
				return searchParent(node.getRight(), key);
		else
			return null;
	}

	public BinarySearchTreeNode searchParent(int key) {

		return searchParent(this.root, key);
	}

	private BinarySearchTreeNode suchemax(BinarySearchTreeNode left) {
		if (left.getRight() != null) {
			return suchemax(left.getRight());
		} else {
			return left;
		}

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
		if (root != null)
			return isAVL(root);
		else
			return false;
	}

	private boolean isAVL(BinarySearchTreeNode node) {
		/*
		 * if (this.height(root.getLeft()) == this.height(root.getRight())) {
		 * return true; } else if (this.height(root.getLeft()) + 1 ==
		 * this.height(root .getRight())) { return true; } else if
		 * (this.height(root.getLeft()) == this.height(root.getRight()) + 1) {
		 * return true; } return false;
		 */

		if (node.getLeft() != null && !isAVL(node.getLeft()))
			return false;
		if (node.getRight() != null && !isAVL(node.getRight()))
			return false;
		int left = 0;
		int right = 0;
		if (node.getLeft() != null)
			left = height(node.getLeft()) + 1;
		if (node.getRight() != null)
			right = height(node.getRight()) + 1;
		left -= right;
		left = left < 0 ? -left : left;
		return left <= 1;

	}

	public boolean isComplete() {
		if (root != null)
			return isComplete(root, 0);
		else
			return false;
	}

	private boolean isComplete(BinarySearchTreeNode node, int stufe) {

		if (stufe != this.height() - 2) {
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

	public int isLeaf() {
		return isLeaf(root);
	}

	private int isLeaf(BinarySearchTreeNode root2) {
		if (root2 == null) {
			return 0;
		} else if (root2.getLeft() == null && root2.getRight() == null) {
			return 1;
		} else {

			return isLeaf(root2.getLeft()) + isLeaf(root2.getRight());
		}
	}

	public int isNode() {
		if (root != null)
			return isNode(root) + 1;
		else
			return 0;
	}

	public int isNode(BinarySearchTreeNode node) {
		int left = 0;
		int right = 0;
		int result = 0;
		if (node.getLeft() != null) {
			left += isNode(node.getLeft());
			left++;
		}
		if (node.getRight() != null) {
			right += isNode(node.getRight());
			right++;
		}
		result = left + right;
		return result;
	}

}
