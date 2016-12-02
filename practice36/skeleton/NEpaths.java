import java.util.*;

public class NEpaths {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter rows apart: ");
		int rows = sc.nextInt();
		System.out.print("Enter columns apart: ");
		int cols = sc.nextInt();

		String path = "";
		System.out.println("Number of paths = " + ne(rows, cols, path));
	}

	// To compute the number of NE paths as well as to display the paths
	public static int ne(int rows, int cols, String path) {
		// fill in your code here
		if (rows == 0 && cols == 0) {
			System.out.println(path);
			return 1;
		} 
		int count = 0;
		
		if (rows != 0) count += ne(rows-1, cols, path + "N ");
		
		if (cols != 0) count += ne(rows, cols-1, path + "E ");
		

		return count;


	}
}

