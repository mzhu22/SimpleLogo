package controlStructures;


import frontend.ActionObject;
import FundamentalInstructions.FundamentalInstruction;

public class Repeat extends FundamentalInstruction{
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo = getLeft().evaluate();
	}

	public void doAction(ActionObject turtle) {
		for(int i=0; i<myInfo; i++){
			// TODO: fix casting?
			// The getRight should always be a FundamentalInsturction? 
			((FundamentalInstruction) getRight()).doAction(turtle);
		}
	}

}
