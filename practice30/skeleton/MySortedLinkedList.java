import java.util.*;

class MySortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {
	public void addOrdered(E item) {
		boolean added = false;
		if (size() == 0) {
			addFirst(item);
			added = true;
		} else if (item.compareTo(get(size() - 1)) > -1) {
			addLast(item);
			added = true;
		}
		for (int i = 0; i < size() && !added; i++) {
			//System.out.println("in add");
			if (item.compareTo(get(i)) < 0) {
				add(i, item);
				added = true;
			}
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
/******* Class definition for MySortedLinkedList *******/
/*class MySortedLinkedList <E extends Comparable <E>> {

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
		//System.out.println(output);
		if (numNodes > 0) output += curNode.getElement();
		output += "]";
		return output;


	}

	// Add item to the list, maintaining the order.
	public void addOrdered(E item) {
		if (numNodes == 0 || item.compareTo(head.getElement()) < 0) {
			this.addFirst(item);
		} else {
			ListNode<E> cur = head;
			boolean found = false;
			while(cur.getNext() != null && !found) {
				if (item.compareTo(cur.getNext().getElement()) < 0) {
					found = true;
					cur.setNext(new ListNode<E>(item, cur.getNext()));
					//System.out.println(cur.getNext().getNext().getNext().getElement());
				} else {
					cur = cur.getNext();
				}
			}
			if (!found) cur.setNext(new ListNode<E>(item, null)); 
			numNodes++;
		}
	}

}
*/
