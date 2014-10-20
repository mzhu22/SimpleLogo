package FundamentalInstructions;

import frontend.Turtle;


public class Left extends FundamentalInstruction {

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo = myLeft.evaluate();
	}

	@Override
	public void doAction(Turtle turtle) {
		turtle.rotate(myInfo);
	}


}
