package TurtleQueries;

import frontend.Turtle;
import CommandAbstractClasses.TurtleQuery;

public class XCor extends TurtleQuery {

	public XCor(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		// somehow get the turtle's x-coordinate
		return myActionable.getX();
	}
}
