package turtleQueries;

public class IsShowing extends TurtleQuery{

	public IsShowing() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myTurtle.isShowing() ? 1:0;
	}
}
