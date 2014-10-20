package TurtleQueries;

import CommandAbstractClasses.TurtleQuery;
import frontend.Turtle;

public class Showing extends TurtleQuery{

	public Showing(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myTurtle.isShowing() ? 1:0;
	}
}
