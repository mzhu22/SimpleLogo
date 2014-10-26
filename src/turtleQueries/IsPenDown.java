package turtleQueries;

import turtleClasses.TurtleSnapshot;

public class IsPenDown extends TurtleQuery {

	public IsPenDown() {
		super();
	}

	@Override
	public double evaluate() {
		// return 1 if pendown, 0 otherwise
		return (TurtleSnapshot.getTurtleSnapshot().penDown) ? 1 : 0;
	}
}
