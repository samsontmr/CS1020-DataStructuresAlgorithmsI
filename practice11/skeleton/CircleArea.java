// This program reads the length of a side of a square and
// computes the area of the circle that encloses the square.

// Add import statement(s) below
import java.util.*;
import java.text.DecimalFormat;

public class CircleArea {

	// You are to write a circleArea(double r) method to 
	// return the area of a circle of radius r.
	public static double circleArea(double r) {
		//precond: r must be non-negative
		//postcond: area of circle is returned
		double area;
		area = Math.pow(r, 2) * Math.PI;
		return area;
	}

	public static void main(String[] args) {
		// Fill in the code below
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter side of square: ");
		double side = sc.nextDouble();
		double r = Math.sqrt(Math.pow(side, 2) * 2)/2;
		double area = circleArea(r);
		
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Area of circle = " + df.format(area));
	}
}

