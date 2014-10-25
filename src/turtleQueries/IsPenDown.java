package turtleQueries;

public class IsPenDown extends TurtleQuery {

	public IsPenDown() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		// return 1 if pendown, 0 otherwise
		return myTurtle.getPen().isPenDown() ? 1:0;
	}
}
