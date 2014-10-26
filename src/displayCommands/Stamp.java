package displayCommands;

import turtleClasses.Turtle;

public class Stamp extends DisplayNode {

	public Stamp() {
		super(0);
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.stamp();
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
