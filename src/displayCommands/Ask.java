// This entire file is part of my masterpiece.
// Dimeji Abidoye

package displayCommands;

import java.util.ArrayList;
import java.util.List;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;
import expressionTree.ExpressionNode;
import expressionTree.ListNode;

public class Ask extends DisplayNode {

	private List<Double> toAsk;
	private ListNode myCommandsListNode; 
	private ListNode myTurtleList; 
	public Ask() {
		super(2);
		toAsk = new ArrayList<>(); 
	}
	
	@Override
	public void doAction(TurtleCollection turtles)
	{
		List<Integer> turtlesToAsk = new ArrayList<Integer>();
		for(Double d : toAsk)
		{
			turtlesToAsk.add(d.intValue());
		}
		turtles.setActiveTurtles(turtlesToAsk);
	}

	@Override
	protected void doAction(Turtle turtle) {
		
	}

	@Override
	public double evaluate() {
		evaluateAllChildren(); 
		myCommandsListNode = (ListNode) getChild(MY_RIGHT_CHILD); 
		myTurtleList = (ListNode) getChild(MY_LEFT_CHILD); 
		
		List<ExpressionNode> temp = myTurtleList.getListContents(); 
		for( ExpressionNode node : temp){
			toAsk.add(node.getValue()); 
		}
		return myValue = myCommandsListNode.getListContents().get(myCommandsListNode.getListContents().size() - 1).getValue(); 		
	}
	
	@Override
	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();
		instructionList.add(this);
		return instructionList;
	}
}
