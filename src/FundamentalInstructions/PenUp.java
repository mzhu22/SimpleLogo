package FundamentalInstructions;

import frontend.ActionObject;



public class PenUp extends FundamentalInstruction {

	
	public PenUp() {
		
		numChildren = 0; 
	}
	
	@Override
	public void doAction(ActionObject turtle) {
		turtle.penUp();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ONE;
	}

}
