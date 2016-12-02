// This program computes the mean and standard deviation
// of an array of values.

// Add import statement(s) below
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;

public class Statistics {

	public static void main(String[] args) {

		// Fill in the code

		int[] arr = readArray();
		double meanVal = computeMean(arr);
		double stdevVal = computeStdDev(arr);

		DecimalFormat result = new DecimalFormat("0.000");
		// For checking; remove the following 2 lines before submission
		//System.out.print("Values: ");
		//printArray(arr);

		System.out.println("Mean = " + result.format(meanVal));
		System.out.println("Standard deviation = " + result.format(stdevVal));
	}

	// Read a list of values into an array arr
	public static int[] readArray() {
		// Fill in the code
		int n;
		int[] intArr;
		System.out.print("Enter size of array: ");
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		intArr = new int[n];
		
		if (n == 1) {
			System.out.printf("Enter 1 value: \n");
		} else {
			System.out.printf("Enter %d values: \n", n);
		}

		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}
		return intArr;
	}

	// Compute mean of the values in arr
	// Precond: arr.length > 0
	public static double computeMean(int[] arr) {
		// Fill in the code
		int arrLen, sum;
		double mean;
		arrLen = arr.length;
		sum = 0;

		for (int elem: arr) {
			sum += elem;
		}
		
		mean = sum / (double) arrLen;
		return mean;
	}

	// Compute standard deviation of the values in arr
	// Precond: arr.length > 0
	public static double computeStdDev(int[] arr) {
		// Fill in the code
		double var, stdev, mean, n, sum;
		mean = computeMean(arr);
		n = arr.length;
		sum = 0;

		for (int elem: arr) {
			sum += Math.pow(elem - mean, 2);
		}

		stdev = Math.sqrt(sum / n);

		return stdev;

	}

	// Print the array arr on a single line.
	// Note that the last element has a space after it.
	public static void printArray(int[] arr) {
		for (int element: arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
} 

