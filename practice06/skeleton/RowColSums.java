// RowColSums.java
// To compute the row and column sums of a 2D array.
import java.util.*;

public class RowColSums {

	public static int[] computeRowSums(int[][] arr2d) {
		int[] rowSums = new int[arr2d.length];
		int count = 0;
		for (int[] row: arr2d) {
			int sum = 0;
			for (int col: row) {
				sum += col;
			}
			rowSums[count] = sum;
			count++;
		}
		return rowSums;
	}

	public static int[] computeColSums(int[][] arr2d) {
		int[] colSums = new int[arr2d[0].length];

		for (int j = 0; j < colSums.length; j++) {
			int sum = 0;
			for (int i = 0; i < arr2d.length; i++) {
				sum += arr2d[i][j];
			}
			colSums[j] = sum;
		}
		return colSums;
	}
	public static void main(String[] args) {

		// code to read values into 2D array called 'array2D'
		int[][] array2D;
		int rows, cols;
		String[] rc;

		System.out.print("Enter number of rows and columns: ");
		Scanner sc = new Scanner(System.in);;
		rc = sc.nextLine().split("\\s");
		rows = Integer.parseInt(rc[0]);
		cols = Integer.parseInt(rc[1]);;

		array2D = new int[rows][cols];
		System.out.println("Enter values for 2D array:");
		for (int i = 0; i < rows; i++) {
			String[] rowIn = sc.nextLine().split("\\s");
			for (int j = 0; j < cols; j++) {
				array2D[i][j] = Integer.parseInt(rowIn[j]);
			}
		}

		int[] rowSums = computeRowSums(array2D);
		System.out.print("Row sums: ");
		System.out.println(Arrays.toString(rowSums));

		int[] colSums = computeColSums(array2D);
		System.out.print("Column sums: ");
		System.out.println(Arrays.toString(colSums));
	}

}
