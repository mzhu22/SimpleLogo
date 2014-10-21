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
	
	public To(){
		numChildren = 2; 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myInfo = 0;
		
		
		doNothing temp = (doNothing) getLeft();
		String functionName = temp.getIdentifier();
		
		UserFunctionNodeMap.addFunction(functionName, getRight());

		System.out.println(UserFunctionNodeMap.keySet().size());
		return myInfo;
	}
}
