package controlStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import displayCommands.DisplayNode;
import expressionTree.ExpressionNode;

/**
 * Special case of a node with 3 children. Left is the expression. Middle is command set 1,
 * Right is command set 2. If Left evaluates to 1, run Middle, else run Right.
 * @author Mike Zhu
 *
 */

public class IfElse extends ExpressionNode {

	private ExpressionNode myMiddle ; 
	
	public IfElse() {
		super(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		if (myLeft.evaluate() !=0 )  return myValue = myMiddle.evaluate();
		 else return myValue =  myRight.evaluate() ; 
	}

	@Override 
	public void setChildren( Stack<ExpressionNode> childStack){
		setLeft(childStack.pop());
		setMiddle(childStack.pop()); 
		setRight(childStack.pop());
		childStack.push(this); 
	}
	
	private void setMiddle( ExpressionNode toSet){
		myMiddle = toSet; 
		numChildren --; 
	}
	
	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();

		if (myLeft.evaluate() !=0 )  instructionList.addAll(myMiddle.makeInstructionList());
		else instructionList.addAll(myRight.makeInstructionList());
		return instructionList;
}

}
