package turtleQueries;

import commandAbstractClasses.TurtleQuery;

import frontend.Turtle;

public class YCoordinate  extends TurtleQuery {

	public YCoordinate(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myTurtle.getY();
	}
}
