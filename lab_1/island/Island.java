/**
 * Name	       : Samson Tan Min Rong
 * Matric no.  : A0140060A
 */

import java.util.*;

public class Island {
	//
	//1. scan in array
	// new method findIsland
	//	isIsland
	//	1. scan through array until first 1 found, for(i < arr.length)
	//	2. record row startRow, record  startCol
	//	3. continue scanning while next cell is 1
	//	4. if next cell is 0, record current index, b
	//	5. measure distance,int c = b - startCol
	//	6. scan next row at index a
	// 		a. numRows = 1
	//    		if 1:
	//			numRows += 1
	// 			continue on next row
	//	  		if 0:
	//				if numRows > 1 || numCols > 1:
	//					isIsland = 1
	//	7. output array [startRow, startCol, numRows, numCols, isIsland]
	//new method delIsland(array [startRow, startCol, numRows, numCols], isIsland
	//	1. for (int i = startRow < numRows)
	//		for int j = startCol < numCols
	//			array2d[i][j] = 0
	//
	public static int[] findIsland(int[][] map) {
		int isIsland, startRow, startCol, numRows, numCols;
		int[] outArr;
		boolean found = false;
		boolean brk = false;
		startRow = 0;
		startCol = 0;
		isIsland = 0;
		numRows = 0;
		numCols = 0;
		//System.out.println(Arrays.toString(map[0]));
		//System.out.print(map.length);
		for (int i = 0; (i < map.length) && !brk; i++) {
			System.out.println("in loop" + i);
			for (int j = 0; j < map[0].length && !brk; j++) {
				System.out.println("in inner loop" + j);
				if ((map[i][j] == 1) && !found) {
					startRow = i;
					startCol = j;
					numRows = 1;
					found = true;
					System.out.println("j = " + j);
				} else {
					System.out.println(i + " " + j);
					System.out.println(map[i][j]);
					if (((map[0].length == 1) && !found) || ((map[i][j] == 1) && (j == (map[0].length - 1))) || (found && (map[i][j+1] == 0))) {
					numCols = j - startCol + 1;
					System.out.println("j2 = " + j);
					for (int k = i + 1 ; k <= map.length; k++) {
						//System.out.println("k " + k + " " + map[k][startCol]);
						if ((k < map.length) && (map[k][startCol] == 1)) {
							System.out.println("+1, " + k);
							numRows++;
						} else {
							brk = true;
							System.out.println("break");
							break;
						}
					}
				} 
			}
			}
		}
		if (numRows > 1 || numCols > 1) {
			isIsland = 1;
		}
		outArr = new int[]{startRow, startCol, numRows, numCols, isIsland};
		return outArr;
	}

	public static boolean isZero2DArray(int[][] arr) {
		boolean out = true;
		boolean brk = false;
		for (int i = 0; i < arr.length && !brk; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					out = false;
					brk = true;
					break;
				}
			}
		}
		return out;
	}

	public static void delIsland(int[] island, int[][] map) {
		int startRow = island[0];
		int startCol = island[1];
		int numRows = island[2];
		int numCols = island[3];
		for (int i = startRow; i < startRow + numRows; i++) {
			for (int j = startCol; j < startCol + numCols; j++) {
				map[i][j] = 0;
			}
		}
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		
		// declare the necessary variables
		int rows, cols, count;
		int[][] map;
		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());
		map = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				map[i][j] = sc.nextInt();
				System.out.print(map[i][j]);
			}
			System.out.printf("\n");
		}
		// read input and process them accordingly
		count = 0;
		while (!isZero2DArray(map)) {
			int[] out = findIsland(map);
			count += out[4];
			System.out.println(Arrays.toString(out));
			delIsland(out, map);
			printArr(map);
			System.out.printf("\n %d \n \n", count);
			//System.out.println(Arrays.toString
		}
		//System.out.print(Arrays.toString(out));
		System.out.print(Arrays.toString(map[0]));
		System.out.println(count);
	}
}
