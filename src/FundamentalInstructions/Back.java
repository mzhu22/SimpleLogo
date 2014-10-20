package FundamentalInstructions;

import frontend.Turtle;


public class Back extends FundamentalInstruction {

	@Override
	public void doAction(Turtle turtle) {
		turtle.move(-myInfo);
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (myInfo = myLeft.evaluate());
	}


}
