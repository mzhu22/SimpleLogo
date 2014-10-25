package displayCommands;

import frontend.Turtle;

public class ShowTurtle extends DisplayNode {


	public ShowTurtle(){
		super(0); 
	}
	
	@Override
	protected void doAction(Turtle turtle) {
		turtle.showTurtle();
	}

	@Override
	public double evaluate() {
		return ONE;
	}

}
