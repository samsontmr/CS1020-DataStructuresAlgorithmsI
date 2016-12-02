/**
 * Name	       : Samson Tan
 * Matric no.  : A0140060A
 */

import java.util.*;

public class Findx {

	public static void main(String[] args) {

		// declare the necessary variables
		int rows, cols, result;
		char[][] arr;
		boolean debug = false;
		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		cols = sc.nextInt();
		arr = new char[rows][cols];
		
		//reads input into char array	
		for(int i = 0; i < rows; i++) {
			String curRow = sc.next();
			for(int j = 0; j < cols; j++) {
				arr[i][j] = curRow.charAt(j);
			}
		}
		
		Map map = new Map(rows, cols, arr);
		result = map.getNumX();

		System.out.println(result);
		if (debug) {
			for(char[] elem: arr) {
				for(char i: elem){
					System.out.print(i);
				}
				System.out.print("\n");
			}
		}
		// read input and process them accordingly
	}
}
		
class Map {
	static boolean debug = false;
	
	int counter, rows, cols;
	char[][] map;
	
	Map(int r, int c, char[][] m) {
		//Constructor 
		//Pre condition: rows and cols must be > 0 and corresponding to map dimensions
		//Post condidtion: constructs Map object with rows, cols, counter and map attributes
		rows = r;
		cols = c;
		map = m;
		counter = 0;
	}
	
	void checkCorners(int row, int firstCol, int secondCol, char[][] map) {
		//Precondition: integer parameters must be  >= 0 and within "map" array range.
		//Postcondition: class variable
		//xTL, xTR, xBL, xBR check if corners are x
		boolean xTL = (Character.compare('X', map[row][firstCol]) == 0); 
		boolean xTR = (Character.compare('X', map[row][secondCol]) == 0);
		int numDiff = secondCol - firstCol;
		
		if (xTL && xTR) {
			if (((row + numDiff) < map.length)){ //checks if bottom corners are in range of array
				boolean xBL = (Character.compare('X', map[row + numDiff][firstCol]) == 0);	
				boolean xBR = (Character.compare('X', map[row + numDiff][secondCol]) == 0);
				
				//checks if centre x or centre four xs are reached, if so, increment counter by 1 and terminate
				if ((firstCol == secondCol) || ((firstCol == secondCol - 1) && xBL && xBR)) {
					counter += 1;
					if (debug) {
						System.out.println("current count: " + counter + "\n");
					}
				} else if (xBL && xBR) {
					if (debug) {
						System.out.println("in xBL");
					}

					//calls itself recursively until centre x/xs reached or char other than 'x' encountered
					checkCorners(row + 1, firstCol + 1, secondCol - 1, map);
				}
			}
		}
	}
	
	int getNumX() { //calculates number of super Xs and returns an integer
		//Pre condition: rows and cols must be > 0 and corresponding to map dimensions
		//Post condition: counter updates to reflect number of super Xs in 2D array "map"
		counter = 0;
		for (int i = 0; i < rows; i++) {
						if (debug) {
							System.out.println("Row: " + i);
						}
			for (int j = 0; j < cols; j++) {
						if (debug) {
							System.out.println("Col: " + j);
						}
				if (Character.compare(map[i][j], 'X') == 0) { //search for first x
						if (debug) {
							System.out.println("found x");
						}
					for(int k = j + 2; k < cols; k++) { 
							//starts searching for next x, skips to first x's index + 2 to avoid 2x2 super X
							checkCorners(i, j, k, map);
						if (debug) {
							System.out.println(i + " " + j + " " + k);
							System.out.println("current count: " + counter + "\n");
						}
					
					}
				}
			}
		}
		return counter;
	}
}
