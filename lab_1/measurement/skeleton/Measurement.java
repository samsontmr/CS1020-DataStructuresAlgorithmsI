/**
 * Name	       : Samson Tan
 * Matric no.  : A0140060A
 */

import java.util.*;
import java.text.DecimalFormat;

public class Measurement {

	public static void main(String[] args) {

		// declare the necessary variables
		int students, shortest, tallest, heightMin, heightMax;
		double shortestBMI, tallestBMI;
		String[] names;
		int[] heights, weights;
		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);
		// read input and process them accordingly
		students = Integer.parseInt(sc.nextLine());
		names = new String[students];
		heights = new int[students];
		weights = new int[students];
		
		for (int i = 0; i < students; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			names[i] = st.nextToken();
			heights[i] = Integer.parseInt(st.nextToken());
			weights[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(names));
		heightMin = heights[0];
		heightMax = heights[0];
		tallest = 0;
		shortest = 0;
		for (int i = 0; i < students; i++) {
			if (heights[i] < heightMin) {
				heightMin = heights[i];
				shortest = i;
			} else if (heights[i] > heightMax) {
				heightMax = heights[i];
				tallest = i;
			}
		}
	
		shortestBMI = (double) weights[shortest] / Math.pow((double) heights[shortest]/100, 2);
		tallestBMI = (double) weights[tallest] / Math.pow((double) heights[tallest]/100, 2);
		
		DecimalFormat result = new DecimalFormat("0.00");

		System.out.println(names[shortest] + " is the shortest with BMI equals to " + result.format(shortestBMI) + ".");
		System.out.println(names[tallest] + " is the tallest with BMI equals to " + result.format(tallestBMI) + ".");
	}
}
