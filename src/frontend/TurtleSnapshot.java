package frontend;

/**
 * Passive data object representing a snapshot
 * of a turtle's current data that is passed
 * for the backend's queries.
 *
 */
public class TurtleSnapshot {

	private static TurtleSnapshot instance;
	
	private Turtle myTurtle;
	public double xCor;
	public double yCor;
	public double direction;
	public boolean penDown;
	public boolean showing;
	
	private TurtleSnapshot(Turtle turtle) {
		myTurtle = turtle;
		xCor = myTurtle.getX();
		yCor = myTurtle.getY();
		direction = myTurtle.getDirection();
		penDown = myTurtle.getPen().isPenDown();
		showing = myTurtle.isShowing();
	}
		
	public static TurtleSnapshot getTurtleSnapshot(Turtle turtle){
		if (instance == null){
			instance = new TurtleSnapshot(turtle);
		}
		return instance;
	}
	
	public static void update(Turtle turtle){
		instance = new TurtleSnapshot(turtle);
	}
}
