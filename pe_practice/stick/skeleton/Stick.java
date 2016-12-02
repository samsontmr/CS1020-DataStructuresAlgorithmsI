/**
 *	name	  : Samson Tan
 *	matric no.: A0140060A
 */

import java.util.*;

public class Stick {
	int[] sticks;
	int length;
	
	public int solve(int totalLength, int idx) {
		if (idx == sticks.length) {
			if (totalLength != length) return -1;
			return 0;
		}

		int notChosen = solve(totalLength, idx+1);
		int chosen = solve(totalLength + sticks[idx], idx+1);
		if (chosen < 0) return notChosen;
		chosen++;
		if (notChosen < 0) return chosen;
		if (notChosen < chosen) return notChosen;
		return chosen;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int numSticks = sc.nextInt();
		sticks = new int[numSticks];
		length = sc.nextInt();

		for (int i = 0; i < numSticks; i++) {
			sticks[i] = sc.nextInt();
		}

		int result = solve(0, 0);
		System.out.println(result);
	}

	public static void main(String[] args) {
		// declare the necessary variables
		Stick stick = new Stick();	
		// declare a Scanner object to read input
		stick.run();
		// read input and process them accordingly
	}
}
