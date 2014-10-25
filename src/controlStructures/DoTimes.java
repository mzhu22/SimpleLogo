package controlStructures;

import java.util.ArrayList;
import java.util.List;

import displayCommands.DisplayNode;
import expressionTree.ExpressionNode;
import expressionTree.ListNode;

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
		
		for(int i =1 ; i <= myLeft.getListContents().get(1).getInfo(); i++){
			instructionList.addAll(getRight().makeInstructionList());
			myLeft.getListContents().get(0).setInfo(i);			
		}
		
		return instructionList;
}
	
	
}
