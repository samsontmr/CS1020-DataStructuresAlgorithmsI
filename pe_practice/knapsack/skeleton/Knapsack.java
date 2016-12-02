/**
 *	name	  :Samson Tan
 *	matric no.:A0140060A
 */

import java.util.*;

class Result {
    // declare the member field
	int[] _items;	

	Result(int[] items) {
		_items = items;
	}


    // declare the constructor

	/** 
	 *	solve			: to count the number of sets of items satisfying the criteria.
	 * 		  			  (the total weight of all items in a set should not exceed the capacity of the sack)
	 * 	Pre-condition  	: idx must not be greater than _items.length
	 * 	Post-condition 	: returns 1 when valid set found
	 */	
	// you should determine the recurrence state(parameters) yourself.
	public int solve(int currWeight, int capacity, int idx) {
		// implementation
		if (currWeight > capacity) return 0;
		if (idx == _items.length) return 1;
		
		return solve(currWeight, capacity, idx+1) 
				+ solve(currWeight+_items[idx],capacity, idx+1);
	}
}

class Knapsack {

	public static void main(String[] args) {

		// declare the necessary variables
		Scanner sc = new Scanner(System.in);
		// declare a Scanner object to read input
		int[] items = new int[sc.nextInt()];
		int capacity = sc.nextInt();
		
		for (int i = 0; i < items.length; i++) {
			items[i] = sc.nextInt();
		}

		Result result = new Result(items);
		// read input and process them accordingly
		int out = result.solve(0, capacity, 0);
		System.out.println(out);
	}
}
