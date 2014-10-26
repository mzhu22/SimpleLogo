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
 * @author Mike Zhu
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
		getLeft().evaluate();
		getRight().evaluate();
		return 0;
	}

	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();
		ListNode myLeft = (ListNode) getLeft(); 
		
		for(int i =1 ; i <= myLeft.getListContents().get(1).getValue(); i++){
			instructionList.addAll(getRight().makeInstructionList());
			myLeft.getListContents().get(0).setValue(i);			
		}
		
		return instructionList;
}
	
	
}
