package displayCommands;

import frontend.Turtle;


public class Right extends DisplayNode {


	public Right() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return(myValue = myLeft.evaluate());
	}

	@Override
	public void doAction(Turtle turtle) {
		turtle.rotate(-myValue);
	}

}
