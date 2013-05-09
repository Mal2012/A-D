package uebungsblatt3;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList theList = new LinkedList();

		// Print initial list
		theList.printList();

		// Insert Strings "0" to "9" into the list
		for (int i = 0; i < 10; i++) {
			theList.insert(i, new Integer(i).toString());
			theList.printList();

		}

		// test cases
		// Insert at invalid position
		theList.insert(-1, new String(" -1"));

		// Append "10" at the list
		theList.insert(10, new String("10"));
		theList.printList();

		// Insert in the middle of the list (right elements are shifted)
		theList.insert(5, new String("->?"));
		theList.printList();

		// Insert at invalid position
		theList.insert(13, new String("13"));
		theList.printList();

		// Append "12" at the list
		theList.insert(12, new String("12"));
		theList.printList();

		// find test
		System.out.println("find: 10 " + " founded "
				+ theList.find(new String("10")));
		for (int i = 15; i > -1; i--)
			System.out.println("find: " + i + " founded "
					+ theList.find(new String(new Integer(i).toString())));

		// Remove first element
		theList.remove(0);
		theList.printList();

		// Remove 12 th element
		theList.remove(12);
		theList.printList();

		theList.remove(11);
		theList.printList();

		// Remove 7 th element
		theList.remove(7);
		theList.printList();

		// test previous and next methods
		theList.printList();
		System.out.println(theList.previous(theList.first()));
		System.out.println(theList.previous(theList.end()));
		System.out.println(theList.next(theList.first()));
		System.out.println(theList.next(theList.end()));

		// go to the 4 th element with next
		int position = -1;
		for (int i = theList.first(); i < 4; i++)
			position = theList.next(i);
		System.out.println(theList.elementAt(position));

		// go to the 3 rd element with previous
		for (int i = theList.end(); i >= 3; i--)
			position = theList.previous(i);
		System.out.println(theList.elementAt(position));

		// Test elementAt
		System.out.println(theList.elementAt(theList.first()));
		System.out.println(theList.elementAt(theList.end()));

		// test elementAt for an empty list
		theList = new LinkedList();
		System.out.println(theList.elementAt(theList.first()));
		System.out.println(theList.elementAt(theList.end()));

	}
}
