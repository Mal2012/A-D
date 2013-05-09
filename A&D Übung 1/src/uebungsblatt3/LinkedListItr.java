package uebungsblatt3;

// a more efficient implementation of the position

/**
 * Linked list implementation of the list iterator using a header node
 */
public class LinkedListItr implements Position {
	/**
	 * Construct the list iterator
	 * 
	 * @param theNode
	 *            any node in the linked list.
	 */
	LinkedListItr(ListNode theNode) {
		current = theNode;
	}

	/**
	 * Test if the current position is past the end of the list.
	 * 
	 * @return true if the current position is null.
	 */
	@Override
	public boolean isPastEnd() {
		return current == null;
	}

	/**
	 * Return the item stored in the current position.
	 * 
	 * @return the stored item or null if the current position is not in the
	 *         list.
	 */
	@Override
	public Object retrieve() {
		if (isPastEnd())
			return null;
		else
			return current.element;
	}

	/**
	 * Advance the current position to the next node in the list. If the current
	 * position is null, then do nothing.
	 */
	@Override
	public void next() {
		if (!isPastEnd())
			current = current.next;
	}

	/**
	 * current position
	 */
	@Override
	public Position current() {
		return new LinkedListItr(current);
	}

	/**
	 * current position
	 */
	@Override
	public boolean equals(Position toBeCompared) {
		return (toBeCompared == current);
	}

	ListNode current; // Current position
}
