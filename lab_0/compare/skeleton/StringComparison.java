/**
 *
 * author	: [Tan Min Rong Samson]
 * matric no: [A0140060A]
 * 
 */

import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {

		// declare the necessary variables
		String string1, string2;
		int comparedVal;

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		string1 = sc.next();
		string2 = sc.next();

		comparedVal = string1.compareToIgnoreCase(string2); //compare strings
		
		//prints predetermined integer based on comparison result
		if (comparedVal < 0) {
			System.out.println(1);
		} else if (comparedVal > 0) {
			System.out.println(2);
		} else {
			System.out.println(0);
		}
	}
}
