import java.util.*;

class MyLinkedList<E> extends LinkedList<E> {
	public void reverse() {
		for (int i = 0; i < size()/2; i++) {
			E first = get(i);
			E second = get(size() - 1 - i);
			set(i, second);
			set(size() - 1 -i, first);
		}
	}

}
/******* Class definition for ListNode *******/
class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
	public ListNode(E element) { 
		this(element, null); 
	}

	public ListNode(E element, ListNode <E> next) { 
		this.element = element; 
		this.next = next; 
	}

	public ListNode <E> getNext() {
		return this.next;
	}

	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode <E> next) {
		this.next = next;
	}
}
/******* Class definition for MyLinkedList *******/
/*class MyLinkedList <E> {

	// Data attributes
	private ListNode <E> head = null;
	private int numNodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (numNodes == 0);  // or return (head == null);
	}

	// Return number of nodes in list.
	public int size() { 
		return numNodes; 
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("List is empty!");
		else 
			return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode <E> curr = head; curr != null; curr = curr.getNext())
			if (curr.getElement().equals(item)) 
				return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
		numNodes++;
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("Can't remove from an empty list!");
		else { 
			ListNode <E> first = head;
			head = head.getNext();
			numNodes--;
			return first.getElement();
		}
	}

	// Return string representation of list.
	public String toString() {
		// Fill in the code
		String output = "[";
		ListNode<E> curNode = head;
		for (int i = 0; i < numNodes - 1; i++) {
			output += curNode.getElement() + ", ";
			curNode = curNode.getNext();
		}
		if (numNodes > 0) output += curNode.getElement();
		output += "]";
		return output;
	}

	// Reverse the list 
	public void reverse() {
		// Fill in the code
		ListNode<E> prev = null;
		ListNode<E> nextNode = head;
		for (int i = 0; i < numNodes; i++) {
			head = nextNode;
			nextNode = head.getNext();;
			head.setNext(prev);
			prev = head;
			//System.out.println(head.getElement());
		}

	}
}
*/

