package frontend;

/**
 * Passive singleton representing a snapshot
 * of a turtle's current data that is passed
 * for the backend's queries.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class TurtleSnapshot {

	private static TurtleSnapshot instance;
	public double xCor;
	public double yCor;
	public double direction;
	public boolean penDown;
	public boolean showing;
	public int id;
	
	/**
	 * Constructor, sets up all data.
	 * @param turtle The turtle to copy data from.
	 */
	private TurtleSnapshot(Turtle turtle) {
		xCor = turtle.getX();
		yCor = turtle.getY();
		direction = turtle.getDirection();
		penDown = turtle.getPen().isPenDown();
		showing = turtle.isShowing();
		id = turtle.getID();
	}
	
	/**
	 * Gets a turtle snapshot from the given turtle.
	 * @param turtle The turtle to get information from.
	 * @return The turtle snapshot from the given turtle.
	 */
	public static TurtleSnapshot getTurtleSnapshot(Turtle turtle){
		if (instance == null){
			instance = new TurtleSnapshot(turtle);
		}
		return instance;
	}
	
	/**
	 * Updates the instance of the turtle snapshot.
	 * @param turtle The turtle to get data from.
	 */
	public static void update(Turtle turtle){
		instance = new TurtleSnapshot(turtle);
	}
}
