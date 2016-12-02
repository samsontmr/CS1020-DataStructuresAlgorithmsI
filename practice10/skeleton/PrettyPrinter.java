// This program reads a string, removes all its heading and
// trailing spaces, and replaces every block of consecutive
// spaces with a single space.

// Add import statement(s) below
import java.util.*;

public class PrettyPrinter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a line below:");
		String line = sc.nextLine();
//		String[] lineArr = line.trim().split("\\s");
		String newLine = line.trim().replaceAll("\\s+"," ");
//		if (lineArr.length > 1) {
//			for (int i = 1; i < lineArr.length - 1; i++) {
//				if (lineArr[i].contains(" ")) {
//					lineArr[i] = lineArr[i].trim();
//					newLine = newLine.concat(lineArr[i] + " ");
//					System.out.println("|" + newLine + "|");
//				}
//			}
//			newLine = newLine.concat(lineArr[lineArr.length - 1]);
//		}
		System.out.println("Pretty-printed line:");
		System.out.println("|" + newLine + "|");
	}
}

