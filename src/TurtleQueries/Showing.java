package TurtleQueries;

import frontend.ActionObject;
import CommandAbstractClasses.TurtleQuery;

public class Showing extends TurtleQuery{

	public Showing(ActionObject actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myActionable.isTurtle() ? 1:0;
	}
}
