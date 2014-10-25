package displayCommands;

import java.util.ArrayList;
import java.util.List;

import expressionTree.ExpressionNode;
import expressionTree.ListNode;
import frontend.Turtle;

public class Tell extends DisplayNode{
	
	private List<Double> toTell; 
	public Tell() {
		super(1);
		toTell = new ArrayList<>(); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Turtle turtle) {
		// TODO Auto-generated method stub	
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myLeft.evaluate();
		ListNode myListNode = (ListNode) getLeft(); 
		List<ExpressionNode> temp = myListNode.getListContents(); 
		for( ExpressionNode node : temp){
			toTell.add(node.getInfo()); 
		}
		return myValue = toTell.get(toTell.size() -1); 
	}
	
	@Override
	public List<DisplayNode> makeInstructionList(){

		List<DisplayNode> instructionList = new ArrayList<>();	
		return instructionList;
	}

}
