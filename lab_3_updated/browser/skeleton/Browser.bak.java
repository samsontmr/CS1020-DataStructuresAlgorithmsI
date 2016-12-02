
/**
 *	Name		: Samson Tan Min Rong
 *	Matric No.	: A0140060A
 */

import java.util.*;

public class Browser {
	private LinkedList<Tab> tabList = new LinkedList<Tab>();
	Tab curTab;
	boolean debug = false;

	Browser() {
		curTab = new Tab("http://www.comp.nus.edu.sg");
		tabList.addFirst(curTab);
	}
	
	public void newTab(String name){
		//if (debug) System.out.println(prevTab);
		tabList.addAfter(new Tab(name), curTab);
		System.out.println(curTab.getName());
	}

	public void openHere(String name) {
		curTab.setName(name);
		System.out.println(name);
	}

	public void nextTab() {
		try {
			curTab = tabList.getNext(curTab);
		} catch (NullPointerException e) {
		} finally {
			System.out.println(curTab.getName());
		}
	}

	public void prevTab() {
		try {
			curTab = tabList.getPrev(curTab);
		} catch (NullPointerException e) {
		} finally {
			System.out.println(curTab.getName());
		}
	}

	public void closeTab() {
		Tab rm = curTab;
		try {
			curTab = tabList.getNext(curTab);
		} catch (NullPointerException e) {
			curTab = tabList.getPrev(curTab);
		} finally {	
			tabList.remove(rm);
			System.out.println(curTab.getName());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		Browser brwsr = new Browser();
		while(num-- > 0) {
			String nxt = sc.next();
			if (nxt.equals("NEWTAB")) {
				brwsr.newTab("http://www.comp.nus.edu.sg");
			} else if (nxt.equals("CLOSETAB")) {
				brwsr.closeTab();
			} else if (nxt.equals("NEXTTAB")) {
				brwsr.nextTab();
			} else if (nxt.equals("PREVTAB")) {
				brwsr.prevTab();
			} else if (nxt.equals("OPENHERE")) {
				brwsr.openHere(sc.next());
			} else if (nxt.equals("OPENNEW")) {
				brwsr.newTab(sc.next());
			}
		}

	}
}

class Tab {
	private String _name;
	
	Tab(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
}


class LinkedList<E> {
	protected ListNode<E> head = null;
	protected int numNodes;
	boolean debug = false;

	public void addFirst(E item) {
		head = new ListNode<E>(item, head);
		numNodes++;
	}

	public void addAfter(E item, E after) {
		if (debug) System.out.println("in addafter");
		ListNode<E> prev = getNode(after);
		if (debug) System.out.println("after prev");
		prev.setNext(new ListNode<E>(item, prev.getNext()));
	}

	public void remove(E item) {
		ListNode<E> cur = head;
		boolean found = false;
		if (cur.getElement().equals(item)) {
			head = cur.getNext();
		} else {
			while(cur.getNext() != null && !found) {
				if (cur.getNext().getElement().equals(item)) {
					found = true;
					cur.setNext(cur.getNext().getNext());
				} else {
					cur = cur.getNext();
				}
			}
		}
	}


	private ListNode<E> getNode (E item) {
		ListNode<E> cur = head;
		boolean found = false;
		while(cur != null && !found) {
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
		while(cur.getNext() != null && !found) {
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

	public int findIndex(E item) {
		ListNode<E> cur = head;
		boolean found = false;
		int idx = 0;
		while(cur != null && !found) {
			if (!cur.getElement().equals(item)) {
				idx++;
				cur = cur.getNext();
			} else {
				found = true;
			}
		}
		return idx;
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
