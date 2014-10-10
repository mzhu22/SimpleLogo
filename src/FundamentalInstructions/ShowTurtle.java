package FundamentalInstructions;

import frontend.ActionObject;

public class ShowTurtle extends FundamentalInstruction {


	public ShowTurtle(){
		
		numChildren = 0; 
	}
	
	@Override
	public void doAction(ActionObject turtle) {
		turtle.showTurtle();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ONE;
	}

}
