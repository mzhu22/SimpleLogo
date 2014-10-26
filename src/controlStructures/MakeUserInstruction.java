package controlStructures;

import java.util.Stack;

import expressionTree.ExpressionNode;
import expressionTree.ListNode;
import expressionTree.UnrecognizedFunction;
import expressionTree.UserFunction;
import expressionTree.UserFunctionMap;

/**
 * Used when the user wants to define custom functions
 * @author Mike Zhu
 *
 */
public class MakeUserInstruction extends ExpressionNode{
	
	private UnrecognizedFunction myFunction;
	private ListNode myVariables; 
	private ListNode myCommands; 
	
	
	public MakeUserInstruction(){
		super(2); 
	}

	@Override
	public double evaluate() {
		System.out.println("evaluating to"); 
//		myVariables.evaluate(); 
//		myCommands.evaluate(); 
		UserFunctionMap map = UserFunctionMap.getUserFunctionNodeMap();
		map.addFunction(myFunction.getIdentifier(), myCommands);
		
//		System.out.println(myVariables.getListContents().size() + " blah");
//		System.out.println(myCommands.getListContents().size() + " blah"); 
		return 0; 
	}
	
	public void setChildren( Stack<ExpressionNode> childStack){
		myFunction = (UnrecognizedFunction) childStack.pop();
		numChildren --; 
//		myVariables = (ListNode) childStack.pop(); 
//		numChildren --; 
		myCommands = (ListNode) childStack.pop(); 
		numChildren --; 
		childStack.push(this);
	}
	
}
