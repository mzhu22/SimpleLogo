package displayCommands;

import frontend.Turtle;

public class HideTurtle extends DisplayNode {

	public HideTurtle(){
		super(0); 
	}


	@Override
	protected void doAction(Turtle turtle) {
		turtle.hideTurtle();
	}

	@Override
	public double evaluate() {
		return ZERO;
	}

}
