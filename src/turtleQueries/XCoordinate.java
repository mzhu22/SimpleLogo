package turtleQueries;

import turtleClasses.TurtleSnapshot;

public class XCoordinate extends TurtleQuery {

	public XCoordinate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		// somehow get the turtle's x-coordinate
		return TurtleSnapshot.getTurtleSnapshot().xCor;
	}
}
