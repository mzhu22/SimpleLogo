// This entire file is part of my masterpiece.
// Dimeji Abidoye

package controlStructures;

import expressionTree.ExpressionNode;
import expressionTree.ListNode;
import expressionTree.UnrecognizedFunction;
import expressionTree.UserFunctionMap;

/**
 * Used when the user wants to define custom functions. Depends on the ListNode class 
 * (for defining commands within brackets []) and of course the UserFunctionMap class,
 * in which user defined functions and their String identifiers are stored. 
 * @author Dimeji Abidoye
 *
 */
public class MakeUserInstruction extends ExpressionNode{
	
	private static final int MY_FUNCTION = 0; 
	private static final int MY_VARIABLES = 1; 
	private static final int MY_COMMANDS = 2; 
	
	public MakeUserInstruction(){
		super(3); 
	}

	@Override
	public double evaluate() {
		evaluateChild(MY_VARIABLES); 
		UserFunctionMap map = UserFunctionMap.getUserFunctionMap();
		map.addFunction( ((UnrecognizedFunction) getChild(MY_FUNCTION)).getIdentifier(), (ListNode) getChild(MY_COMMANDS));
		return myValue; 
	}
	
}
