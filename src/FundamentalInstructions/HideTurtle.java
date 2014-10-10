package FundamentalInstructions;

import frontend.ActionObject;

public class HideTurtle extends FundamentalInstruction {

	public HideTurtle(){
		
		numChildren = 0; 
	}


	@Override
	public void doAction(ActionObject turtle) {
		turtle.hideTurtle();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ZERO;
	}

}
