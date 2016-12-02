// Testing the Scanner class.
// This program reads the name, age and vaccination status of
// some children and computes their average age and percentage
// of children who are vaccinated.

// Add import statement(s) below
import java.util.*;
import java.text.DecimalFormat;

public class Vaccination {

	public static void main(String[] args) {
		String name;
		int num, age, totalAge = 0;
		boolean vaccinated;
		int numVaccinated = 0; 

		// Fill in the code below
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of children: ");
		num = Integer.parseInt(sc.nextLine());
		System.out.println("Number of children is " + num);
		for (int i = 0; i < num; i++) {
			System.out.print("Name: ");
			name = sc.nextLine();
			System.out.println("Name is \"" + name + "\"");
			System.out.print("Age: ");
			age = Integer.parseInt(sc.nextLine());
			totalAge += age;
			System.out.println("Age is " + age);
			System.out.print("Vaccinated for chickenpox? ");
			vaccinated = Boolean.parseBoolean(sc.nextLine());
			if (vaccinated) {
				numVaccinated += 1;
				System.out.println("Vaccinated for chickenpox");
			} else {
				System.out.println("Not vaccinated for chickenpox");
			}
		}

		double avgAge = (double) totalAge / (double) num;
		double percentVac = ((double) numVaccinated / (double) num);
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat pdf = new DecimalFormat("0.00%");
		System.out.println("Average age is " + df.format(avgAge));
		System.out.println("Percentage of children vaccinated is " + pdf.format(percentVac));

	}
}

