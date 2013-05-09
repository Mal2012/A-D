package uebungsblatt3;

/**
 * The <code>LinkedList</code> class implements a simple linked list based on
 * the specification of the abstract data type List. This implementation uses a
 * pointer implementation and not an array
 * 
 * Note that the position is implemented as an integer index This implementation
 * has disadvantages in regard to Big O(n) runtime
 * 
 */

public class LinkedList implements List {

	private ListNode header;

	/**
	 * Construct the list
	 */
	public LinkedList() {
		header = new ListNode(null);
	}

	/**
	 * Test if the list is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return header.next == null;
	}

	/**
	 * Return the index representing the first node in the list.
	 * 
	 * @return position of the first element or -1 if list is empty
	 */
	@Override
	public int first() {
		if (header.next != null)
			return 0;
		else
			return -1;
	}

	/**
	 * Returns the index of the last element
	 * 
	 * @return position of the last element or -1 if list is empty
	 */
	@Override
	public int end() {
		int pos = -1;
		ListNode iterator = header.next;

		while (iterator != null) {
			pos = pos + 1;
			iterator = iterator.next;
		}

		return pos;
	}

	/**
	 * Inserts the elements at the specified index in the list. Shifts the
	 * element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices) valid x range 0 <= x <= number
	 * of elements) if the value of x is the number of elements then the element
	 * is appended. example: if the list is empty insert(0) adds the element
	 * into the list
	 * 
	 * @param x
	 *            the item to insert.
	 * @param p
	 *            index elements are inserted at index p
	 */
	@Override
	public void insert(int pos, Object x) {

		if (pos >= 0) {

			ListNode iterator = header;
			int current = 0;

			while ((current != pos) && (iterator != null)) {

				current = current + 1;
				iterator = iterator.next;
			}

			if (iterator != null)
				iterator.next = new ListNode(x, iterator.next);
			else
				;// error: x > number of elements : invalid position
		} else
			;// error: x < 0 : invalid position
	}

	/**
	 * Search for a specific object with the "same value"
	 * 
	 * @param x
	 *            the item to search for.
	 * @return the position of the item or -1 if the item is not found.
	 */
	@Override
	public int find(Object x) {
		/* 1 */ListNode itr = header.next;
		int pos = -1;
		int current = -1;

		/* 2 */while (itr != null) {
			if (itr.element.equals(x)) {
				pos = current + 1;
				break;
			} else {
				current = current + 1;
				itr = itr.next;
			}
		}

		return pos;
	}

	/**
	 * Search for a specific object at a given position
	 * 
	 * @param p
	 *            the position of the object
	 * @returns the object if position is valid, null otherwise
	 */
	@Override
	public Object elementAt(int pos) {
		ListNode itr = header.next;
		if (pos <= end() && pos >= 0)

			for (int i = 0; i <= pos; i++) {
				if (i == pos) {
					return itr.element;
				} else {
					itr = itr.next;
				}
			}
		return null;

		// exercise

	}

	/**
	 * Find the previous position of a current postion
	 * 
	 * @param current
	 *            current position (valid range 0 < current <= end())
	 * @returns the index of the previous element if current correct, -1
	 *          otherwise
	 */
	@Override
	public int previous(int current) {
		if (current <= end() && current > 0) {
			return current - 1;
		}
		return -1;
		// exercise
	}

	/**
	 * Find the next position of a current postion
	 * 
	 * @param current
	 *            current position (valid range 0 <= current < end())
	 * @returns the index of the next element if current correct, -1 otherwise
	 */
	@Override
	public int next(int current) {
		if (current < end() && current >= 0) {
			return current + 1;
		}
		return -1;
		// exercise
	}

	/**
	 * Remove object with index x
	 * 
	 * @param x
	 *            the index to remove. (valid range 0 <= x < number of elements)
	 */
	@Override
	public void remove(int x) {
		if ((x < 0) || x > end())
			;// error invalid range
		else {
			int pos = 0;
			ListNode iterator = header;

			while (pos != x) {
				pos = pos + 1;
				iterator = iterator.next;
			}
			iterator.next = iterator.next.next; // Bypass deleted node
		}

	}

	/**
	 * Print all elements of the list
	 */
	public void printList() {
		if (isEmpty())
			System.out.print("Empty list");
		else {
			int i = 0;
			ListNode itr = header.next;
			System.out.print("[");
			for (; itr != null; itr = itr.next) {
				System.out.print("" + i + ": " + itr.element);
				if (itr.next != null)
					System.out.print(",");
				i++;
			}
		}

		System.out.println("]");
	}

}
