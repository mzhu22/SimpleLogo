//This entire file is part of my masterpiece.
//Dimeji Abidoye
package controlStructures;

import java.util.ArrayList;
import java.util.List;

import displayCommands.DisplayNode;
import expressionTree.ExpressionNode;

/**
 * Special case of a node with 3 children. Left is the expression. Middle is command set 1,
 * Right is command set 2. If Left evaluates to 1, run Middle, else run Right.
 * @author Mike Zhu
 *
 */

public class IfElse extends ExpressionNode {
 
	private static final int MY_ELSE_CHILD = 2;  
	
	public IfElse() {
		super(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		if (getChild(MY_LEFT_CHILD).evaluate() !=0 )  return myValue = getChild(MY_RIGHT_CHILD).evaluate();
		 else return myValue =  getChild(MY_ELSE_CHILD).evaluate() ; 
	}

	
	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();
		
		if (getChild(MY_LEFT_CHILD).evaluate() !=0 )  instructionList.addAll(getChild(MY_RIGHT_CHILD).makeInstructionList());
		else instructionList.addAll(getChild(MY_ELSE_CHILD).makeInstructionList());
		return instructionList;
}

}
