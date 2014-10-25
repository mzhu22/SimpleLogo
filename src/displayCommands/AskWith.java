package displayCommands;

import expressionTree.ListNode;
import frontend.Turtle;

public class AskWith extends DisplayNode{

	private ListNode myConditionListNode; 
	private ListNode myCommandsListNode; 
	public AskWith() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Turtle turtle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myRight.evaluate(); 
		myLeft.evaluate(); 
		myConditionListNode = (ListNode) myLeft; 
		myCommandsListNode = (ListNode) myRight; 
		return myValue = myCommandsListNode.getListContents().get(myCommandsListNode.getListContents().size() - 1).getValue(); 
	}

}
