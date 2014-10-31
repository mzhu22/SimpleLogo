package controlStructures;

import java.util.Stack;

import expressionTree.ExpressionNode;
import expressionTree.ListNode;
import expressionTree.UnrecognizedFunction;
import expressionTree.UserFunctionMap;

/**
 * Used when the user wants to define custom functions. Depends on the ListNode class 
 * (for defining commands within brackets []) and of course the UserFunctionMap class,
 * in which user defined functions and their String identifiers are stored. 
 * @author Mike Zhu
 *
 */
public class MakeUserInstruction extends ExpressionNode{
	
	private UnrecognizedFunction myFunction;
	private ListNode myVariables; 
	private ListNode myCommands; 
	
	
	public MakeUserInstruction(){
		super(3); 
	}

	@Override
	public double evaluate() {
		myVariables.evaluate(); 
//		myCommands.evaluate(); 
		UserFunctionMap map = UserFunctionMap.getUserFunctionMap();
		map.addFunction(myFunction.getIdentifier(), myCommands);
		
//		System.out.println(myVariables.getListContents().size() + " blah");
//		System.out.println(myCommands.getListContents().size() + " blah"); 
		return 0; 
	}
	
	public void setChildren( Stack<ExpressionNode> childStack){
		myFunction = (UnrecognizedFunction) childStack.pop();
		numUnfilledChildren --; 
		myVariables = (ListNode) childStack.pop(); 
		numUnfilledChildren --; 
		myCommands = (ListNode) childStack.pop(); 
		numUnfilledChildren --; 
		childStack.push(this);
	}
	
}
