package displayCommands;

import frontend.Turtle;

public class ShowTurtle extends DisplayNode {


	public ShowTurtle(){
		super(0); 
	}
	
	@Override
	public void doAction(Turtle turtle) {
		turtle.showTurtle();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ONE;
	}

}
