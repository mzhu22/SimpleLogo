package turtleQueries;

import commandAbstractClasses.TurtleQuery;

import frontend.Turtle;

public class XCoordinate extends TurtleQuery {

	public XCoordinate(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		// somehow get the turtle's x-coordinate
		return myTurtle.getX();
	}
}
