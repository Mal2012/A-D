package rekursion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class BinarySearchTreeViewView extends JPanel implements Observer {
	private BinarySearchTree tree;
	private int middle;

	static int X_DISTANCE = 30;
	static int NODE_LENGTH = 30;

	public BinarySearchTreeViewView(BinarySearchTree tree) {
		this.tree = tree;
		this.tree.addObserver(this);
		this.setBackground(Color.white);

	}

	@Override
	public void update(Observable o, Object arg) {

		middle = this.getWidth();

		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		middle = this.getWidth() / 2;
		if (tree.root != null)
			paintNode(g, tree.root, middle, 0);

	}

	private void paintNode(Graphics g, BinarySearchTreeNode node, int middle,
			int stufe) {

		// node as a rectangle

		g.drawRect(middle - X_DISTANCE, 50 * stufe, 30, 30);

		// draw key
		g.drawString("" + node.key, middle - X_DISTANCE + 5,
				50 * stufe + 5 + 10);

		if (node.getLeft() != null) {
			g.drawLine(middle - X_DISTANCE, 50 * stufe + 30, middle
					- (2 * X_DISTANCE), 50 * (stufe + 1));
			paintNode(g, node.getLeft(), middle - X_DISTANCE, stufe + 1);
		}

		if (node.getRight() != null) {
			g.drawLine(middle, 50 * stufe + 30, middle + X_DISTANCE,
					50 * (stufe + 1));
			paintNode(g, node.getRight(), middle + X_DISTANCE, stufe + 1);
		}

	}
}
