package TurtleQueries;

import CommandAbstractClasses.TurtleQuery;
import frontend.Turtle;

public class YCor  extends TurtleQuery {

	public YCor(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myTurtle.getY();
	}
}
