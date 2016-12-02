/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

class Result {

    // declare the member field
	int numK;
	HashMap<String, Integer> map1 = new HashMap<String, Integer>();
	HashMap<String, Integer> map2 = new HashMap<String, Integer>();
	String[] hash1, hash2;
    // declare the constructor
	
	Result(String dna1, String dna2, int numK) {
		this.numK = numK;
		
		//hash1 = new String[dna1.length()-numK+1];
		//hash2 = new String[dna2.length()-numK+1];
		generate(dna1, map1);
		generate(dna2, map2);
	}
	
	/**
	 *	generate		: use this method to generate/pre-process the substrings of length K from string-idx, 
	 *					  either first string or second string
	 *	Pre-condition	:
	 *	Post-condition	:
	 */
	
	private int hash(String input) {
		int sum = 0;
		for (int i = 0; i< input.length(); i++) {
			sum = sum*31 + input.charAt(i);
		}
		return sum % hash1.length;
	}
	
	public void generate(String dna, HashMap<String,Integer> map) {
		// implementation
		for (int i = 0; i < dna.length() - numK + 1; i++) {
			map.put(dna.substring(i, i + numK), 1);
		}
	}

	/**
	 *	find			: use this method to check whether a particular substring exists in string-idx, 
	 *				  	  either first string, or second string
	 *	Pre-condition	:
	 *	Post-condition	:
	 */
	public int find(String substring) {
		// implementation
		/*int hashVal = hash(substring);
		
		int out = 0;
		
		if (hash1[hashVal] != null) {
			if (hash1[hashVal].equals(substring)) out+=1;
		}
		if (hash2[hashVal] != null) {
			if (hash2[hashVal].equals(substring)) out+=2;
		}
		return out;*/
		int out = 0;
		if (map1.containsKey(substring)) out+= 1;
		if (map2.containsKey(substring)) out+= 2;
		return out;
	}
}

class Find {

	public static void main(String[] args) {

		// declare the necessary variables

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);
		// read input and process them accordingly
		sc.next();
		int numK = sc.nextInt();
		Result result = new Result(sc.next(), sc.next(), numK);
		int numI = sc.nextInt();
		while (numI-- > 0) {
			String temp = sc.next();
			System.out.println(result.find(temp));
		}
	}
}