package TurtleQueries;

import frontend.Turtle;
import CommandAbstractClasses.TurtleQuery;

public class Showing extends TurtleQuery{

	public Showing(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myActionable.isTurtle() ? 1:0;
	}
}
