package frontend;

/**
 * Passive data object representing a snapshot
 * of a turtle's current data that is passed
 * for the backend's queries.
 *
 */
public class TurtleSnapshot {

	private static TurtleSnapshot instance;
	
	public double xCor;
	public double yCor;
	public double direction;
	public boolean penDown;
	public boolean showing;
	
	private TurtleSnapshot(Turtle turtle) {
		xCor = turtle.getX();
		yCor = turtle.getY();
		direction = turtle.getDirection();
		penDown = turtle.getPen().isPenDown();
		showing = turtle.isShowing();
	}
		
	public static TurtleSnapshot getTurtleSnapshot(Turtle turtle){
		if (instance == null){
			instance = new TurtleSnapshot(turtle);
		}
		else{
			instance.update(turtle);
		}
		return instance;
	}
	
	public void update(Turtle turtle){
		instance = new TurtleSnapshot(turtle);
	}
}
