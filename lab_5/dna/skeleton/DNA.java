/**
 *	Name	  :
 *	Matric no.:
 */

import java.util.*;

public class DNA {
    
    // attributes
    int numK;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public void run() {
        // declare the necessary variables
        Scanner sc = new Scanner(System.in);
        // declare a Scanner object to read input
        int numSeq = sc.nextInt();
        numK = sc.nextInt();
        String seq = sc.next();
        
        generate(seq);
        
        int numR = sc.nextInt();
        // read input and process them accordingly
        while (numR-- > 0) {
        	String input = sc.next();
        	if (map.containsKey(input)) {
        		System.out.println(map.get(input));
        	} else {
        		System.out.println(0);
        	}
        }
    }
    
    /**
     *	generate		: use this method to generate/pre-process the substrings of length K from DNA
     *	Pre-condition	:
     *	Post-condition	:
     */
    public void generate(String dna) {
        // implementation
        
        for (int i = 0; i < dna.length()-numK+1; i++) {
        	String temp = "";
        	for (int j = 0; j < numK; j++) {
        		temp += dna.substring(i+j, i+j+1);
        	}
        	if (map.containsKey(temp)) {
        		map.put(temp, (int) map.get(temp)+1);
        	} else {
        		map.put(temp, 1);
        	}
        }
    }
    
    /**
     *	count			: use this method to answer one query.
     *	Pre-condition	:
     *	Post-condition	:
     */
    public int count(String substring) {
        // implementation
        return 0;
    }

    public static void main(String[] args) {
        DNA dna = new DNA();
        dna.run();
    }
}
