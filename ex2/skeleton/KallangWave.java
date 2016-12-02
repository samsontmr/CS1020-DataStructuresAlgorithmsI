// CS1020 (AY2014/5 Semester 2)
// Take-home Lab3 Ex2
// Name:
// Matric. No.:
// Lab group:
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Marks will be awarded for this in sit-in labs.
// Please remove this line and its preceding 3 lines.

// HINT: More likely than not this exercise will be easier to solve 
//       if you add more methods to CircularLinkedList and/or ListNode. ;)

class ListNode <E> {

    private E element;
    private ListNode <E> next;

    public ListNode(E item) {
        this(item, null);
    }

    public ListNode(E item, ListNode <E> next) {
        element = item;
        this.next = next;
    }

    public ListNode <E> getNext() {
        return next;
    }

    public E getElement() {
        return element;
    }

    public void setNext(ListNode <E> next) {
        this.next = next;
    }
}

class CircularLinkedList <E> {

    private ListNode <E> head = null;
    private int numNodes = 0;

    // Method description: Returns whether this linked list has no nodes.
    public boolean isEmpty() {
        return (numNodes == 0);
    }

    // Method description: Returns the number of nodes in this linked list.
    public int size() {
        return numNodes;
    }

    // Method description:
    // Pre-conditions:
    // Post-conditions:
    public E getFirst() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("Can't get from an empty list");
        else
            return head.getElement();
    }

    // Method description:
    // Pre-conditions:
    // Post-conditions:
    public void addFirst(E item) {
        // TODO: Complete this part
        numNodes++;
    }

    // Method description:
    // Pre-conditions:
    // Post-conditions:
    public E removeFirst() throws NoSuchElementException {
        // TODO: Complete this part
        numNodes--;
    }

    // Whenever overriding a function, it is good practice to prefix it with @Override.
    // Feel free to remove these two lines. Wouldn't want any unnecessary comments to get in the way of your marks.
    // Method description:
    // Pre-conditions:
    // Post-conditions:
    @Override
    public String toString() {
        // TODO: Complete this part
        return "";
    }
}

public class KallangWave {

    private CircularLinkedList<String> audience;

    public KallangWave(String audienceChars) {

    }

    // Method description:
    // Pre-conditions:
    // Post-conditions:
    private void simulateWave(int moments) {

    }

    // Method description:
    // Pre-conditions:
    // Post-conditions:
    private void printState() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // What do?
    }
}

