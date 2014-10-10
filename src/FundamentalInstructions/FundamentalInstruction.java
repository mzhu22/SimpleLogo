package FundamentalInstructions;

import frontend.ActionObject;
import ExpressionTree.ExpressionNode;

public abstract class FundamentalInstruction extends ExpressionNode{
	
	
	public FundamentalInstruction() {
		numChildren = 1; 
	}
	
	protected static String myCode; //Change for different languages later
	protected static final int ONE = 1; 
	protected static final int ZERO = 0; 

	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
	
		toRet.append(myCode + " :" + myInfo); 	
		return toRet.toString(); 
	}

	public abstract void doAction(ActionObject turtle);
	
	// TO DO pass doaction actionable frontend object
	
	

}

