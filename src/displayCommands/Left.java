package displayCommands;

import frontend.Turtle;


public class Left extends DisplayNode {

	public Left() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = myLeft.evaluate();
	}

	@Override
	public void doAction(Turtle turtle) {
		turtle.rotate(myValue);
	}


}