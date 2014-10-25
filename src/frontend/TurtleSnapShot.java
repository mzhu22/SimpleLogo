package frontend;

/**
 * Passive data object representing a snapshot
 * of a turtle's current data that is passed
 * for the backend's queries.
 *
 */
public class TurtleSnapShot {

	private Turtle myTurtle;
	public double xCor;
	public double yCor;
	public double direction;
	public boolean penDown;
	public boolean showing;
	
	
	public TurtleSnapShot(Turtle turtle) {
		myTurtle = turtle;
		xCor = myTurtle.getX();
		yCor = myTurtle.getY();
		direction = myTurtle.getDirection();
		penDown = myTurtle.getPen().isPenDown();
		showing = myTurtle.isShowing();
	}
}
