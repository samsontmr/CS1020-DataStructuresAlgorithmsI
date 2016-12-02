/*
 * author		: [Tan Min Rong Samson]
 * matric no.	: [A0140060A]
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  : string with only alphabetical characters of even length
	 * 		POST-Condition : returns true if word is palindrome, otherwise false
	 */
	public static boolean isPalindrome(String word) {
		int length;
		String front, back, reversedBack;
		length = word.length();
		front = word.substring(0, length/2); //separates word into two words
		back = word.substring(length/2, length);
		
		//reverses back string and compares it to front string to check if they are equal
		reversedBack = new StringBuilder(back).reverse().toString();
		
		if (front.equals(reversedBack)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// declare the necessary variables
		String string1, string2, catString, result;

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		string1 = sc.next();
		string2 = sc.next();
		catString = string1.trim() + string2.trim();
		
		// simulate the problem
		if (isPalindrome(catString)) {
			result = "YES";
		} else {
			result = "NO";
		}

		// output the result
		System.out.println(result);
	}
}
