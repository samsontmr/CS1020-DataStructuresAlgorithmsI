// To test out CentredBall class 

// Add import statement(s) below
import java.util.*;

public class TestCentredBall {

	// This method reads ball's input data from user, creates
	// a ball object, and returns it to the caller.
	public static CentredBall readBall(Scanner sc) {

		System.out.print("Enter colour, radius and centre: ");
		String inputColour = sc.next();
		double inputRadius = sc.nextDouble();
		int inputX = sc.nextInt();
		int inputY = sc.nextInt();
	
		CentredBall output = new CentredBall(inputColour, inputRadius, inputX, inputY);
		return output;
		// Fill in the code

	}

	public static CentredBall largestBall(CentredBall b1, CentredBall b2, CentredBall b3) {

		CentredBall[] set = {b1, b2, b3};
		int largest = 0;
		for (int i = 0; i < 3; i++) {
			if (set[i].getRadius() > set[largest].getRadius()) {
				largest = i;
			}
		}

		return set[largest];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input and create 1st ball object
		System.out.println("1st ball");
		CentredBall b1 = readBall(scanner);

		// Read input and create 2nd ball object
		System.out.println("2nd ball");
		CentredBall b2 = readBall(scanner);

		// Read input and create 3rd ball object
		System.out.println("3rd ball");
		CentredBall b3 = readBall(scanner);

		System.out.println("\n1st and 2nd balls are" + (!b1.equals(b2) ? " not " : " ") + "the same.");
		System.out.println("The largest ball created is:");
		System.out.println(largestBall(b1, b2, b3).toString());
	}
}

