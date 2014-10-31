//This entire file is part of my masterpiece.
//Dimeji Abidoye

package controlStructures;


import java.util.ArrayList;
import java.util.List;

import displayCommands.DisplayNode;
import expressionTree.ExpressionNode;
import expressionTree.ListNode;

/**
 * Runs the commands stored in the Right node up to the limit stored in the Left node. 
 * The limit in the Left node is stored as a variable that can change value as the DoTimes
 * is run.
 * 
 * NOTE: under current design this is functionally the same as Repeat, as the left node
 * contains a constant value, rather than one that updates dynamically as DoTimes is run
 * @author Dimeji Abidoye
 *
 */
public class DoTimes extends ExpressionNode {

	public DoTimes() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		evaluateAllChildren(); 
		return myValue;
	}

	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();
		ListNode myLeft = (ListNode) getChild(MY_LEFT_CHILD); 
		
		for(int i =1 ; i <= myLeft.getListContents().get(1).getValue(); i++){
			instructionList.addAll(getChild(MY_RIGHT_CHILD).makeInstructionList());
			myLeft.getListContents().get(0).setValue(i);			
		}
		
		return instructionList;
}
	
	
}
