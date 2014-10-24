package displayCommands;

import frontend.Turtle;

public class HideTurtle extends DisplayNode {

	public HideTurtle(){
		super(0); 
	}


	@Override
	public void doAction(Turtle turtle) {
		turtle.hideTurtle();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ZERO;
	}

}
