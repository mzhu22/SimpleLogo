package displayCommands;

import displayCommands.DisplayNode;
import frontend.Turtle;

public class Home extends DisplayNode {

	public Home() {
		super(0);
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.resetPosition();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
