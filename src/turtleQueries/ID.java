package turtleQueries;

import frontend.TurtleSnapshot;

public class ID extends TurtleQuery{
	
	public ID(){
		super();
	}
	@Override
	public double evaluate() {
		return TurtleSnapshot.getTurtleSnapshot().id;
	}

}
