package turtleQueries;

import commandAbstractClasses.TurtleQuery;

import frontend.Turtle;

public class Pendown extends TurtleQuery {

	public Pendown(Turtle turtle) {
		super(turtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		// return 1 if pendown, 0 otherwise
		return myTurtle.getPen().isPenDown() ? 1:0;
	}
}
