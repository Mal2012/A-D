package uebungsblatt3;

// Basic node stored in a linked list
// Note that this class is not accessible outside
class ListNode {
	// Constructors
	ListNode(Object theElement) {
		element = theElement;
		next = null;

	}

	ListNode(Object theElement, ListNode n) {
		element = theElement;
		next = n;
	}

	// Friendly data; accessible by other package routines
	Object element;
	ListNode next;
}
