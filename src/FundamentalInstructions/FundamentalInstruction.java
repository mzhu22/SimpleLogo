package FundamentalInstructions;

import ExpressionTree.ExpressionNode;

public abstract class FundamentalInstruction extends ExpressionNode{
	 
	protected static String myCode; //Change for different languages later
	protected static final int ONE = 1; 
	protected static final int ZERO = 0; 


	public FundamentalInstruction(ExpressionNode right ){
		super(right, null); 
		
	}


	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
	
		toRet.append(myCode + " :" + myInfo); 	
		return toRet.toString(); 
	}

	public abstract void doAction();
	
	// TO DO pass doaction actionable frontend object

	
}

