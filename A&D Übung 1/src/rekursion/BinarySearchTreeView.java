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

public class BinarySearchTreeView extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField input;
	private BinarySearchTree tree;
	private BinarySearchTreeViewView view;
	private JLabel key, height, traverse;

	public BinarySearchTreeView(String s, BinarySearchTree tree) {
		super(s);
		this.tree = tree;
		view = new BinarySearchTreeViewView(tree);
		input = new JTextField();
		input.setBounds(10, 680, 500, 20);
		input.addActionListener(this);
		key = new JLabel("Insert Key:");
		height = new JLabel("Height: -");
		traverse = new JLabel("Infix order: -");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.add(key);
		panel.add(input);
		panel.add(height);
		panel.setBounds(10, 10, 75, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(traverse, BorderLayout.NORTH);
		c.add(view, BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = "";

		s = e.getActionCommand();
		try {
			int key = Integer.parseInt(s);
			tree.insert(key);
			input.setText("");
			height.setText("Height: " + tree.height());
			traverse.setText("Infix Order: " + tree.traverseInfix());
			// System.out.println("Praefix:" + tree);
		} catch (NumberFormatException ex) {
			input.setText("");
			JOptionPane.showMessageDialog(null,
					"Wrong input: only Numbers allowed");
		}

	}
}
