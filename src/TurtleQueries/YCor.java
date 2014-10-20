package TurtleQueries;

import frontend.Turtle;
import CommandAbstractClasses.TurtleQuery;

public class YCor  extends TurtleQuery {

	public YCor(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myActionable.getY();
	}
}
