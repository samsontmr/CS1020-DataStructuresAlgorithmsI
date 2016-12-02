/**
 *
 * author	: [Tan Min Rong Samson]
 * matric no: [A0140060A]
 * 
 */

import java.util.*;

public class HelloWorld {
	//Method to process operator and bits
	public static int truthTable(String operator, int first, int second) {
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
	public static void main(String[] args) {

		// declare the necessary variables
		int inputType, firstInt, secondInt, N, result;
		String nextLine, operator;
	
		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		inputType = Integer.parseInt(sc.nextLine());
	
		// cases to handle different input types
		switch(inputType) {
			case 1:
				N = Integer.parseInt(sc.nextLine());
				while (N > 0) {
					nextLine = sc.nextLine();
					StringTokenizer input = new StringTokenizer(nextLine);
					operator = input.nextToken();
					firstInt = Integer.parseInt(input.nextToken());
					secondInt = Integer.parseInt(input.nextToken());
					result = truthTable(operator, firstInt, secondInt);
					System.out.println(result);
					N--;
				}
				break;
			case 2:
				while (true) {
					nextLine = sc.nextLine();
					if ((nextLine.substring(0, 1)).equals("0")) {
						break;
					} else {
						StringTokenizer input = new StringTokenizer(nextLine);
						operator = input.nextToken();
						firstInt = Integer.parseInt(input.nextToken());
						secondInt = Integer.parseInt(input.nextToken());
						result = truthTable(operator, firstInt, secondInt);
						System.out.println(result);
					}
				}
				break;
			case 3:
				while (sc.hasNextLine()) {					
					nextLine = sc.nextLine();
					StringTokenizer input = new StringTokenizer(nextLine);
					operator = input.nextToken();
					firstInt = Integer.parseInt(input.nextToken());
					secondInt = Integer.parseInt(input.nextToken());
					result = truthTable(operator, firstInt, secondInt);
					System.out.println(result);
				}
				break;
		}
	}
}
