package rekursion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BinarySearchTreeView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField input, deleteinput;
	private BinarySearchTree tree;
	private BinarySearchTreeViewView view;
	private JLabel key, height, traverse, delete, avl, complete;

	public BinarySearchTreeView(String s, BinarySearchTree tree) {
		super(s);
		this.setTree(tree);
		view = new BinarySearchTreeViewView(tree);
		input = new JTextField();
		input.setBounds(0, 680, 500, 20);

		deleteinput = new JTextField();
		deleteinput.setBounds(10, 680, 500, 20);

		key = new JLabel("Insert Key:");
		height = new JLabel("Height: " + getTree().height());
		traverse = new JLabel("Infix order: " + getTree().traverseInfix());
		avl = new JLabel("isAVL: " + getTree().isAVL());
		complete = new JLabel("isComplete: " + getTree().isComplete());
		delete = new JLabel("Delete: ");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.add(key);
		panel.add(input);
		panel.add(delete);
		panel.add(deleteinput);
		panel.add(height);
		panel.add(avl);
		panel.add(complete);

		panel.setBounds(10, 10, 75, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(traverse, BorderLayout.NORTH);
		c.add(view, BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);
		deleteinput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					getTree().delete(Integer.parseInt(deleteinput.getText()));
					deleteinput.setText("");
					refresh();
				} catch (NumberFormatException ex) {
					input.setText("");
					JOptionPane.showMessageDialog(null,
							"Wrong input: only Numbers allowed");
				}
			}

		});
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = "";

				s = e.getActionCommand();
				try {
					int key = Integer.parseInt(s);
					getTree().insert(key);
					input.setText("");
					refresh();

				} catch (NumberFormatException ex) {
					input.setText("");
					delete.setText("");
					JOptionPane.showMessageDialog(null,
							"Wrong input: only Numbers allowed");
				}

			}

		});
	}

	public void refresh() {
		height.setText("Height: " + getTree().height());
		traverse.setText("Infix Order: " + getTree().traverseInfix());
		avl.setText("isAVL: " + getTree().isAVL());
		complete.setText("isComplete: " + getTree().isComplete());
	}

	public BinarySearchTree getTree() {
		return tree;
	}

	public void setTree(BinarySearchTree tree) {
		this.tree = tree;
	}

}