package displayCommands;

import java.util.ArrayList;
import java.util.List;

import expressionTree.ExpressionNode;
import expressionTree.ListNode;
import frontend.Turtle;

public class Ask extends DisplayNode {

	private List<Double> toAsk;
	private ListNode myCommandsListNode; 
	private ListNode myTurtleList; 
	public Ask() {
		super(2);
		toAsk = new ArrayList<>(); 
	}

	@Override
	public void doAction(Turtle turtle) {
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myRight.evaluate(); 
		myLeft.evaluate();
		myCommandsListNode = (ListNode) myRight; 
		myTurtleList = (ListNode) myLeft; 
		
		List<ExpressionNode> temp = myTurtleList.getListContents(); 
		for( ExpressionNode node : temp){
			toAsk.add(node.getValue()); 
		}
		return myValue = myCommandsListNode.getListContents().get(myCommandsListNode.getListContents().size() - 1).getValue(); 		
	}
	
	@Override
	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();	 
		return instructionList;
	}
}
