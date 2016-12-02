// This program reads integer coordinates of 3 points and creates
// 3 Point objects. It then computes the centroid of a triangle
// having these 3 points as its vertices.

// Add the import statement(s) below
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class TriangleCentroid {

	// Returns the centroid of a triangle with 
	// 3 vertices v1, v2 and v3
	public static Point2D.Double centroid(Point v1, Point v2, Point v3) {
		double avgX, avgY;
		avgX = 0;
		avgY = 0;
		Point[] arr = {v1, v2, v3};

		for (int i = 0; i < 3; i++) {
			avgX += arr[i].getX();
			avgY += arr[i].getY();
		}

		avgX /= 3;
		avgY /= 3;

		Point2D.Double point = new Point2D.Double(avgX, avgY);
		return point;
	}

	public static void main(String[] args) {
		// Fill in the code 
		Point v1, v2, v3;
		int[] arr = new int[6];
		System.out.print("Enter 3 vertices: ");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextInt();
		}
		
		v1 = new Point(arr[0], arr[1]);
		v2 = new Point(arr[2], arr[3]);
		v3 = new Point(arr[4], arr[5]);

		System.out.println("Centroid at " + centroid(v1, v2, v3));
	}
}

