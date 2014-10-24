package controlStructures;

import ExpressionTree.ExpressionNode;
import ExpressionTree.UserFunctionNodeMap;
import ExpressionTree.doNothing;

/**
 * Used when the user wants to define custom functions
 * @author Mike Zhu
 *
 */
public class To extends ExpressionNode{
	
	private UserFunctionNodeMap myUserFunctions;
	
	public To(){
		super(2); 
		myUserFunctions = UserFunctionNodeMap.getUserFunctionNodeMap();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myValue = 0;
		
		doNothing temp = (doNothing) getLeft();
		String functionName = temp.getIdentifier();
		
		myUserFunctions.addFunction(functionName, getRight());

		return myValue;
	}
}
