package FundamentalInstructions;

import frontend.ActionObject;

public class Towards extends FundamentalInstruction {

	public Towards(){

		numChildren = 2; 
	}


	@Override
	public void doAction(ActionObject turtle) {
		turtle.setDirection(myInfo);

	}

	@Override
	public double evaluate() {
		// TODO make this return the number of degrees turned?? how??
		return 0;
	}

}
