package rekursion;

public class BinarySearchTreeController {
	private BinarySearchTreeView view;
	private BinarySearchTree model = new BinarySearchTree();

	public BinarySearchTreeController() {
		this.model.initiate();
		this.view = new BinarySearchTreeView("BinarySearchTree", model);
	}

	public void showView() {
		view.setVisible(true);
	}

}
