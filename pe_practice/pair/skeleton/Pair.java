/**
 *  Name          :
 *  Matric Number :
 */

import java.util.*;

public class Pair {
	static int[] sum;
	static int[] players;
	
	static int calc() {
		for (int i = 0; i < players.length; i++) {
			for (int j = i+1; j < players.length; j++) {
				sum[players[i] + players[j]]++;
			}
		}
		//System.out.println(Arrays.toString(sum));	
		int count = 0;
		for (int elem: sum) {
			if (elem > 1){
				int combs = elem * (elem - 1) / 2;
				count += combs *8;
			}
		}
		return count;

	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numP = sc.nextInt();
		players = new int[numP];
		
		for(int i = 0; i < numP; i++) {
			players[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int elem: players) {
			if (elem > max) max = elem;
		}
		int max2 = 0;
		for (int elem: players) {
			if (elem == max) continue;
			if (elem > max2) max2 = elem;
		}
		max += max2;

		sum = new int[max+1];

		System.out.println(calc());
	}
}
