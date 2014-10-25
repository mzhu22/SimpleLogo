package turtleQueries;

import commandAbstractClasses.TurtleQuery;

import frontend.Turtle;

public class Heading extends TurtleQuery{

	public Heading(Turtle turtle) {
		super(turtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		return myTurtle.getDirection();
	}
}
