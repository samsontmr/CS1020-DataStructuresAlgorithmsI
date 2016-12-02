/**
 *
 * author	: [Tan Min Rong Samson]
 * matric no: [A0140060A]
 * 
 */

import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {

		// declare the necessary variables
		int inputType, firstInt, secondInt, N, result;
		String nextLine, operator;
	
		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		inputType = Integer.parseInt(sc.nextLine());
		
		int truthTable(String operator, int first, int second) {
			if (operator.equals("AND")) {
				if (first == 1 && second == 1) {
					return 1;
				} else {
					return 0;
				}
			} else {
				if (first == 0 && second == 0) {
					return 0;
				} else {
					return 1;
				}
			}
		}

	
		switch(type) {
			case 1:
				while (N > 0) {
					nextLine = sc.nextLine();
					StringTokenizer input = new StringTokenizer(nextLine);
					operator = input.nextToken();
					firstInt = Integer.parseInt(input.nextoken());
					secondInt = Integer.parseInt(input.nextoken());
					result = TruthTable(operator, firstInt, secondInt);
					System.out.println(result);
					N--;
				}
			case 2:
				while (true) {
					nextLine = sc.nextLine();
					if (Integer.parseInt(nextLine) == 0) {
						break;
					} else {
						StringTokenizer input = new StringTokenizer(nextLine);
						operator = input.nextToken();
						firstInt = Integer.parseInt(input.nextoken());
						secondInt = Integer.parseInt(input.nextoken());
						result = TruthTable(operator, firstInt, secondInt);
						System.out.println(result);
					}
			case 3:
				while (sc.hasNextLine()) {					
					nextLine = sc.nextLine();
					StringTokenizer input = new StringTokenizer(nextLine);
					operator = input.nextToken();
					firstInt = Integer.parseInt(input.nextoken());
					secondInt = Integer.parseInt(input.nextoken());
					result = TruthTable(operator, firstInt, secondInt);
					System.out.println(result);
				}
		}
	}
}
