package FundamentalInstructions;

import frontend.ActionObject;


public class Back extends FundamentalInstruction {

	@Override
	public void doAction(ActionObject turtle) {
		turtle.move(-myInfo);
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (myInfo = myLeft.evaluate());
	}


}
