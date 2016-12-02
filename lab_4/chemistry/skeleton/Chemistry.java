/**
 * Name          : Samson Tan Min Rong
 * Matric number : A0140060A
 */

import java.util.*;

public class Chemistry {
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	int idx;
	String formula = null;
	Stack<Integer> stack = new Stack<Integer>();
	boolean debug = false;

/*	private boolean hasNextInt() {
		if (debug) System.out.println("in hasNextInt");
		if (idx + 1 >= formula.length()) {
			return false;
		} else {
			return Character.isDigit(formula.charAt(idx+1));
		}
	}

	private int nextInt() {
		if (debug) System.out.println("in nextInt");
		return Character.getNumericValue(next());
	}

	private char next() {
		if (debug) System.out.println("in next");
		char out = formula.charAt(idx);
		idx++;
		return out;
	}

	private int multiple() {
		if (debug) System.out. println("in multiple");
		if (hasNextInt()) {
			return nextInt();
		} else {
			return 1;
		}
	}*/

	private int calc() {
		int count = 0;
		while (idx < formula.length()) {
			char nextChar = formula.charAt(idx);
			if (nextChar == '(') {
				stack.push(-1);
			} else if (nextChar == ')') {
				int temp = 0;
				while (stack.peek() != -1) {
					if (debug) System.out.println(stack.peek());
					temp += stack.pop();
				}
				stack.pop();
				stack.push(temp);
			} else if (Character.isDigit(nextChar)) {
				stack.push(stack.pop() * Character.getNumericValue(nextChar));
					if (debug) System.out.println(stack.peek());
			} else {
				stack.push(map.get(nextChar));
			}
			idx++;
		}
		while (!stack.empty()) {
			count += stack.pop();
		}
		return count;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		while(num-- > 0) {
			map.put(sc.next().charAt(0), sc.nextInt());
		}

		formula = sc.next();
		if(debug) System.out.println(formula);
		int out = calc();

		System.out.println(out);
	}

	public static void main(String[] args) {
        //implement your main method here
		Chemistry chem = new Chemistry();
		chem.run();
    }
}
