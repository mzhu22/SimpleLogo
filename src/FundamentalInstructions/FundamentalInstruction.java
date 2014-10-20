package FundamentalInstructions;

import frontend.Turtle;
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

	public abstract void doAction(Turtle turtle);
	
	// TO DO pass doaction actionable frontend object
	
	

}

