/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;
/*
class Mergesort {
	static void mergeSort(int[] inputArray) {
		int size = inputArray.length;
		if (size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = Arrays.copyOfRange(inputArray, 0, leftSize);
		int[] right = Arrays.copyOfRange(inputArray, leftSize, inputArray.length);
		mergeSort(left);
		mergeSort(right);
		merge(left, right, inputArray);
	}

	public static void merge(int[] left, int[] right, int[] arr) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, j = 0, k = 0;
		
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < leftSize) {
			arr[k++] = left[i++];
		}
		while (j < leftSize) {
			arr[k++] = right[j++];
		}
	}

	public static int solveMin(int[] input) {
		mergeSort(input);
		return input[0] * input[1] * input[2];
	}
	
	public static int solveMax(int[] input) {
		mergeSort(input);
		return input[input.length-3] * input[input.length-2] * input[input.length-1];
	}

}
*/
/*class Result {
	// declare the member field
	int[] input;
	ArrayList<Integer> minNumsIdx = new ArrayList<Integer>();
	ArrayList<Integer> maxNumsIdx = new ArrayList<Integer>();
	// declare the constructor
	Result(int[] in) {
		input = in;
	}*/
	/**
	 * 	solveMin		: to find the minimum product of triplets.
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */
	 /*
	public int solveMin(int count) {
		// implementation
		if (count == 3) 
			return input[minNumsIdx.get(0)] 
					* input[minNumsIdx.get(1)] 
					* input[minNumsIdx.get(2)];

		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < input.length; i++) {
			int curr = input[i];
			if (curr < min && !minNumsIdx.contains(i)) {
				min = curr;
				minIdx = i;
			}
		}
		minNumsIdx.add(minIdx);	
		return solveMin(count+1);
	}
*/
	/**
	 *	solveMax		: to find the maximum product of triplets.
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */	
/*	public int solveMax(int count) {
		// implementation
		if (count == 3) 
			return input[maxNumsIdx.get(0)] 
					* input[maxNumsIdx.get(1)] 
					* input[maxNumsIdx.get(2)];

		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		for (int i = 0; i < input.length; i++) {
			int curr = input[i];
			if (curr > max && !maxNumsIdx.contains(i)) {
				max = curr;
				maxIdx = i;
			}
		}
		maxNumsIdx.add(maxIdx);
		return solveMax(count+1);
	}

}*/

public class Triplet {
	Integer[] solve;
	public Integer solve(boolean min, int product, int count, int idx) {
		if (count == 3) return product;
		if (idx == solve.length) return null;
		
		Integer notChosen = solve(min, product, count, idx+1);
		Integer chosen = solve(min, product*solve[idx].intValue(), count+1, idx+1);

		if (notChosen == null) return chosen;
		if (chosen == null) return notChosen;

		if (min) {
			if (notChosen < chosen) return notChosen;
			return chosen;
		}

		if (notChosen > chosen) return notChosen;
		return chosen;
	}

	public void run() {
		// declare the necessary variables
		Scanner sc = new Scanner(System.in);
		// declare a Scanner object to read input
		int numIn = sc.nextInt();
		LinkedList<Integer> input = new LinkedList<Integer>();

		for (int i = 0; i < numIn; i++) {
			input.add(sc.nextInt());
		}

		Collections.sort(input);
		solve = new Integer[6];
		if (input.size() > 5) {
			for (int i = 0; i < 3; i++) {
				solve[i] = new Integer(input.get(i));
				solve[5-i] = new Integer(input.get(input.size()-1-i));
			}
		} else {
			solve =  input.toArray(new Integer[input.size()]);
		}
		
		/* Recursive*/
		int min = solve(true, 1, 0, 0);
		int max = solve(false, 1, 0, 0);
		

		/* Loop
		Result result = new Result(input);
		int min = result.solveMin(0);
		int max = result.solveMax(0);
		*/

		//int min = Mergesort.solveMin(input);
		//int max = Mergesort.solveMax(input);

		System.out.println(min + " " + max);
		// read input and process them accordingly
	}

	public static void main(String[] args) {
		Triplet triplet = new Triplet();
		triplet.run();
	}
}
