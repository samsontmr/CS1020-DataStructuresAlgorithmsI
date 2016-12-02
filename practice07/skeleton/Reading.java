// This program reads data in different formats and performs
// the respective operations.

// Add import statement(s) below
import java.util.*;

public class Reading {

	// Add a method operate(String, int, int) below
	// Perform operation on the operands based on the string in op
	public static int operate(String op, int operand1, int operand2) {
		//Precond: op must either be ADD, SUB or MUL
		//Postcond: operation will be performed on operand1 and operand2
		if (op.equals("ADD")) {
			return operand1 + operand2;
		} else if (op.equals("SUB")) {
			return operand1 - operand2;
		} else {
			return operand1 * operand2;
		}
		// complete the code
	}

	public static void main(String[] args) {
			// Fill in the code
		String format;
		Scanner sc = new Scanner(System.in);
		format = sc.nextLine();

		int result;

		if (format.equals("LIMIT")) {
			int num = Integer.parseInt(sc.nextLine());
			while (num > 0) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				String op = st.nextToken();
				int operand1 = Integer.parseInt(st.nextToken());
				int operand2 = Integer.parseInt(st.nextToken());
				result = operate(op, operand1, operand2);
				System.out.println(result);
				num--;
			}
		} else if (format.equals("SENTINEL")) {
			String next = sc.nextLine();
			while (next.substring(0,2).equals("-1") != true) {
				StringTokenizer st = new StringTokenizer(next);
				String op = st.nextToken();
				int operand1 = Integer.parseInt(st.nextToken());
				int operand2 = Integer.parseInt(st.nextToken());
				result = operate(op, operand1, operand2);
				System.out.println(result);
				next = sc.nextLine();
			}
		} else if (format.equals("EOF")) {
			while (sc.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				String op = st.nextToken();
				int operand1 = Integer.parseInt(st.nextToken());
				int operand2 = Integer.parseInt(st.nextToken());
				result = operate(op, operand1, operand2);
				System.out.println(result);
			}			
		}
	}
}
