package turtleQueries;

import frontend.Turtle;

public class Heading extends TurtleQuery{
	
	public Heading() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		return myTurtle.getDirection();
	}
}
