package displayCommands;

import frontend.Turtle;


public class Right extends DisplayNode {


	public Right() {
		super(1);
	}

	@Override
	public double evaluate() {
		return(myValue = myLeft.evaluate());
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.rotate(-myValue);
	}

}
