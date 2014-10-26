package turtleQueries;

import turtleClasses.TurtleSnapshot;

public class IsShowing extends TurtleQuery{

	public IsShowing() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (TurtleSnapshot.getTurtleSnapshot().showing) ? 1:0;
	}
}
