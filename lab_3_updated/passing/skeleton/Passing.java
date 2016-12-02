
/**
 *	Name		: Samson Tan Min Rong
 *	Matric No.	: A0140060A
 */

import java.util.*;

public class Passing {
	private MyLinkedList<String> plst;
	private HashMap<String, Integer> numRec; 
	private int _K;
	static boolean debug = false;
	int ball;

	Passing(int K) {
 		_K = K;
		plst = new MyLinkedList<String>();
		numRec = new HashMap<String, Integer>();
	}
	
	public void addPlayer(String name) {
		//if (debug) System.out.println(name);
		plst.addLast(name);
		numRec.put(name, 0);
		//if (debug) System.out.println(plst);
	}

	public void nextTurn(int passes) {
		int idx = (ball + passes) % plst.size();
		String rec = plst.get(idx);
		numRec.put(rec, numRec.get(rec) + 1);
		if (numRec.get(rec) >= _K) {
			System.out.println(rec);	
			plst.remove(rec);
			numRec.remove(rec);
			ball = idx % plst.size();
		} else {
			plst.swap(ball, idx);
			System.out.println(plst.get(ball));	
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int players = sc.nextInt();
		int turns = sc.nextInt();
		int K = sc.nextInt();

		Passing pass = new Passing(K);

		while(players-- > 0) {
			pass.addPlayer(sc.next());
		}
		
		while(turns-- > 0) {
			pass.nextTurn(sc.nextInt());
			if (debug) System.out.println("turns left " + turns);
		}

	}
}


class MyLinkedList<E> extends LinkedList<E> {
	public E getNext(E item) {
		return get((indexOf(item) + 1) % size());
	}

	public void swap(int idx1, int idx2) {
		E item1 = get(idx1);
		set(idx1, get(idx2));
		set(idx2, item1);
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
