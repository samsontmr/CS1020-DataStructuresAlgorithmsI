// CS1020 (AY2014/5 Semester 2)
// Take-home Lab3 Ex1
// Name:
// Matric. No.:
// Lab group:
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Marks will be awarded for this in sit-in labs.
// Please remove this line and its preceding 3 lines.

import java.util.*;

class ListNode {
	private ListNode nextPointer;
	private String body;

	public ListNode(){
		
	}

	public ListNode(String content) {
		body = content;		
	}

	public void setNextPointer(ListNode node) {
		nextPointer = node;
	}

	public ListNode getNextPointer() {
		return nextPointer;
	}

	public void setBody(String input) {
		body = input;
	}

	public String getBody() {
		return body;
	}
}

class LinkedList {
	private ListNode head;
	private ListNode tail;
	
	public void initialiseLinkedList(int size) {
		//initialise the linked list here
	}
	
	public void manipulate(int startingIndex) {
		//do your working here
	}

	public String print() {
		//for printing the answer
	}

}

public class FlipList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();

		System.out.println(list.print());
	}
}

