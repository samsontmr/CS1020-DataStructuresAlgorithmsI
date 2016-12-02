// This program computes the furthest distance (number of road units)
// a jogger can run from PGP and back. Road is divided into units,
// each unit is uphill, flat or downhill with an associated time.

import java.util.*;

import java.util.*;

public class Jogging {
	public static final int UP = 0;
	public static final int FLAT = 1;
	public static final int DOWN = 2;
	public static int[] ufdTimes = new int[3]; // store times for uphill, flat, downhill
	
	public static int calc(String roadData, int currTime, int idx, int timeLimit, int roadLength) {
		if (idx == roadLength) return 0;
		char type = roadData.charAt(idx);
		int add = 0;	
		if (type == 'u' || type == 'd') add = ufdTimes[0] + ufdTimes[2];
		if (type == 'f') add = ufdTimes[1] * 2;

		if (add + currTime > timeLimit) return 0;

		return 1 + calc(roadData, add+currTime, idx+1, timeLimit, roadLength);
	}


	public static void main(String[] args) {

		// Read input data
		Scanner sc = new Scanner(System.in);
		int timeLimit = sc.nextInt();
		int roadUnits = sc.nextInt();
		ufdTimes[UP] = sc.nextInt();
		ufdTimes[FLAT] = sc.nextInt();
		ufdTimes[DOWN] = sc.nextInt();

		String roadData = sc.next();
		System.out.println(calc(roadData, 0, 0, timeLimit, roadUnits));
	}

	

	// Recursion to compute the number of road units he can run and
	// get back to PGP on time.

}

