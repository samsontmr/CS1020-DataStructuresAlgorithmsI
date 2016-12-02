/**
 * Name          : Samson Tan Min Rong
 * Matric number : A0140060A
 */

import java.util.*;

public class Cake {
	Queue<Integer> queue = new LinkedList<Integer>();
	int maxR, cur, curR, max, last;
	boolean debug = false;
	
	private void findMax(String type, int amt) {
		cur += amt;
		if (type.equals("R")) {
			if (curR < maxR) {
				curR++;
			} else {
				cur -= queue.poll();
			}
				queue.offer(amt + last);
				last = 0;
			if (debug) System.out.println("cur " + cur);
			if (debug) System.out.println("queue peek " + queue.peek());
		}
		else {
			last += amt;
		}
		if (cur > max) max = cur;
	}
	

	public void run() {
		Scanner sc = new Scanner(System.in);
		int numB = sc.nextInt();
		maxR = sc.nextInt();
		while (numB-- > 0) {
			findMax(sc.next(), sc.nextInt());	
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		//implement your main method here
		Cake cake = new Cake();
		cake.run();
	}
}
