package displayCommands;

import frontend.Turtle;


public class Backward extends DisplayNode {

	public Backward() {
		super(1);
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.move(-myValue);
	}

	@Override
	public double evaluate() {
		return (myValue = myLeft.evaluate());
	}


}
