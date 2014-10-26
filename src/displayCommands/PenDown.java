package displayCommands;

import turtleClasses.Turtle;


public class PenDown extends DisplayNode {

	public PenDown (){
		
		super(0); 
	}
	
	

	@Override
	public double evaluate() {
		return ONE;
	}



	@Override
	protected void doAction(Turtle turtle) {
		turtle.getPen().penDown();
	}

}
