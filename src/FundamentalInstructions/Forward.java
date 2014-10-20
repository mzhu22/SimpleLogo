package FundamentalInstructions;

import frontend.Turtle;

public class Forward extends FundamentalInstruction{


	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (myInfo = myLeft.evaluate());
	}

	@Override
	public void doAction(Turtle turtle) {
		turtle.move(myInfo);
		
	}
}
