package FundamentalInstructions;

import ExpressionTree.ExpressionNode;
import frontend.Turtle;

public abstract class FundamentalInstruction extends ExpressionNode{
	
	
	public FundamentalInstruction() {
		super(1); 
	}
	
	protected static final int ONE = 1; 
	protected static final int ZERO = 0; 

	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
	
		toRet.append(getClass().toString() + " :" + myInfo); 	
		return toRet.toString(); 
	}

	public abstract void doAction(Turtle turtle);
	
	// TO DO pass doaction actionable frontend object	

}

