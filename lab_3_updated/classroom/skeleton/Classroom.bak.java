
/**
 *	Name		: Samson Tan Min Rong
 *	Matric No.	: A0140060A
 */

import java.util.*;

public class Classroom {
	private CirLinkedList<String> stdlst;
	boolean debug = false;

	Classroom() {
 		stdlst = new CirLinkedList<String>("Sharon");
	}

	public void enter(String std1, String std2, int k) {
		int idx = stdlst.findIndex(std2) + k;
		//if (debug) System.out.println(idx);
		if (idx != 0) {
			idx %= stdlst.size();
			if (debug) System.out.println(idx + " " + k);
		}
		stdlst.addAfter(std1, stdlst.getAt(idx));
		if (debug) System.out.println(stdlst.getAt(idx));
	}

	public void leave(String std) {
		stdlst.remove(std);
	}

	public void list() {
		System.out.println(stdlst);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		Classroom clrm = new Classroom();

		while(num-- > 0) {
			String cmd = sc.next();
			if (cmd.equals("enter")) {
				clrm.enter(sc.next(), sc.next(), sc.nextInt());
			} else if (cmd.equals("leave")) {
				clrm.leave(sc.next());
			} else if (cmd.equals("list")) {
				clrm.list();
			}
		}

	}
}

class CirLinkedList<E> {
	protected ListNode<E> head = null;
	protected int numNodes;
	boolean debug = false;

	public int size() {
		return numNodes;
	}

	CirLinkedList(E item) {
		head = new ListNode<E>(item, head);
		head.setNext(head);
		numNodes++;
	}

	public void addFirst(E item) {
		ListNode<E> prev = getPrevNode(head.getElement());
		head = new ListNode<E>(item, head);
		prev.setNext(head);
		numNodes++;
	}

	public void addAfter(E item, E after) {
		if (debug) System.out.println("in addafter");
		ListNode<E> prev = getNode(after);
		if (debug) System.out.println("after prev");
		prev.setNext(new ListNode<E>(item, prev.getNext()));
		numNodes++;
	}

	public void remove(E item) {
		ListNode<E> cur = head;
		boolean found = false;
		if (cur.getElement().equals(item)) {
			head = cur.getNext();
		} else {
			while(cur.getNext() != head && !found) {
				if (cur.getNext().getElement().equals(item)) {
					found = true;
					cur.setNext(cur.getNext().getNext());
				} else {
					cur = cur.getNext();
				}
			}
		}
		numNodes--;
	}


	private ListNode<E> getNode (E item) {
		ListNode<E> cur = head;
		boolean found = false;
		if (!cur.getElement().equals(item)) {
			cur = cur.getNext();
			if (debug) System.out.println(cur);
		} else {
			found = true;
		}
		while(cur != head && !found) {
			if (!cur.getElement().equals(item)) {
				cur = cur.getNext();
				if (debug) System.out.println(cur);
			} else {
				found = true;
			}
		}
		return cur;
	}

	private ListNode<E> getPrevNode(E item) {
		ListNode<E> cur = head;
		boolean found = false;
		ListNode<E> prev = null;
		while(cur.getNext() != head && !found) {
			if (cur.getNext().getElement().equals(item)) {
				found = true;
				prev = cur;
			} else {
				cur = cur.getNext();
			}
		}
		return prev;
	}

	public E getPrev(E item) {
		return getPrevNode(item).getElement();
	}

	public E getNext(E item) {
		ListNode<E> cur = head;
		boolean found = false;
		E next = getNode(item).getNext().getElement();
		return next;
	}

	public E getAt(int idx) {
		ListNode<E> cur = head;
		E elem = null;
		for (int i = 0; i < numNodes; i++) {
			if (i == idx) {
				elem = cur.getElement();
			}
			cur = cur.getNext();
		}
		return elem;
	}
		

	public int findIndex(E item) {
		ListNode<E> cur = head;
		boolean found = false;
		int idx = 0;
		if (!cur.getElement().equals(item)) {
			idx++;
			cur = cur.getNext();
		} else {
			found = true;
		}
		while(cur != head && !found) {
			if (!cur.getElement().equals(item)) {
				idx++;
				cur = cur.getNext();
			} else {
				found = true;
			}
		}
		return idx;
	}
	
	@Override public String toString() {
		ListNode<E> cur = head;
		String output = (String) cur.getElement();
		cur = cur.getNext();
		while (cur != head) {
			output += " " + cur.getElement();
			cur = cur.getNext();
		}
		return output;
	}
}

class ListNode<E> {
	protected E element;
	protected ListNode<E> next;

	/* constructors */
	public ListNode(E item) {
		element = item;
		next = null;
	}

	public ListNode(E item, ListNode<E> n) {
		element = item;
		next = n;
	}

	/* get the next ListNode */
	public ListNode<E> getNext() {
		return this.next;
	}

	/* get the element of the ListNode */
	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode<E> item) {
		this.next = item;
	}

	public void setElement(E item) {
		this.element = item;
	}
}
