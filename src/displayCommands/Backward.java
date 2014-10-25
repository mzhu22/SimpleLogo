package displayCommands;

import frontend.Turtle;


public class Backward extends DisplayNode {

	public Backward() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Turtle turtle) {
		turtle.move(-myValue);
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (myValue = myLeft.evaluate());
	}


}
