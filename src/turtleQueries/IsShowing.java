package turtleQueries;

import commandAbstractClasses.TurtleQuery;

import frontend.Turtle;

public class IsShowing extends TurtleQuery{

	public IsShowing(Turtle actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myTurtle.isShowing() ? 1:0;
	}
}
