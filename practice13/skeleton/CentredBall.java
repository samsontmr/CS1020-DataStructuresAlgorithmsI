// CentredBall class:
//   Class attribute: quantity - number of balls created
//   Instance attributes: colour, radius, centre
import java.awt.*;

class CentredBall {

	/************** Data members **********************/
	private static int quantity = 0; 

	private String colour;
	private double radius;
	private Point  centre;

	/************** Constructors **********************/
	CentredBall() {
		this("yellow", 10.0, 0, 0); 
	}

	CentredBall(String colour, double radius, Point centre) {
		setColour(colour);
		setRadius(radius);
		setCentre(centre);
		quantity++;
	}

	CentredBall(String colour, double radius, int xCoord, int yCoord) {
		setColour(colour);
		setRadius(radius);
		setCentre(xCoord, yCoord);
		quantity++;
	}
	/**************** Accessors ***********************/
	public String getColour() { return this.colour; }

	public double getRadius() { return this.radius; }

	public Point getCentre() { return this.centre; }
	

	/**************** Mutators ************************/
	public void setColour(String newColour) { this.colour = newColour; }

	public void setRadius(double newRadius) { this.radius = newRadius; }
	
	public void setCentre(Point newCentre) { this.centre = newCentre; }

	public void setCentre(int newX, int newY) { this.centre = new Point(newX, newY); }


	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return "[colour=" + getColour() 
				+ ", radius=" + getRadius() 
				+ ", centre=(" + (int) centre.getX() 
				+ "," + (int) centre.getY()+ ")]";


	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if (obj instanceof CentredBall) {
			CentredBall ball = (CentredBall) obj;
			return this.getColour().equals(ball.getColour())
					&& this.getRadius() == ball.getRadius()
					&& this.getCentre().equals(ball.getCentre());
		} else {
			return false;
		}
	}
}

