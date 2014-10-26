package turtleQueries;

import turtleClasses.TurtleSnapshot;

public class YCoordinate  extends TurtleQuery {

	public YCoordinate() {
		super();
	}

	@Override
	public double evaluate() {
		return TurtleSnapshot.getTurtleSnapshot().yCor;
	}
}
