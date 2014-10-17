package frontend;

import java.util.List;

import ExpressionTree.ExpressionNode;
import FundamentalInstructions.FundamentalInstruction;

public class ActionObjectMover {

	private ActionObject myTurtle;
	
	public ActionObjectMover(ActionObject turtle) {
		myTurtle = turtle;
	}
	
	public void startDrawing(List<ExpressionNode> instructions){
		for(ExpressionNode n : instructions){
			((FundamentalInstruction)n).doAction(myTurtle);
		}
		
	}

}
