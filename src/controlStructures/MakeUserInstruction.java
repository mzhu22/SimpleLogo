package controlStructures;

import java.util.Stack;

import expressionTree.ExpressionNode;
import expressionTree.ListNode;
import expressionTree.UserFunction;

/**
 * Used when the user wants to define custom functions
 * @author Mike Zhu
 *
 */
public class MakeUserInstruction extends ExpressionNode{
	
	private UserFunction myFunction;
	private ListNode myVariables; 
	private ListNode myCommands; 
	
	
	public MakeUserInstruction(){
		super(3); 
	}

	@Override
	public double evaluate() {
		System.out.println("evaluating to"); 
		myVariables.evaluate(); 
		myCommands.evaluate(); 
		 
		
		myFunction.setMyVariables(myVariables);
		System.out.println(myVariables.getListContents().size() + " blah");
		myFunction.setMyCommands(myCommands);
		System.out.println(myCommands.getListContents().size() + " blah"); 
		return 0; 
	
	}
	
	public void setChildren( Stack<ExpressionNode> childStack){
		myFunction = (UserFunction) childStack.pop();
		numChildren --; 
		myVariables = (ListNode) childStack.pop(); 
		numChildren --; 
		myCommands = (ListNode) childStack.pop(); 
		numChildren --; 
	
		
		
	
	}
	
}
