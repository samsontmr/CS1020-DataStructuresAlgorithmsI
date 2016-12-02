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

	public static int numIsland(int[][] map) {
		int[][] newMap = new int[map.length + 1][map[0].length + 1];
		for (int i = 0; i < newMap.length; i++) {
			for(int j = 0; j < newMap[0].length; j++) 
				if (i == 0 || j == 0) {
					newMap[i][j] = 0;
				} else {
					newMap[i][j] = map[i-1][j-1];
				}
		}

		int counter = 0;

		for(int i = 0; i < newMap.length; i++) {
			for(int j = 0; j < newMap[0].length; j++) {
				if (newMap[i][j] == 1 && newMap[i-1][j] == 0 && newMap[i][j-1] == 0) {
					counter += 1;
				}
			}
		}
		return counter;
	}


	public static void main(String[] args) {

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
				//System.out.print(map[i][j]);
			}
			//System.out.printf("\n");
		}

		//System.out.print(Arrays.toString(out));
		//System.out.print(Arrays.toString(map[0]));
		System.out.println(numIsland(map));
	}
}
