package displayCommands;

import turtleClasses.Turtle;

public class Forward extends DisplayNode{


	public Forward() {
		super(1);
	}

	@Override
	public double evaluate() {
		return (myValue = myLeft.evaluate());
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.move(myValue);
		
	}
}
