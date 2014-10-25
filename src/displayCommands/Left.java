package displayCommands;

import frontend.Turtle;


public class Left extends DisplayNode {

	public Left() {
		super(1);
	}

	@Override
	public double evaluate() {
		return myValue = myLeft.evaluate();
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.rotate(myValue);
	}


}
