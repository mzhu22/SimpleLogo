// This entire file is part of my masterpiece.
// Dimeji Abidoye

package displayCommands;

import turtleClasses.Turtle;
import expressionTree.ListNode;

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
		evaluateAllChildren(); 
		myConditionListNode = (ListNode) getChild(MY_LEFT_CHILD); 
		myCommandsListNode = (ListNode) getChild(MY_RIGHT_CHILD); 
		return myValue = myCommandsListNode.getListContents().get(myCommandsListNode.getListContents().size() - 1).getValue(); 
	}

}
