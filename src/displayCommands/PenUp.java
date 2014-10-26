package displayCommands;

import turtleClasses.Turtle;



public class PenUp extends DisplayNode {

	
	public PenUp() {
		
		super(0); 
	}
	
	@Override
	protected void doAction(Turtle turtle) {
		turtle.getPen().penUp();
	}

	@Override
	public double evaluate() {
		return ONE;
	}

}
