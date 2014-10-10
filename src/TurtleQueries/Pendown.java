package TurtleQueries;

import frontend.ActionObject;
import CommandAbstractClasses.TurtleQuery;

public class Pendown extends TurtleQuery {

	public Pendown(ActionObject actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		// return 1 if pendown, 0 otherwise
		return myActionable.isPenDown() ? 1:0;
	}
}
