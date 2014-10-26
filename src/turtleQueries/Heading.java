package turtleQueries;

import turtleClasses.TurtleSnapshot;

public class Heading extends TurtleQuery{
	
	public Heading() {
		super();
	}

	@Override
	public double evaluate() {
		return TurtleSnapshot.getTurtleSnapshot().direction;
	}
}
