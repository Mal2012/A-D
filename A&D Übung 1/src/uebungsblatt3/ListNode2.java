package uebungsblatt3;

public class ListNode2 {

	private ListNode2 next;
	private String name;

	public ListNode2(String name) {
		super();
		this.name = name;
	}

	public ListNode2 getNext() {
		return next;
	}

	public void setNext(ListNode2 next) {
		this.next = next;
	}

	public void swapWithNext() {
		ListNode2 x = this.getNext();
		ListNode2 y = this.getNext().getNext();

		x.setNext(y.getNext());
		y.setNext(x);
		this.setNext(y);

	}

	@Override
	public String toString() {
		return "ListNode " + name + " [next=" + next + "]";
	}

}
