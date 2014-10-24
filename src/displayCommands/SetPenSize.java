package displayCommands;

import frontend.Turtle;

public class SetPenSize extends DisplayNode{

	public SetPenSize() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Turtle turtle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = myLeft.evaluate();
	}

}
