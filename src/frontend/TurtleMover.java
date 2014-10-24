package frontend;

import java.util.List;

import displayCommands.DisplayNode;
import ExpressionTree.ExpressionNode;

public class TurtleMover {

	private Turtle myTurtle;
	
	public TurtleMover(Turtle turtle) {
		myTurtle = turtle;
	}
	
	public void startDrawing(List<ExpressionNode> instructions){
		for(ExpressionNode n : instructions){
			((DisplayNode)n).doAction(myTurtle);
		}
		
	}

}
