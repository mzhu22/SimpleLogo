package FundamentalInstructions;

import frontend.ActionObject;


public class Right extends FundamentalInstruction {


	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return(myInfo = myLeft.evaluate());
	}

	@Override
	public void doAction(ActionObject turtle) {
		turtle.rotate(-myInfo);
	}

}
