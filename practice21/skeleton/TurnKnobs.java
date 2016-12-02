// This program reads in information of a number of knobs.
// For each knob, its current state, current position and
// target position. It then computes the state of each knob after
// the required number of stops, and the total stops of all knobs.

// Add import statement(s) below
import java.util.*;

public class TurnKnobs{

	public static void main(String[] args){


		// Declare the necessary variables
		// eg: ArrayList<Knob> knobs = new ... (complete the line)
		ArrayList<Knob> knobs = new ArrayList<Knob>();


		// Read input and process them accordingly
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num-- > 0) {
			String temp = sc.next();
			if (temp.equals("on")) {
				knobs.add(new Knob(true, sc.next(), sc.next()));
			} else {
				knobs.add(new Knob(false, temp, sc.next()));
			}
		}

		// Output the result
		// Use the given println() statements below to ensure that 
		// your outputs are in the right format.

		int move = 0;
		// Print result for each knob 	 
		for (Knob elem: knobs) {
			move += elem.numOfMoves();
			if (elem.deviceIsOn(elem.numOfMoves())) {
				System.out.println("on");
			} else {
				System.out.println("off");
			}
		}
		// Print total number of stops 

		System.out.println("Total stop(s) = " + move);
	}
}

