package uebungsblatt3;

public class ListNode2Test {
	public static void main(String[] args) {

		ListNode2 l = new ListNode2("1");
		ListNode2 x = new ListNode2("2");
		ListNode2 y = new ListNode2("3");
		ListNode2 z = new ListNode2("4");

		l.setNext(x);
		x.setNext(y);
		y.setNext(z);
		System.out.println(l);

		l.swapWithNext();
		System.out.println(l);
	}
}
